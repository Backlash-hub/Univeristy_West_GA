from xml.dom import ValidationErr
from flask_wtf import FlaskForm
from wtforms import SubmitField, HiddenField, StringField
from wtforms.validators import DataRequired
from model.categories_table import CategoriesTable


class DeleteCategoryButton(FlaskForm):
    category_id = HiddenField(validators=[DataRequired()])
    submit = SubmitField("Delete")
    
class AddCategoryForm(FlaskForm):
    name = StringField('Name', validators=[DataRequired()])
    
    def validate_name(self, name):
        if not CategoriesTable.validate_name(name.data):
            raise ValidationErr('Category name already exists.')
    
    submit = SubmitField('Add Category')
    
