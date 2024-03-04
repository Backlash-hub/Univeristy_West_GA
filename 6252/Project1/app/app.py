import sys
from flask import Flask, render_template
from model.reviews_table import ReviewsTable
from forms.reviews_form import AddReviewForm
from model.database import close_db  # Import absolute path

# Print Python path for debugging
print("Python path:", sys.path)

app = Flask(__name__)
app.config['SECRET_KEY'] = "The secret key string"

# Error handlers
@app.errorhandler(404)
def page_not_found(error):
    return render_template("errors/404.html"), 404

@app.errorhandler(500)
def internal_server_error(error):
    return render_template("errors/500.html"), 500

# Home page
@app.route("/")
@app.route("/index")
def home():
    return render_template("index.html")

# Reviews list page
@app.route("/reviews")
def reviews_list():
    reviews = ReviewsTable.get()  # Assuming ReviewsTable has a static method 'get' to fetch reviews
    return render_template("reviews_list.html", reviews=reviews)

@app.teardown_appcontext
def close_connection(exception):
    close_db()

if __name__ == "__main__":
    app.run(debug=True)
