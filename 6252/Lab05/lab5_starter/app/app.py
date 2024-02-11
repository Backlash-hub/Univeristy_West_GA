from flask import Flask, render_template
from model.database import close_db
from model.products_table import ProductsTable
from model.categories_table import CategoriesTable
from model.customers_table import CustomersTable


app = Flask(__name__)


@app.errorhandler(404)
def page_not_found(error):
    return render_template("errors/404.html"), 404

@app.errorhandler(500)
def internal_server_error(error):
    return render_template("errors/InternalServer.html"), 500

@app.route("/")
@app.route("/index")
def home():
    return render_template("index.html")

@app.route("/order")
def order():
    return render_template("/errors/UnderConstruction.html")


@app.route("/product")
def product_list():
    products = ProductsTable.get()
    return render_template(
        "product_list.html",
        products = products
    )
    
@app.route("/category")
def category_list():
    categories = CategoriesTable.get()
    return render_template(
        "category_list.html",
        categories = categories
    )
    
@app.route("/customer")
def customer_list():
    customers = CustomersTable.get()
    return render_template(
        "customers.html",
        customers = customers
    )
    


@app.teardown_appcontext
def close_connection(exception):
    close_db()

