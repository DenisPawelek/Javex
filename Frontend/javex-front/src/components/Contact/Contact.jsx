//Tutaj jest kod do paska z kontaktu nad footerem

import React from 'react'
import "./Contact.scss"
import FacebookIcon from "@mui/icons-material/Facebook";
import InstagramIcon from "@mui/icons-material/Instagram";
import TwitterIcon from "@mui/icons-material/Twitter";
import GoogleIcon from "@mui/icons-material/Google";
import PinterestIcon from "@mui/icons-material/Pinterest";

function Contact() {
  return (
    <div className='contact'>
        <div className="wrapper">
            <span>BĄDŹ Z NAMI W KONTAKCIE:</span>
            <div className="mail">
                <input type="text" placeholder='Wprowadź swój e-mail...' />
                <button>DOŁĄCZ DO NAS!</button>
            </div>
            <div className="icons">
                <FacebookIcon />
                <InstagramIcon />
                <TwitterIcon />
                <GoogleIcon />
                <PinterestIcon />
            </div>
        </div>
    </div>
  )
}

export default Contact