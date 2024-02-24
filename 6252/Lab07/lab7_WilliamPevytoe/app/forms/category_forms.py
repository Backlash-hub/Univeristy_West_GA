from flask_wtf import FlaskForm
from wtforms import SubmitField, HiddenField
from wtforms.validators import DataRequired


class DeleteCategoryButton(FlaskForm):
    category_id = HiddenField(validators=[DataRequired()])
    submit = SubmitField("Delete")
