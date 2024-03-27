import { useState } from "react";
import CategoryList from "./CategoryList";
import ProductTable from "./ProductTable";
import { categoryData } from "../database/Bakery"

function Products() {
  const initialCategoryId = categoryData.length > 0 ? categoryData[0].CategoryID : 1;

  const [selectedCategory, setSelectedCategory] = useState(initialCategoryId);

  return (
    <main>
      <div className="container">
        <div className="d-flex flex-row">

          <div className="p-4 bg-light">
            <CategoryList categories={categoryData} selectedCategory={selectedCategory} setSelectedCategory={setSelectedCategory} />
          </div>

          <div className="container px-4 py-3 bg-light">
            <ProductTable selectedCategory={selectedCategory} />
          </div>

        </div>
      </div>
    </main >
  );
}

export default Products;