import React, { useState } from 'react';
import ProductRow from './ProductRow';
import { productData } from '../database/Bakery';

function ProductTable({ selectedCategory }) {
  const [products, setProducts] = useState(productData);

  const filteredProducts = products.filter(product => product.CategoryID === selectedCategory);

  const deleteProduct = (productId) => {
    const isConfirmed = window.confirm('Are you sure you want to delete this product?');
    if (isConfirmed) {
      setProducts(prevProducts => prevProducts.filter(product => product.ProductID !== productId));
    }
  };

  return (
    <table className="table table-light table-striped table-hover">
      <thead>
        <tr>
          <th>Product</th>
          <th className="text-end">Price</th>
          <th className="text-end"></th>
        </tr>
      </thead>
      <tbody>
        {filteredProducts.map(product => (
          <ProductRow key={product.ProductID} product={product} deleteProduct={deleteProduct} />
        ))}
      </tbody>
    </table>
  );
}

export default ProductTable;
