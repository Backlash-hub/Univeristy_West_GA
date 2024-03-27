import React from 'react';

function ProductRow({ product }) {
  return (
    <tr>
      <td>{product.ProductName}</td>
      <td className="text-end">{product.Price}</td>
    </tr>
  );
}

export default ProductRow;
