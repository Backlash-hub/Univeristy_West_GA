import Banner from "./commponents/Banner"
import ProductsTable from './commponents/products/ProductsTable'
import CategoryList from "./commponents/products/CategoryList";
import Footer from "./commponents/Footer";

function App() {
  return (
    <>
      <meta charSet="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1" />
      <title>Wolfie's Bakery</title>
      <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
        crossOrigin="anonymous"
      />
      <link rel="icon" href="bakery.ico" />
      <link rel="stylesheet" href="bakery.css" />
      <header>
        <Banner />
      </header>
      <main>
        <div className="container">
          <div className="d-flex flex-row">
            <CategoryList />
            <ProductsTable />
          </div>
        </div>
      </main>
      <Footer />
    </>
  );
}
export default App;
