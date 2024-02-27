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
    product_id = HiddenField()
    submit = SubmitField("Edit")

class AddProductForm(FlaskForm):
    product_id = HiddenField()
    category = SelectField("Category:", choices=[], validators=[DataRequired()])
    code = StringField('Product Code', validators=[DataRequired()])
    name = StringField('Product Name', validators=[DataRequired()])
    price = DecimalField('Price', validators=[DataRequired()])
    submit = SubmitField('Add Product')

    # def validate_code(self, field):
    #     if ProductsTable.validate_code(field.data):
    #         raise ValidationError("Product code already exists.")
    #     elif not field.data:
    #         raise ValidationError("Product code is required.")

    # def validate_name(self, field):
    #     if ProductsTable.validate_name(field.data):
    #         raise ValidationError("Product name already exists.")
    #     elif not field.data:
    #         raise ValidationError("Product name is required.")

    # def validate_price(self, field):
    #     if field.data is None or field.data < 0:
    #         raise ValidationError("Price is required and cannot be negative.")

    # Populate the category choices dynamically
    def populate_categories(self):
        categories = CategoriesTable.get()
        self.category.choices = [(category['CategoryID'], category['CategoryName']) for category in categories]
