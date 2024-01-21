from flask import Flask, request
from data.bakery_db import categories, products
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

@app.get('/categories')
def get_categories():
    return {"categories": list(categories.values())}

