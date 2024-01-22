from flask import Flask, request
from data.bakery_db import categories, products
from flask_smorest import abort
from flask_cors import CORS
import uuid

app = Flask(__name__)
CORS(app)

#Get all Categories
@app.get('/categories')
def get_categories():
    return {"categories": list(categories.values())}

#Get a Specific Category
@app.get("/categories/<int:category_id>")
def get_category(category_id):
    try:
        return categories[category_id]
    except (ValueError, KeyError):
        abort(404, message="category not found.")
        
#Create a Category
@app.post("/categories")
def create_category():
    request_data = request.get_json()
    
    if "category_name" not in request_data or request_data["category_name"] == "":
        abort(400, message="Category name is required and cannot be empty.")
    
    for category in categories.items():
        if category["category_name"] == request_data["category_name"]:
            abort(400, message="Category with the specified name already exists.")
    
    new_category = {"category_name": request_data["category_name"]}
    categories[request_data["category_name"]] = new_category
    return new_category, 201
    