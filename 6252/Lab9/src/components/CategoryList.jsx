import React from 'react';
import CategoryItem from './CategoryItem';

function CategoryList({ categories, selectedCategory, setSelectedCategory }) {
  return (
    <>
      <span className="fw-bold">Categories</span>
      <ul className="nav flex-column">
        {categories.map(category => (
          <CategoryItem
            key={category.CategoryID}
            category={category}
            isActive={category.CategoryID === selectedCategory}
            onClick={() => setSelectedCategory(category.CategoryID)}
          />
        ))}
      </ul>
    </>
  );
}

export default CategoryList;
