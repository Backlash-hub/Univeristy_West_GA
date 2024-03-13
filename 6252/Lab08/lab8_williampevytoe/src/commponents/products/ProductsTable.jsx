import React from 'react'

function ProductsTable() {

 const products = [
  { name: 'Whole Wheat Bread', price: '$4.19' },
  { name: 'Sourdough Bread', price: '$3.99' },
  { name: 'Multigrain Bread', price: '$4.49' },
  { name: 'Sandwich Bread', price: '$2.99' },
  { name: 'Baguette', price: '$3.49' }
 ];

  return (
    <ProductsTable>
      <div className='container'>
        <div className="container px-4 py-3 bg-light">
          <table className="table table-striped">
            <thead>
              <tr>
                <th>Product</th>
                <th>Price</th>
              </tr>
              </thead>
              <tbody>
                  {products.map((product, index) => (
                <tr key={index}>
                  <td>{product.name}</td>
                  <td>{product.price}</td>
                </tr>
                ))}
              </tbody>
            </table>
          </div>
      </div>
    </ProductsTable>
  )
}

export default ProductsTable