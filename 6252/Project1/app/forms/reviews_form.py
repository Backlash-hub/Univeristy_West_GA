import datetime
from flask_wtf import FlaskForm
from wtforms import SelectField, StringField, DateField, FloatField, SubmitField
from wtforms.validators import DataRequired, ValidationError, NumberRange
from model.reviews_table import ReviewsTable


class AddReviewForm(FlaskForm):
    FirstName = StringField("First Name:", validators=[DataRequired()])
    LastName = StringField("Last Name:", validators=[DataRequired()])
    Date = DateField("Date:", default=datetime.now, validators=[DataRequired()])
    Rating = FloatField("Rating:", validators=[DataRequired(), NumberRange(min=0, max=5)])
    Comment = StringField("Comment:")
    submit = SubmitField("Add Comment")
