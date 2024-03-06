from flask import Flask, flash, redirect, render_template, request, url_for
from model.reviews_table import ReviewsTable
from forms.reviews_form import (
    AddReviewForm,
    ReviewSearchForm
)
from model.database import close_db

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
@app.route('/reviews_list', methods=['GET'])
def reviews_list():
    form = ReviewSearchForm(request.args)
    
    # Retrieve reviews based on the submitted form data
    if form.validate():
        keyword = form.keyword.data
        rating = form.rating.data
        sort_by = form.sort_by.data
        
        if keyword:
            reviews = ReviewsTable.get_by_keyword(keyword)
        elif rating:
            try:
                rating = float(rating)  # Convert rating to float
                reviews = ReviewsTable.get_by_rating(rating)
            except ValueError:
                # Handle invalid rating input
                reviews = []
        else:
            if sort_by == 'recent':
                reviews = ReviewsTable.get_sorted_by_recent()
            elif sort_by == 'highest':
                reviews = ReviewsTable.get_sorted_by_highest_rating()
            elif sort_by == 'lowest':
                reviews = ReviewsTable.get_sorted_by_lowest_rating()
            elif sort_by == 'name':
                reviews = ReviewsTable.get_sorted_by_name()
            else:
                reviews = ReviewsTable.get()  # Default to all reviews
    
    else:
        reviews = ReviewsTable.get()  # Default to all reviews if form is not valid
    
    return render_template('reviews_list.html', reviews=reviews, form=form)

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