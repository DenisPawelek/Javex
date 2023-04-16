//Tutaj napisany jest footer

import React from 'react'
import "./Footer.scss";
const Footer = () => {
  return (
    <div className='footer'>
      <div className="top">
        <div className="item">
          <h1>PRODUKTY</h1>
          <span>Mid season sale</span>
          <span>Nowości</span>
          <span>Kobieta</span>
          <span>Mężczyzna</span>
          <span>Dziewczynka</span>
          <span>Chłopiec</span>
        </div>
        <div className="item">
        <h1>NASZA FIRMA</h1>
          <span>FAQ</span>
          <span>Strony</span>
          <span>Nasze sklepy</span>
          <span>Porównaj</span>
          <span>Cookies</span>
        </div>
        <div className="item">
          <h1>O NAS</h1>
          <span>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
          Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
          Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
          Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
          </span>
        </div>
        <div className="item">
        <h1>KONTAKT</h1>
          <span>
          Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
          Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
          Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
          Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
          </span>
        </div>
      </div>
      <div className="bottom">
        <div className="left">
          <span className="logo">JAVEX</span>
          <span className="copyright">© Copyright 2023. All Rights Reserved.</span>
        </div>
        <div className="right">
          <img src="/img/payment.png" alt="" />
        </div>
      </div>
    </div>
  )
}

export default Footer