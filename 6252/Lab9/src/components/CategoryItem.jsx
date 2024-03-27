import React from 'react';

function CategoryItem({ category, isActive }) {
  return (
    <li className={`nav-item ${isActive ? 'active' : ''}`} style={{ cursor: 'pointer' }}>
      <button className={`nav-link ${isActive ? 'active' : ''}`} onClick={() => console.log('Button clicked')}>{category.CategoryName}</button>
    </li>
  );
}

export default CategoryItem;

