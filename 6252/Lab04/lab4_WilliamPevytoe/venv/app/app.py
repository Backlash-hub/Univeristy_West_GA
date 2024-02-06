from flask import Flask, request
from flask_cors import CORS
import sqlite3
from model.database import close_db
from model.categories_table import CategoriesTable
from model.products_table import ProductsTable


app = Flask(__name__)
CORS(app)


@app.get("/category")
def get_categories():
    try:
        categories = CategoriesTable.get()
        return {"categories": categories}
    except sqlite3.Error as error:
        return {"error": str(error)}, 500


@app.get("/category/<int:category_id>")
def get_category(category_id):
    try:
        category = CategoriesTable.get_by_id(category_id)
        if category is None:
            return {"message": "Category not found."}, 404
        return category
    except sqlite3.Error as error:
        return {"error": str(error)}, 500


@app.post("/category")
def create_category():
    category_data = request.get_json()
    try:
        success, message, category = CategoriesTable.insert(category_data)
        if not success:
            return {"error": message}, 400
        return category, 201
    except sqlite3.Error as error:
        return {"error": str(error)}, 500


@app.delete("/category/<int:category_id>")
def delete_category(category_id):
    try:
        category = CategoriesTable.delete(category_id)
        if category is None:
            return {"message": "Category not found."}, 404
        return {"message": "Category deleted."}
    except sqlite3.Error as error:
        return {"error": str(error)}, 500
    
@app.get("/product")
def get_products():
    try:
        products = ProductsTable.get()
        return {"products": products}
    except sqlite3.Error as error:
        return {"error": str(error)}, 500
    
@app.get("/product/<int:product_id>")
def get_product(product_id):
    try:
        product = ProductsTable.get_by_id(product_id)
        if product is None:
            return {"message": "Product not found."}, 404
        return product
    except sqlite3.Error as error:
        return {"error": str(error)}, 500
    
@app.post("/product")
def add_product():
    product_data = request.get_json()
    
    required_fields = ['category_id', 'product_code', 'product_name', 'price']
    if not all(field in product_data for field in required_fields):
        return {"error": "Missing required fields"}, 400
    
    # Check if the specified category ID exists
    category_id = product_data['category_id']
    category = CategoriesTable.get_by_id(category_id)
    if category is None:
        return {"error": "Category not found"}, 400
    
    try:
        success, message, product = ProductsTable.add_new_product(product_data)
        if not success:
            return {"error": message}, 400
        return product, 201
    except sqlite3.Error as error:
        return {"error": str(error)}, 500
    
@app.delete("/product/<int:product_id>")
def delete_product(product_id):
    try:
        product = ProductsTable.delete(product_id)
        if product is None:
            return {"message": "Product not found"}, 404
        return {"message": "Product was deleted"}
    except sqlite3.Error as error:
        return {"error": str(error)}, 500
    
@app.put("/product/<int:product_id>")
def update_product(product_id):
    product_data = request.get_json()
    
    # Ensure required fields are present in the request
    required_fields = ['category_id', 'product_code', 'product_name', 'price']
    if not all(field in product_data for field in required_fields):
        return {"error": "Missing required fields"}, 400
    
    # Check if the specified category ID exists
    category_id = product_data['category_id']
    category = CategoriesTable.get_by_id(category_id)
    if category is None:
        return {"error": "Category not found"}, 400
    
    try:
        success, message, product = ProductsTable.update(product_id, product_data)
        if not success:
            return {"error": message}, 404 if message == "Product not found." else 400
        return product, 200
    except sqlite3.Error as error:
        return {"error": str(error)}, 500
            
        
    

@app.teardown_appcontext
def close_connection(exception):
    close_db()
