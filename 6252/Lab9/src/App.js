import React, { useState } from 'react';
import Banner from "./components/Banner";
import Footer from "./components/Footer";
import Products from "./components/Products";


function App() {
  const [selectedCategory, setSelectedCategory] = useState(1);

  const handleCategorySelect = (categoryId) => {
    setSelectedCategory(categoryId);
  };

  return (
    <>
      <Banner />
      <Products selectedCategory={selectedCategory} onCategorySelect={handleCategorySelect} />
      <Footer />
    </>
  );
}

export default App;
