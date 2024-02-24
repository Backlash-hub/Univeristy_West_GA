from flask_wtf import FlaskForm
from wtforms import PasswordField, SubmitField
from wtforms.validators import DataRequired

class LoginForm(FlaskForm):
    passcode = PasswordField("Passcode:", validators=[DataRequired("Enter a passcode.")])
    submit = SubmitField("Login")


