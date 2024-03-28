import React from 'react';

function CategoryItem({ category, isActive, onClick }) {
  return (
    <li className={`nav-link ${isActive ? 'active' : ''}`} style={{ cursor: 'pointer' }} onClick={onClick}>
      <button>{category.CategoryName}</button>
    </li>
  );
}

export default CategoryItem;
