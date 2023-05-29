//Tutaj jest funkcjonalność do featured i trending products. Na stronie wyświetla się zdjęcie produktu ale dodany jest "on hover effect" czyli zmienia się
//zdjęcie jak najedziemy myszką na produkt

import React from "react";
import "./Card.scss";
import { Link } from "react-router-dom";
import Product from "../../pages/Product/Product";
import PropTypes from "prop-types";

const Card = ({ item }) => {
  console.log(item);
  return (
    <Link className="link" to={`/product/${item.id}`}>
      <div className="card">
        <div className="image">
          {item?.attributes.isNew && <span>NOWY PRODUKT</span>}
          <img
            src={
              process.env.REACT_APP_UPLOAD_URL + item.attributes?.img?.data?.attributes?.url
            }
            alt=""
            className="mainImg"
          />
          <img
            src={
              process.env.REACT_APP_UPLOAD_URL + item.attributes?.img2?.data?.attributes?.url
            }
            alt=""
            className="secondImg"
          />
        </div>
        <h2>{item?.attributes.title}</h2>
        <div className="prices">
          <h3>{item.oldPrice || item?.attributes.price + 10} PLN</h3>
          <h3>{item?.attributes.price} PLN</h3>
        </div>
      </div>
    </Link>
  );
};

Card.propTypes = {
  item: PropTypes.Product,
};

export default Card;
