import CategoryList from "./CategoryList";
import ProductTable from "./ProductTable";

function Products() {
  return (
    <main>
      <div className="container">
        <div className="d-flex flex-row">

          <div className="p-4 bg-light">
            <CategoryList />
          </div>

          <div className="container px-4 py-3 bg-light">
            <ProductTable />
          </div>

        </div>
      </div>
    </main >
  );
}

export default Products;