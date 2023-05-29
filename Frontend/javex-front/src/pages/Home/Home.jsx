//Main page - wyświetla slider, featured products - których nie mamy jeszcze dodanych ale jest gotowe miejsce
//i contact - pasek nad footerem

import React from 'react'
import Categories from '../../components/Categories/Categories'
import Contact from '../../components/Contact/Contact'
import FeaturedProducts from '../../components/FeaturedProducts/FeaturedProducts'
import Slider from '../../components/Slider/Slider'
import "./Home.scss"
import ReactSwitch from "react-switch";

import { createContext, useState } from "react";
export const ThemeContext = React.createContext("null");

const Home = () => {

  const [theme, setTheme] = useState("light")

  const toggleTheme = () => {
    setTheme((curr) => (curr === "light" ? "dark" : "light"));
  }

  return (
    
    <div className='home' id={theme}>
     
      <Slider/>
      <FeaturedProducts type="NOWE PRODUKTY"/>
      <Categories />
      <FeaturedProducts type="NAJCZĘŚCIEJ KUPOWANE"/>
      <Contact/>
    </div>
   
  )
}

export default Home