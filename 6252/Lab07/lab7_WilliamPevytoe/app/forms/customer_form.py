from flask_wtf import FlaskForm
from wtforms import SelectField, StringField, SubmitField, HiddenField
from wtforms.validators import DataRequired, ValidationError
from model.customers_table import CustomersTable

class DeleteCustomerButton(FlaskForm):
    customer_id = HiddenField(validators=[DataRequired()])
    submit = SubmitField("Delete")