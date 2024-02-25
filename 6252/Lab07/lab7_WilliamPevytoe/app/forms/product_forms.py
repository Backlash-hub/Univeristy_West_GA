from flask_wtf import FlaskForm
from wtforms import SelectField, StringField, SubmitField, HiddenField, DecimalField
from wtforms.validators import DataRequired, ValidationError, NumberRange
from model.products_table import ProductsTable
from model.categories_table import CategoriesTable


class EditProductForm(FlaskForm):
    product_id = HiddenField(validators=[DataRequired()])
    category = SelectField(
        "Category:", 
        choices=[],
        validators=[DataRequired()]
    )
    code = StringField("Code:")
    name = StringField("Name:")
    price = StringField("Price:")
    submit = SubmitField("Edit Product")


    def validate_code(form, field):
        valid, message = ProductsTable.validate_updated_code(
            field.data,
            form.product_id.data)
        if not valid:
            raise ValidationError(message)


    def validate_name(form, field):
        valid, message = ProductsTable.validate_name(field.data)
        if not valid:
            raise ValidationError(message)


    def validate_price(form, field):
        valid, message = ProductsTable.validate_price_string(field.data)
        if not valid:
            raise ValidationError(message)


    def set_category_choices(self, categories):
        """Sets the choices of the category selectoin field (dropdown box)

        Args:
            categories (list): a list where each item is a dictionary 
            representing a category
        """
        choices = []
        for category in categories:
            choices.append((category["CategoryID"], category["CategoryName"]))
        self.category.choices = choices


class DeleteProductButton(FlaskForm):
    product_id = HiddenField(validators=[DataRequired()])
    category_id = HiddenField(validators=[DataRequired()])
    submit = SubmitField("Delete")


class EditProductButton(FlaskForm):
    product_id = HiddenField(validators=[DataRequired()])
    submit = SubmitField("Edit")

class AddProductForm(FlaskForm):
    # Initialize the category choices inside the __init__ method
    def __init__(self, *args, **kwargs):
        super(AddProductForm, self).__init__(*args, **kwargs)
        self.category.choices = [(category['CategoryID'], category['CategoryName']) for category in CategoriesTable.get()]
    # Define form fields
    category = SelectField('Category', validators=[DataRequired()])
    code = StringField('Product Code', validators=[DataRequired()])
    name = StringField('Product Name', validators=[DataRequired()])
    price = DecimalField('Price', validators=[DataRequired(), NumberRange(min=0.01, message="Price must be greater than 0")])
    submit = SubmitField('Add Product')
    