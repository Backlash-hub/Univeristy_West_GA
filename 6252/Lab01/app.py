from flask import Flask, render_template_string, request

app = Flask(__name__)

@app.route('/squares')
def squares():

    """
    Display a table with the squares of integer numbers based on the 'num' parameter in the query string.

    Returns:
        str: HTML content with the table of squares or an error message.
    """
    
    try:
        num = int(request.args.get('num'))
    except ValueError:
        # Handle the case where 'num' is not a valid integer
        return render_template_string('<h1>Invalid query string</h1>')

    if num > 0:

        squares_list = [(i, i ** 2) for i in range(1, num + 1)]

        return render_template_string('''
            <table>
                <tr>
                    <th>n</th>
                    <th>n**2</th>
                </tr>
                {% for num, square in squares_list %}
                <tr>
                    <td>{{ num }}</td>
                    <td>{{ square }}</td>
                </tr>
                {% endfor %}
            </table>
        ''', squares_list=squares_list)
    else:
        return render_template_string('<h1>The specified number must be positive<h1>')
    
@app.route('/cubes')
def cubes():
    """
    Display a table with the squared and cube of integer numbers based on the 'num' parameter in the query string.

    Returns:
        str: HTML content with the table of cubes or an error message.
    """
    try:
        num = int(request.args.get('num'))
    except ValueError:
        # Handle the case where 'num' is not a valid integer
        return render_template_string('<h1>Invalid query string</h1>')

    if num > 0:
        cubes_list = [(i, i ** 2, i ** 3) for i in range(1, num + 1)]

        return render_template_string('''
            <table>
                <tr>
                    <th>n</th>
                    <th>n**2</th>
                    <th>n**3</th>
                </tr>
                {% for num, square, cube in cubes_list %}
                <tr>
                    <td>{{ num }}</td>
                    <td>{{ square }}</td>
                    <td>{{ cube }}</td>
                </tr>
                {% endfor %}
            </table>
        ''', cubes_list=cubes_list)
    else:
        return render_template_string('<h1>The specified number must be positive</h1>')

@app.route('/powers')    
def powers():
    """
    Display a table with the squared, cube, and power (with variable exponent) of integer numbers based on the 'num' parameter in the query string.

    Returns:
        str: HTML content with the table of cubes or an error message.
    """
    try:
        num = int(request.args.get('num'))
        exp = int(request.args.get('exp'))
    except ValueError:
        # Handle the case where 'num' is not a valid integer
        return render_template_string('<h1>Invalid query string</h1>')

    if num > 0 and exp > 0:
        powers_list = [(i, i ** 2, i ** 3, i ** exp) for i in range(1, num + 1)]

        return render_template_string('''
            <table>
                <tr>
                    <th>n</th>
                    <th>n**2</th>
                    <th>n**3</th>
                    <th>n**{{ exp_value }}</th>
                </tr>
                {% for num, square, cube, power in powers_list %}
                <tr>
                    <td>{{ num }}</td>
                    <td>{{ square }}</td>
                    <td>{{ cube }}</td>
                    <td>{{ power }}
                </tr>
                {% endfor %}
            </table>
        ''', powers_list=powers_list, exp_value=exp)
    else:
        return render_template_string('<h1>The specified number must be positive</h1>')




if __name__ == '__main__':
    app.run