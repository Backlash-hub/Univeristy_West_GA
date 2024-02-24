from flask import Flask, request, redirect, render_template, url_for, flash, session
from model.database import close_db
from model.categories_table import CategoriesTable
from model.products_table import ProductsTable
from model.customers_table import CustomersTable
from forms.product_forms import (
    DeleteProductButton, 
    EditProductButton, 
    EditProductForm
)
from forms.customer_form import DeleteCustomerButton
from forms.category_forms import DeleteCategoryButton
from forms.login_form import LoginForm


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
    login_form = LoginForm()
    if login_form.validate_on_submit():
        passcode = login_form.passcode.data
        if passcode == "bakery24":  # not the way to store and check a passcode
            session["logged_in"] = True
            return redirect(url_for("home"))
        login_form.passcode.errors.append("Invalid passcode.")
    return render_template("login.html", login_form=login_form)


@app.route("/logout")
def logout():
    session["logged_in"] = False
    flash("You have successfully logged out.")
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
    category_id = categories[0]["CategoryID"]
    if category_id_string and category_id_string.isdigit():
        category_id = int(category_id_string)
        if CategoriesTable.get_by_id(category_id) is None:
            category_id = categories[0]["CategoryID"]
    else:
        category_id = categories[0]["CategoryID"]

    delete_button = DeleteProductButton()
    edit_button = EditProductButton()
    products = ProductsTable.get_by_category_id(category_id)
    category = CategoriesTable.get_by_id(category_id)
    category_name = category["CategoryName"]

    return render_template(
        "product_list.html",
        delete_button = delete_button,
        edit_button = edit_button,
        category_name = category_name,
        categories = categories,
        products = products
    )


@app.route("/delete_product", methods=["POST"])
def delete_product():
    if "logged_in" not in session or not session["logged_in"]:
        return redirect(url_for("login"))

    delete_button = DeleteProductButton()
    if delete_button.validate_on_submit():
        category_id = delete_button.category_id.data
        product_id = delete_button.product_id.data
        if ProductsTable.delete(product_id) is not None:
            flash("The product has been deleted.")
        else:
            flash("There was a problem deleting the product.")
        return redirect(url_for("product_list", category_id=category_id))
    else:
        flash("Oops, something went wrong.")
        return redirect(url_for("product_list"))


@app.route("/edit_product_form", methods=["GET","POST"])
def edit_product_form():
    if "logged_in" not in session or not session["logged_in"]:
        return redirect(url_for("login"))

    edit_form = EditProductForm()
    categories = CategoriesTable.get()
    edit_form.set_category_choices(categories) 

    # get the id of the product to displayed in the edit form
    edit_button = EditProductButton()
    if edit_button.validate_on_submit():
        product_id = edit_button.product_id.data
        product = ProductsTable.get_by_id(product_id)
        edit_form.product_id.data = product_id
        edit_form.category.data = product["CategoryID"]
        edit_form.code.data = product["ProductCode"]
        edit_form.name.data = product["ProductName"]
        edit_form.price.data = "{:.2f}".format(product["Price"])
        return render_template("edit_product_form.html", edit_form=edit_form)
    else:
        flash("Oops, something went wrong.")
        return redirect(url_for("product_list"))


@app.route("/edit_product", methods=["POST"])
def edit_product():
    if "logged_in" not in session or not session["logged_in"]:
        return redirect(url_for("login"))

    categories = CategoriesTable.get()
    edit_form = EditProductForm()
    edit_form.set_category_choices(categories) 

    if edit_form.validate_on_submit():
        product_id = int(edit_form.product_id.data)
        product = {}
        product["category_id"] = int(edit_form.category.data)
        product["product_code"] = edit_form.code.data
        product["product_name"] = edit_form.name.data
        product["price"] = float(edit_form.price.data)
        success, message, _ = ProductsTable.update(product_id, product)
        flash(message)
        if success:
            return redirect(url_for("product_list", category_id=product["category_id"]))

    return render_template(
        "edit_product_form.html", 
        edit_form=edit_form
    )


@app.route("/category", methods=["GET", "POST"])
def category_list():
    if "logged_in" not in session or not session["logged_in"]:
        return redirect(url_for("login"))

    categories = CategoriesTable.get()
    add_error = ""
    name = ""

    # process the add form if submitted
    if request.method == "POST":
        category = {}
        category["category_name"] = request.form["name"]
        success, add_error, _ = CategoriesTable.insert(category)
        if success:
            return redirect(url_for("category_list"))
        else:
            name = category["category_name"]
        
    return render_template(
        "category_list.html", 
        delete_button = DeleteCategoryButton(),
        categories=categories,
        add_error=add_error,
        name=name
    )


@app.route("/delete_category", methods=["POST"])
def delete_category():
    if "logged_in" not in session or not session["logged_in"]:
        return redirect(url_for("login"))

    delete_button = DeleteCategoryButton()
    if delete_button.validate_on_submit():
        category_id = delete_button.category_id.data
        _, message, _ = CategoriesTable.delete(category_id)
        flash(message)
    else:
        flash("Oops, something went wrong.")
    return redirect(url_for("category_list"))


@app.route("/customer", methods=["GET"])
def customer_list():
    if "logged_in" not in session or not session["logged_in"]:
        return app.redirect(url_for("login"))

    # determine the data of the customer to be displayed
    customers = CustomersTable.get()
    customer_id_string = request.args.get("customer_id")
    if customer_id_string and customer_id_string.isdigit():
        customer_id = int(customer_id_string)
        if CustomersTable.get_by_id(customer_id) is None:
            customer_id = customers[0]["CustomerID"]
    else:
        customer_id = customers[0]["CustomerID"]
    customer = CustomersTable.get_by_id(customer_id)
    
    delete_button = DeleteCategoryButton()
    
    delete_form = DeleteCustomerButton()
    delete_form.customer_id.data = customer_id
    
    return render_template(
        "customer_list.html",
        customers = customers,
        customer = customer,
        delete_form=delete_form
    )
    
@app.route('/delete_customer', methods=['POST'])
def delete_customer():
    form = DeleteCustomerButton(request.form)  # Instantiating the form with request.form
    if form.validate_on_submit():
        customer_id = form.customer_id.data  # Extracting customer_id from form data
        deleted_customer = CustomersTable.delete(customer_id)
        if deleted_customer:
            flash('Customer deleted successfully!', 'success')
        else:
            flash('Failed to delete customer.', 'error')
    else:
        flash('Form submission error.', 'error')
    return redirect(url_for('customer_list'))
    

@app.teardown_appcontext
def close_connection(exception):
    close_db()
