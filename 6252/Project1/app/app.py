import sys
from flask import Flask, flash, redirect, render_template, request, url_for
from model.reviews_table import ReviewsTable
from forms.reviews_form import AddReviewForm
from model.database import close_db

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
@app.get("/")
@app.get("/index")
def home():
    return render_template("index.html")

# Reviews list page
@app.route("/reviews")
def reviews_list():
    reviews = ReviewsTable.get()
    return render_template("reviews_list.html", reviews=reviews)

# Add review page
@app.route("/add_review", methods=["GET", "POST"])
def add_review():
    form = AddReviewForm()
    if form.validate_on_submit():
        review_data = {
            "FirstName": form.FirstName.data,
            "LastName": form.LastName.data,
            "Date": form.Date.data,
            "Rating": form.Rating.data,
            "Comment": form.Comment.data
        }
        success, message = ReviewsTable.insert(review_data)
        if success:
            flash("Review added successfully!", "success")
            return redirect(url_for("reviews_list"))
        else:
            flash(f"Failed to add review: {message}", "error")
    return render_template("add_review.html", form=form)

@app.teardown_appcontext
def close_connection(exception):
    close_db()

if __name__ == "__main__":
    app.run(debug=True)
