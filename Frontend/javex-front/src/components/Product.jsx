import React from "react";
import styled from "styled-components";

const ProductPage = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 2rem;
`;

const ProductImage = styled.img`
  height: 25rem;
  width: auto;
  margin-bottom: 2rem;
`;

const ProductTitle = styled.h1`
  font-size: 2.4rem;
  margin-bottom: 1rem;
  text-align: center;
`;

const ProductDescription = styled.p`
  font-size: 1.6rem;
  text-align: center;
  margin-bottom: 2rem;
`;

const ProductPrice = styled.p`
  font-size: 2.4rem;
  font-weight: bold;
  margin-bottom: 2rem;
`;

const ProductButton = styled.button`
  background-color: #008cba;
  color: white;
  font-size: 1.6rem;
  padding: 1rem 2rem;
  border: none;
  border-radius: 1rem;
  cursor: pointer;

  &:hover {
    background-color: #0074a4;
  }
`;

const Product = (props) => {
  return (
    <ProductPage>
      <ProductImage src={props.image} alt={props.title} />
      <ProductTitle>{props.title}</ProductTitle>
      <ProductDescription>{props.description}</ProductDescription>
      <ProductPrice>{props.price}</ProductPrice>
      <ProductButton>Add to Cart</ProductButton>
    </ProductPage>
  );
};

export default Product;
