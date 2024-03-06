import datetime
from wtforms.validators import Optional, NumberRange
from flask_wtf import FlaskForm
from wtforms import SelectField, StringField, DateField, FloatField, SubmitField
from wtforms.validators import DataRequired, ValidationError, NumberRange
from model.reviews_table import ReviewsTable


class AddReviewForm(FlaskForm):
    FirstName = StringField("First Name:", validators=[DataRequired()])
    LastName = StringField("Last Name:", validators=[DataRequired()])
    Date = DateField("Date:", default=datetime.datetime.today, validators=[DataRequired()])
    Rating = FloatField("Rating:", validators=[DataRequired(), NumberRange(min=0, max=5)])
    Comment = StringField("Comment:")
    submit = SubmitField("Add Comment")

class ReviewSearchForm(FlaskForm):
    keyword = StringField('Keyword')
    rating = FloatField('Rating', validators=[Optional(), NumberRange(min=1, max=5, message="Rating must be between 1 and 5")])
    sort_by = SelectField('Sort By', choices=[('recent', 'Most Recent'), ('highest', 'Highest Rating'), ('lowest', 'Lowest Rating'), ('name', 'Last Name')])