import React from 'react'

function CategoryList() {
  return (
    <div>
        <div className="p-4 bg-light">
            <span className="fw-bold">Categories</span>
            <hr />
            <ul className="nav nav-pills flex-column">
                <li style={{ cursor: 'pointer' }} className="nav-link active">Breads</li>
                <li style={{ cursor: 'pointer' }} className="nav-link">Rolls</li>
                <li style={{ cursor: 'pointer' }} className="nav-link">Pastries</li>
            </ul>
        </div>
    </div>
  )
}

export default CategoryList
