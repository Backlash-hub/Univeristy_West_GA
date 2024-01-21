from flask import Flask, request
from data.bakery_db import categories, products
from flask_smorest import abort
from flask_cors import CORS
import uuid

app = Flask(__name__)
CORS(app)

@app.get('/categories')
def get_categories():
    return {"categories": list(categories.values())}

@app.get("/categories/<string:category_id")
def get_category(category_id):
    try:
        return categories[category_id]
    except KeyError:
        abort(404, message="category not found.")
        
@app.post("/categories")
def create_categories():
    categories_data = request.get_json()
    if "category_name" not in categories_data:
        abort(
            400,
            message="Bad request. Ensure category name is included in the JSON payload"
        )
    
    for categories in categories.values():
        if categories_data["category_name"] == categories["category_name"]:
            abort(400, message="Category already exists.")
    
    category_id = uuid.uuid4().hex
    