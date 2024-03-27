import React, { useState } from 'react';
import { productData } from '../database/Bakery';

function ProductTable({ selectedCategory }) {
  const [products, setProducts] = useState(productData);

  const filteredProducts = products.filter(product => product.CategoryID === selectedCategory);

  const deleteProduct = (productId) => {
    // Remove the product with the specified ID from the products state
    setProducts(prevProducts => prevProducts.filter(product => product.ProductID !== productId));
  };

  return (
    <table className="table table-light table-striped table-hover">
      <thead>
        <tr>
          <th>Product</th>
          <th className="text-end">Price</th>
          <th className="text-end">Actions</th>
        </tr>
      </thead>
      <tbody>
        {filteredProducts.map(product => (
          <tr key={product.ProductID}>
            <td>{product.ProductName}</td>
            <td className="text-end">{product.Price}</td>
            <td className="text-end">
              <button className="w-75 btn btn-primary" onClick={() => deleteProduct(product.ProductID)}>
                Delete
              </button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default ProductTable;
