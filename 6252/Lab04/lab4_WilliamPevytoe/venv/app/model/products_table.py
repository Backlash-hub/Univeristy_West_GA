from model.database import get_db


class ProductsTable:

    @staticmethod
    def get():
        """Gets all rows from the products table."""
        db = get_db()
        result = db.execute("SELECT * FROM PRODUCTS")
        products = result.fetchall()
        products = [dict(product) for product in products]
        return products

    @staticmethod
    def get_by_id(product_id):
        """Gets the row with the given id from the products table."""
        db = get_db()
        query = "SELECT * FROM PRODUCTS WHERE ProductID = ?"
        data = [product_id]
        result = db.execute(query, data)
        product = result.fetchone()
        if product is not None:
            product = dict(product)
        return product
    
    @staticmethod
    def add_new_product(product_data):
        db = get_db()
        category_id = product_data.get('category_id')
        product_code = product_data.get('product_code')
        product_name = product_data.get('product_name')
        price = product_data.get('price')

        if None in (category_id, product_code, product_name, price):
            return False, "Missing required fields", None

        query = "SELECT * FROM CATEGORIES WHERE CategoryID = ?"
        data = [category_id]
        result = db.execute(query, data)
        category = result.fetchone()
        if category is None:
            return False, "Category not found", None

        query = """
            INSERT INTO PRODUCTS (CategoryID, ProductCode, ProductName, Price)
            VALUES (?, ?, ?, ?)
        """
        data = [category_id, product_code, product_name, price]
        db.execute(query, data)
        db.commit()

     
        product_id = db.execute("SELECT last_insert_rowid()").fetchone()[0]

        query = "SELECT * FROM PRODUCTS WHERE ProductID = ?"
        data = [product_id]
        result = db.execute(query, data)
        product = result.fetchone()
        if product is not None:
            product = dict(product)
        return True, "Product added successfully", product
    
    @staticmethod
    def delete(product_id):
        db = get_db()
        product = ProductsTable.get_by_id(product_id)
        if product is None:
            return None
        
        query = "DELETE FROM PRODUCTS WHERE ProductID = ?"
        data = [product_id]
        db.execute(query, data)
        db.commit()
        return True, "The product has been deleted", product
        
            
            

