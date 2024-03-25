function ProductTable() {
  return (
    <table className="table table-light table-striped table-hover">
      <thead>
        <tr>
          <th>Product</th>
          <th className="text-end">Price</th>
        </tr>
      </thead>
      <tbody>
        <ProductRow product={{ProductName: "Whole Wheat Bread", Price: "$4.19"}} />
        <ProductRow product={{ProductName: "Sourdough Bread", Price: "$3.99"}} />
        <ProductRow product={{ProductName: "Multigrain Bread", Price: "$4.49"}} />
        <ProductRow product={{ProductName: "Sandwhich Bread", Price: "$2.99"}} />
        <ProductRow product={{ProductName: "Baguette", Price: "$3.49"}} />
      </tbody>
    </table>
  );
}

function ProductRow({ product }) {
  return (
    <tr>
      <td>{product.ProductName}</td>
      <td className="text-end">{product.Price}</td>
    </tr>
  );
}

export default ProductTable;