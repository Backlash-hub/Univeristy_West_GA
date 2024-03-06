import datetime
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
        """Inserts the specified review into the reviews table"""

        try:
            db = get_db()
            query = """
                INSERT INTO reviews (FirstName, LastName, Date, Rating, Comment)
                VALUES (?, ?, ?, ?, ?)
                """
                
            current_date = datetime.datetime.now().strftime("%m/%d/%Y")
            
            data = [
                review_data["FirstName"], review_data["LastName"],
                current_date, review_data["Rating"],
                review_data["Comment"]
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
            result = db.execute(query, (review_rating,))
            reviews = result.fetchall()
            return [dict(review) for review in reviews]
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
            
    
    @staticmethod
    def get_sorted_by_highest_rating():
        """Gets all the rows from the reviews table sorted by highest rating"""
        try:
            db = get_db()
            result = db.execute("SELECT * FROM REVIEWS ORDER BY Rating DESC")
            reviews = result.fetchall()
            reviews = [dict(review) for review in reviews]
            return reviews
        except sqlite3.Error as error:
            print("ERROR: " + str(error))
            abort(500)

    
    @staticmethod
    def get_sorted_by_lowest_rating():
        """Gets all the rows from the reviews table sorted by lowest rating"""
        try:
            db = get_db()
            result = db.execute("SELECT * FROM REVIEWS ORDER BY Rating ASC")
            reviews = result.fetchall()
            reviews = [dict(review) for review in reviews]
            return reviews
        except sqlite3.Error as error:
            print("ERROR: " + str(error))
            abort(500)
            
    @staticmethod
    def get_sorted_by_recent():
        """Gets all the rows from the reviews table sorted by most recent date"""
        try:
            db = get_db()
            result = db.execute("SELECT * FROM REVIEWS ORDER BY Date DESC")
            reviews = result.fetchall()
            reviews = [dict(review) for review in reviews]
            return reviews
        except sqlite3.Error as error:
            print("ERROR: " + str(error))
            abort(500)
            
    @staticmethod
    def get_sorted_by_name():
        """Gets all the rows from the reviews table sorted by the name of the reviewer"""
        try:
            db = get_db()
            result = db.execute("SELECT * FROM REVIEWS ORDER BY LastName ASC, FirstName ASC")
            reviews = result.fetchall()
            reviews = [dict(review) for review in reviews]
            return reviews
        except sqlite3.Error as error:
            print("ERROR: " + str(error))
            abort(500)