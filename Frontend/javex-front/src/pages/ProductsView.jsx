//react page of products view with filter and sorting
import React, { useState } from "react";
//import data from "./data"; // assuming you have an array of product data

const ProductsView = () => {
  const data = [
    { id: 1, name: "Product 1", price: 50 },
    { id: 2, name: "Product 2", price: 25 },
    { id: 3, name: "Product 3", price: 75 },
  ];

  const [products, setProducts] = useState(data);
  const [sortType, setSortType] = useState("");
  const [filterType, setFilterType] = useState("");

  const sortProducts = () => {
    if (sortType === "price-low-to-high") {
      setProducts([...products].sort((a, b) => a.price - b.price));
    } else if (sortType === "price-high-to-low") {
      setProducts([...products].sort((a, b) => b.price - a.price));
    }
  };

  const filterProducts = () => {
    if (filterType === "low-price") {
      setProducts(products.filter((product) => product.price < 50));
    } else if (filterType === "high-price") {
      setProducts(products.filter((product) => product.price >= 50));
    }
  };

  return (
    <div>
      <h1>Products View</h1>
      <div>
        <label htmlFor="sort-select">Sort by:</label>
        <select
          id="sort-select"
          value={sortType}
          onChange={(e) => setSortType(e.target.value)}
        >
          <option value="">Please select</option>
          <option value="price-low-to-high">Price low to high</option>
          <option value="price-high-to-low">Price high to low</option>
        </select>
        <button onClick={sortProducts}>Sort</button>
      </div>
      <div>
        <label htmlFor="filter-select">Filter by:</label>
        <select
          id="filter-select"
          value={filterType}
          onChange={(e) => setFilterType(e.target.value)}
        >
          <option value="">Please select</option>
          <option value="low-price">Low price (&lt; $50)</option>
          <option value="high-price">High price (&gt;= $50)</option>
        </select>
        <button onClick={filterProducts}>Filter</button>
      </div>
      <ul>
        {products.map((product) => (
          <li key={product.id}>
            <h2>{product.name}</h2>
            <p>${product.price}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ProductsView;
