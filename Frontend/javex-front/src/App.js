import React from 'react';
import logo from './logo.svg';
// import './App.css';
import { children, useState } from 'react';
import { createBrowserRouter, RouterProvider, Outlet } from 'react-router-dom';
import Footer from './components/Footer/Footer';
import Navbar from './components/Navbar/Navbar';
import Home from './pages/Home/Home';
import Product from './pages/Product/Product';
//import Products from './pages/Products/Products';
import './App.scss'

const Layout = () => {
  return (
    <div className='app'>
      <Navbar/>
      <Outlet/>
      <Footer/>
    </div>
  )
}

const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout />,
    children: [
      {
        path: "/",
        element: <Home />,
      },
      // {
      //   path: "/products/:id",
      //   element: <Products />,
      // },
      {
        path: "/product/:id",
        element: <Product />,
      },
    ],
  },
]);

/**
 * 
 * 
 * 
 * 
 */
function App() {
  return (
    <div>
      <RouterProvider router={router} />
    </div>

    // <div className="App">
    //   <header className="App-header">
    //     <img src={logo} className="App-logo" alt="logo" />
    //     <p>
    //       Edit <code>src/App.js</code> and save to reload.
    //     </p>
    //     <p>
    //       This is a test of changing app.js.
    //     </p>
    //     <a
    //       className="App-link"
    //       href="https://reactjs.org"
    //       target="_blank"
    //       rel="noopener noreferrer"
    //     >
    //       Learn React
    //     </a>
    //   </header>
    //   <div className="Javex">
    //     <p> 
    //       My new red div!
    //     </p>
    //   </div>
    // </div>
  );
}

export default App;
