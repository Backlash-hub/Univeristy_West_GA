/* eslint-disable jsx-a11y/anchor-is-valid */
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
    <link rel="stylesheet" href="index.css" />
    <header>
      <div className="container">
        <div className="wordmark p-3 fs-3 text-light bg-dark">
          Wolfie's Bakery
        </div>
      </div>
    </header>
    <main>
      <div className="container">
        <div className="d-flex flex-row">
          <div className="p-4 bg-light">
            <span className="fw-bold">Categories</span>
            <hr />
            <ul className="nav nav-pills flex-column">
              <li>
                <a className="nav-link active" href="#">
                  Breads
                </a>
              </li>
              <li>
                <a href="#" className="nav-link">
                  Rolls
                </a>
              </li>
              <li>
                <a href="#" className="nav-link">
                  Pastries
                </a>
              </li>
            </ul>
          </div>
          <div className="container px-4 py-3 bg-light">
            <table className="table table-striped">
              <thead>
                <tr>
                  <th>Product</th>
                  <th>Price</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>Whole Wheat Bread</td>
                  <td>$4.19</td>
                </tr>
                <tr>
                  <td>Sourdough Bread</td>
                  <td>$3.99</td>
                </tr>
                <tr>
                  <td>Multigrain Bread</td>
                  <td>$4.49</td>
                </tr>
                <tr>
                  <td>Sandwich Bread</td>
                  <td>$2.99</td>
                </tr>
                <tr>
                  <td>Barguette</td>
                  <td>$3.49</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </main>
    <footer className="footer">
      <div className="container">
        <div className="wordmark p-3 text-light bg-dark">
          © 2024 Wolfie's Bakery, Inc.
        </div>
      </div>
    </footer>
  </>
  );
  }
  export default App;
  
