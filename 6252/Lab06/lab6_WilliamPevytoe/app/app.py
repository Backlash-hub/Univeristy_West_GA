from flask import Flask, flash, request, redirect, render_template, url_for, session
from model.database import close_db
from model.categories_table import CategoriesTable
from model.products_table import ProductsTable
from model.customers_table import CustomersTable


app = Flask(__name__)
app.config["SECRET_KEY"] = "this is the secret string"


@app.errorhandler(404)
def page_not_found(error):
    return render_template("errors/404.html"), 404


@app.errorhandler(500)
def internal_server_error(error):
    return render_template("errors/500.html"), 500


@app.route("/login", methods=["GET", "POST"])
def login():
    if request.method == "POST":
        passcode = request.form["passcode"]
        if passcode != "bakery24":  # not the way to store and check a passcode
            error = "Invalid passcode."
            return render_template("login.html", error=error)
        session["logged_in"] = True
        return redirect(url_for("home"))
    else:
        return render_template("login.html")


@app.route("/logout")
def logout():
    session["logged_in"] = False
    return redirect(url_for("home"))

    
@app.get("/")
@app.get("/index")
def home():
    return render_template("index.html")


@app.route("/product")
def product_list():
    if "logged_in" not in session or not session["logged_in"]:
        return app.redirect(url_for("login"))

    # determine the selected category
    category_id_string = request.args.get("category_id")
    categories = CategoriesTable.get()
    if category_id_string and category_id_string.isdigit():
        category_id = int(category_id_string)
        if CategoriesTable.get_by_id(category_id) is None:
            category_id = categories[0]["CategoryID"]
    else:
        category_id = categories[0]["CategoryID"]

    products = ProductsTable.get_by_category_id(category_id)
    category = CategoriesTable.get_by_id(category_id)
    category_name = category["CategoryName"]

    return render_template(
        "product_list.html",
        category_name = category_name,
        categories = categories,
        products = products
    )


@app.route("/delete_product", methods=["POST"])
def delete_product():
    if "logged_in" not in session or not session["logged_in"]:
        return redirect(url_for("login"))

    category_id = request.form["category_id"]
    product_id = request.form["product_id"]
    ProductsTable.delete(product_id)
    return redirect(url_for("product_list", category_id=category_id))


@app.route("/category", methods=["GET", "POST"])
def category_list():
    if "logged_in" not in session or not session["logged_in"]:
        return redirect(url_for("login"))
    
    if request.method == "POST":
        category_name = request.form.get("category_name")
        if not category_name:
            flash("Category name is required.", "error")
        elif CategoriesTable.get_by_name(category_name) is not None:
            flash("Category already exists.", "error")
        else:
            CategoriesTable.insert({"category_name": category_name})
            flash("Category added successfully.", "success")
            return redirect(url_for("category_list"))

    categories = CategoriesTable.get()
        
    return render_template(
        "category_list.html", 
        categories=categories,
    )
    
@app.route('/delete_category', methods=["POST"])
def delete_category():
    if "logged_in" not in session or not session["logged_in"]:
        return redirect(url_for("login"))
    
    category_id = request.form.get("category_id")
    category = CategoriesTable.get_by_id(category_id)
    if category is None:
        flash("Category not found.", "error")
        return redirect(url_for("category_list"))

    # Check if category contains products
    products = ProductsTable.get_by_category_id(category_id)
    if products:
        flash("Cannot delete category with associated products.", "error")
        return redirect(url_for("category_list"))

    # Delete category
    success, message, deleted_category = CategoriesTable.delete(category_id)
    if success:
        flash(message, "success")
    else:
        flash(message, "error")
    return redirect(url_for("category_list"))

@app.route("/customer")
def customer_list():
    if "logged_in" not in session or not session["logged_in"]:
        return redirect(url_for("login"))

    # Retrieve list of customers sorted by last name
    customers = CustomersTable.get()

    return render_template(
        "customer_list.html",
        customers=customers,
    )


@app.teardown_appcontext
def close_connection(exception):
    close_db()
