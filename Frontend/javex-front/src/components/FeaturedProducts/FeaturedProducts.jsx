//Tutaj kod do featured products czyli do wyświetlania na homepage trending products i featured products

import React from "react";
import Card from "../Card/Card";
import "./FeaturedProducts.scss";
import useFetch from "../../hooks/useFetch";
import PropTypes from "prop-types";

const FeaturedProducts = ({ type }) => {
  // const { data, loading, error } = useFetch(
  //   `/products?populate=*&[filters][type][$eq]=${type}`
  // );
  const { data, loading, error } = useFetch(
    `/many/Product`
  );

  return (
    <div className="featuredProducts">
      <div className="top">
        <h1>{type}</h1>
      </div>
      <div className="bottom">
        {error
          ? "Coś poszło nie tak!"
          : loading
          ? "Ładowanie..."
          : data?.map((item) => <Card item={item} key={item.id} />)}
      </div>
    </div>
  );
};

FeaturedProducts.propTypes = {
  type: PropTypes.string,
};

export default FeaturedProducts;
