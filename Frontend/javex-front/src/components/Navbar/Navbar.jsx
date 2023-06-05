//Tutaj zrobiony jest navbar

import React, { useState } from 'react'
//import KeyboardArrowDownIcon  from '@mui/icons-material/KeyboardArrowDown';
import SearchIcon from '@mui/icons-material/Search';
import PersonOutlineOutlinedIcom from '@mui/icons-material/PersonOutlined';
import FavoriteBorderOutlinedIcon from '@mui/icons-material/FavoriteOutlined';
import ShoppingCartOutlinedIcon from '@mui/icons-material/ShoppingCartOutlined';
import { Link } from 'react-router-dom';
import "./Navbar.scss";
import Cart from '../Cart/Cart';
import { useSelector } from 'react-redux';
import PropTypes from "prop-types";

const Navbar = () => {
const [open,setOpen] = useState(false)
const products = useSelector((state) => state.cart.products);

  return (
    <div className='navbar'>
        <div className="wrapper">
        <div className="left">

      <div className="item">
        <Link className="link" to="/g/many/products/woman">
          KOBIETA
        </Link>
      </div>
      <div className="item">
        <Link className="link" to="/g/many/products/man">
          MĘŻCZYZNA
        </Link>
      </div>
      <div className="item">
        <Link className="link" to="/g/many/products/girl">
          DZIEWCZYNKA
        </Link>
      </div>
      <div className="item">
        <Link className="link" to="/g/many/products/boy">
          CHŁOPIEC
        </Link>
      </div>
      <div className="itemMidSeasonSale">
        <Link className="link" to="/g/many/products/sale">
          MID SEASON SALE
        </Link>
      </div>
      <div className="item">
        <Link className="link" to="/">
          STRONA GŁÓWNA
        </Link>
      </div>
      <div className="item">
        <Link className="link" to="/">
          O NAS
        </Link>
      </div>
      <div className="item">
        <Link className="link" to="/">
          KONTAKT
        </Link>
      </div>
        {/*<div className="item">
            <img src="/img/en.png" alt="" />
            <KeyboardArrowDownIcon/>
        </div>
        <div className="item">
            <span>PLN</span>
            <KeyboardArrowDownIcon/>
        </div>*/}

        <div className="itemMidSeasonSale">
            <Link className="link" to="/products/1">MID SEASON SALE</Link>
        </div>
        <div className="item">
            <Link className="link" to="/products/2">NOWOŚCI</Link>
        </div>
        <div className="item">
            <Link className="link" to="/products/3">KOBIETA</Link>
        </div>
        <div className="item">
            <Link className="link" to="/products/4">MĘŻCZYZNA</Link>
        </div>
        <div className="item">
            <Link className="link" to="/products/5">DZIEWCZYNKA</Link>
        </div>
        <div className="item">
            <Link className="link" to="/products/6">CHŁOPIEC</Link>
        </div>
        </div>
        <div className="center">
            <Link className="link" to="/">
            <img className="logo" src="/img/navbarLogo.jpg" alt="" />
            </Link>
        </div>
        <div className="right">


    
        <div className="item">
        <Link className="link" to="/">STRONA GŁÓWNA</Link>
        </div>
        <div className="item">
            <Link className="link" to="/">O NAS</Link>
        </div>
        <div className="item">
            <Link className="link" to="/">KONTAKT</Link>
        </div>
        <div className="item">
            <Link className="link" to="/">NASZE SKLEPY</Link>
        </div>
  

        <div className="icons">
            <div className="searchIcon">
                <SearchIcon/>
            </div>
            <div className="myProfile">
                <PersonOutlineOutlinedIcom/>
            </div>
            <div className="favItems">
                <FavoriteBorderOutlinedIcon/>
            </div>
            <div className="cartIcon" onClick={()=>setOpen(!open)}>
                <ShoppingCartOutlinedIcon/>
                <span>{products.length}</span>
            </div>
        </div>
        </div>
        </div>
        {open && <Cart/>}
    </div>
  )
}

export default Navbar