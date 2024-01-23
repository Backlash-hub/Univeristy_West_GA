from flask import Flask, request, abort
from data.bakery_db import categories, products

app = Flask(__name__)


#Get all Categories
@app.get('/categories')
def get_categories():
    return {"categories": list(categories.values())}

#Get a Specific Category
@app.get("/categories/<int:category_id>")
def get_category_by_id(category_id):
    category = categories.get(category_id)
    if category:
        return categories[category_id]
    else:
       return abort(400, description="Category ID not found.")

        
#Create a Category
@app.post("/categories")
def create_category():
    request_data = request.get_json()

    if "category_name" not in request_data or request_data["category_name"] == "":
        return abort(400, description="Category name is required and cannot be empty.")

    for category in categories.values():
        if category["category_name"] == request_data["category_name"]:
            return abort(400, description="Category with the specified name already exists.")

    new_category_id = max(categories.keys()) + 1

    new_category = {
        "category_id": new_category_id,
        "category_name": request_data["category_name"]
    }

    categories[new_category_id] = new_category

    return new_category, 201 

#Delete a Category
@app.post("/categories")
def delete_category():
    