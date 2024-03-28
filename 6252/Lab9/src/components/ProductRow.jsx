import React from 'react';

function ProductRow({ product, deleteProduct }) {
  const handleDeleteClick = () => {
    const isConfirmed = window.confirm('Are you sure you want to delete this product?');
    if (isConfirmed) {
      deleteProduct(product.ProductID);
    }
  };

  return (
    <tr>
      <td>{product.ProductName}</td>
      <td className="text-end">{product.Price}</td>
      <td className="text-end">
        <button className="w-75 btn btn-primary" onClick={handleDeleteClick}>
          Delete
        </button>
      </td>
    </tr>
  );
}

export default ProductRow;
