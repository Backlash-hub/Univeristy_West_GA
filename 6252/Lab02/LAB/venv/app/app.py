from flask import Flask, request, abort
from data.bakery_db import categories, products

app = Flask(__name__)

#CATEGORIES

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
       return abort(404, description="Category ID not found.")

        
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
@app.delete("/categories/<int:category_id>")
def delete_category(category_id):
        
    if category_id not in categories:
        return abort(404, description="Category ID is not found")
    
    associated_products = [product for product in products.values() if product["category_id"] == category_id]
    if associated_products:
        return abort(400, description="Cannot delete category with associated products.")

    deleted_category = categories.pop(category_id)

    return {"message": "Category deleted successfully", "deleted_category": deleted_category}

#PRODUCTS

#Get all Products
@app.get('/products')
def get_products():
    return {"products": list(products.values())}

#Get a Specific Product
@app.get("/products/<int:product_id>")
def get_product_by_id(product_id):
    product = products.get(product_id)
    if products:
        return product
    else:
       return abort(404, description="Product ID not found.")
   
   #Create a Product
@app.post("/products")
def create_product():
    request_data = request.get_json()

    required_fields = ['category_id', 'product_code', 'product_name', 'price']
    if not all(field in request_data for field in required_fields):
        return abort(400, description="Bad request. JSON payload must include 'category_id', 'product_code', 'product_name', and 'price'.")

    # Check if the specified category ID exists
    category_id = int(request_data['category_id'])
    if category_id not in categories:
        return abort(400, description=f"Bad request. Category ID '{category_id}' does not exist.")

    # Determine the new product ID
    new_product_id = max(products.keys()) + 1

    # Create the new product
    new_product = {
        "product_id": new_product_id,
        "category_id": category_id,
        "product_code": request_data["product_code"],
        "product_name": request_data["product_name"],
        "price": request_data["price"]
    }

    # Add the new product to the products dictionary
    products[new_product_id] = new_product

    return new_product, 201  # Return the new product with status code 201 (Created)