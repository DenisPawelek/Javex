//Tutaj tego używałem do wyświetlania konkretnych produktów przypisanych do konkretej kategorii/marki itp. Na razie zostawiam bo sie moze przydać.

import React from "react";
import "./List.scss";
import Card from "../Card/Card";
import useFetch from "../../hooks/useFetch";

const List = ({ subCats, maxPrice, sort, catId }) => {
  const { data, loading, error } = useFetch(
    `/products?populate=*&[filters][categories][id]=${catId}${subCats.map(
      (item) => `&[filters][sub_categories][id][$eq]=${item}`
    )}&[filters][price][$lte]=${maxPrice}&sort=price:${sort}`
  );

  return (
    <div className="list">
      {loading
        ? "Ładowanie..."
        : data?.map((item) => <Card item={item} key={item.id} />)}
    </div>
  );
};

List.propTypes = {  
  subCats: PropTypes.array,
  maxPrice: PropTypes.number,
  sort: PropTypes.string,
  catId: PropTypes.number,
};

export default List;
