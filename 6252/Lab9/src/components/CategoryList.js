function CategoryList() {
  return (
    <>
      <span className="fw-bold">Categories</span>
      <hr />
      <ul className="nav nav-pills flex-column">
        <li style={{ cursor: 'pointer' }} className="nav-link active">Breads</li>
        <li style={{ cursor: 'pointer' }} className="nav-link">Rolls</li>
        <li style={{ cursor: 'pointer' }} className="nav-link">Pastries</li>
      </ul>
    </>
  );
}

export default CategoryList;