from flask import abort
import sqlite3
from model.database import get_db

class ReviewsTable:
    
    
    @staticmethod
    def get():
        """Gets all the rows from the reviews table"""
        
        try:
            db = get_db()
            result = db.execute("SELECT * FROM REVIEWS")
            reviews = result.fetchall()
            reviews =[dict(review) for review in reviews]
            return reviews
        except sqlite3.Error as error:
            print("ERROR: " + str(error))
            abort(500)
            
    
    @staticmethod
    def get_by_id(review_id):
        """Gets the row with the specified id from the reviews table"""
        
        try:
            db = get_db()
            query = "Select * FROM REVIEWS WHERE ID = ?"
            data = [review_id]
            result = db.execute(query, data)
            review = result.fetchone()
            if review is not None:
                review = dict(review)
            return review
        except sqlite3.Error as error:
            print("ERROR: " + str(error))
            abort(500)
            
    
    @staticmethod
    def insert(review_data):
        """Insters the specified review into the reviews table"""
        
        try:
            db = get_db()
            query = """
                INSERT INTO reviews (FirstName, LastName, Date, Rating, Comment)
                VALUES (?, ?, ?, ?)
                """
            data = [
                review_data["first_name"], review_data["last_name"],
                review_data["date"], review_data["rating"],
                review_data["comment"]
            ]
            db.execute(query, data)
            db.commit()
            return True, "The review has been added"
        except sqlite3.Error as error:
            print("ERROR: " + str(error))
            abort(500)

    
    @staticmethod
    def get_by_rating(review_rating):
        """Get the reviews by their ratings"""
        
        try:
            db = get_db()
            query = "SELECT * FROM reviews WHERE Rating = ?"
            data = [review_rating]
            result = db.execute(query, data)
            review = result.fetchall()
            if review is not None:
                review = dict(review)
            return review
        except sqlite3.Error as error:
            print("ERROR: " + str(error))
            abort(500)
        
            
    @staticmethod
    def get_by_keyword(keyword):
        """Searchs the reviews containing the provided keyword"""
        
        try:
            db = get_db()
            query = "SELECT * FROM reviews WHERE Comment LIKE ?"
            data = ['%' + keyword + '%']
            result = db.execute(query, data)
            reviews = result.fetchall()
            return [dict(review) for review in reviews]
        
        except sqlite3.Error as error:
            print("ERROR: " + str(error))
            abort(500)