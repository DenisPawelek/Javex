import React, { useEffect, useState } from "react";
import { Add, Remove } from "@material-ui/icons";
import styled from "styled-components";
import products from "../test/products";
import img1 from "../assets/Images/14.webp";
import { useAxios } from "../hooks/useAxios";

//#region Styled Components
const ProductPage = styled.div`
  display: flex;
  padding: 50px;
`;

const InfoContainer = styled.div`
  flex: 1;
  padding: 0px 50px;
`;

const ImageContainer = styled.div`
  flex: 1;
`;

const ProductImage = styled.img`
  width: 100%;
  height: 90vh;
  object-fit: cover;
`;

const ProductTitle = styled.h1`
  font-size: 2.4rem;
  margin-bottom: 1rem;
  text-align: left;
`;

const ProductDescription = styled.p`
  font-size: 1.3rem;
  text-align: left;
  margin: 20px 0px;
`;

const ProductPrice = styled.span`
  font-size: 40px;
  font-weight: bold;
  margin-bottom: 2rem;
`;

const AddContainer = styled.div`
  width: 50%;
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

const AmountContainer = styled.div`
  display: flex;
  align-items: center;
  font-weight: 700;
`;

const Amount = styled.span`
  width: 30px;
  height: 30px;
  border-radius: 10px;
  border: 2px solid teal;
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 0px 5px;
`;

const Button = styled.button`
  padding: 15px;
  border: 2px solid teal;
  border-radius: 10px;
  background-color: white;
  cursor: pointer;
  font-weight: 500;

  &:hover {
    background-color: #e7e7e7;
  }
`;

const FilterContainer = styled.div`
  width: 50%;
  margin: 30px 0px;
  display: flex;
  justify-content: space-between;
`;

const Filter = styled.div`
  display: flex;
  align-items: center;
`;

const FilterTitle = styled.span`
  font-size: 20px;
  font-weight: 200;
  padding-right: 4px;
`;

const FilterColor = styled.input`
  width: 20px;
  height: 20px;
  type: radio;
  border-radius: 50%;
  background-color: ${(props) => props.color};
  margin: 0px 5px;
  cursor: pointer;
  outline: ${(props) => (props.checked ? "2px solid teal" : "none")};
`;

const FilterSize = styled.select`
  margin-left: 5px;
  padding: 5px;
`;

const FilterSizeOption = styled.option``;
//#endregion

const Product = (props) => {
  //const product = products.find(({ _id }) => _id === "3");
  const { response, loading, error } = useAxios({
    method: "GET",
    url: "/g/many/Product",
    headers: {
      accept: "*/*",
    },
    data: {},
  });

  const [amount, setAmount] = useState(1);
  const [selected, setSelected] = useState("black");

  const handleColorChange = (e) => {
    setSelected(e.target.getAttribute("color"));
  };

  const AmountUp = () => {
    setAmount(amount + 1);
  };

  const AmountDown = () => {
    if (amount > 1) setAmount(amount - 1);
  };

  const handleAddToCart = () => {
    console.log("Added to cart");
  };

  return (
    <ProductPage>
      {loading ? (
        <p>loading...</p>
      ) : (
        <>
          {error && (
            <div>
              <p>{error.message}</p>
            </div>
          )}
          <>
            {" "}
            {
              // no need to use another state to store data, response is sufficient
              response && (
                <>
                  <ImageContainer>
                    <ProductImage src={img1} />
                  </ImageContainer>
                  <InfoContainer>
                    <ProductTitle>{product.name}</ProductTitle>
                    <ProductDescription>
                      {product.description}
                    </ProductDescription>
                    <ProductPrice>{product.price} PLN</ProductPrice>
                    <FilterContainer>
                      <Filter>
                        <FilterTitle>Color</FilterTitle>
                        <FilterColor
                          color="black"
                          checked={selected === "black"}
                          onClick={handleColorChange}
                        />
                        <FilterColor
                          color="darkblue"
                          checked={selected === "darkblue"}
                          onClick={handleColorChange}
                        />
                        <FilterColor
                          color="gray"
                          checked={selected === "gray"}
                          onClick={handleColorChange}
                        />
                      </Filter>
                      <Filter>
                        <FilterTitle>Size</FilterTitle>
                        <FilterSize>
                          <FilterSizeOption>XS</FilterSizeOption>
                          <FilterSizeOption>S</FilterSizeOption>
                          <FilterSizeOption>M</FilterSizeOption>
                          <FilterSizeOption>L</FilterSizeOption>
                          <FilterSizeOption>XL</FilterSizeOption>
                        </FilterSize>
                      </Filter>
                    </FilterContainer>
                    <AddContainer>
                      <AmountContainer>
                        <Remove
                          onClick={AmountDown}
                          style={{ cursor: "pointer" }}
                        />
                        <Amount>{amount}</Amount>
                        <Add onClick={AmountUp} style={{ cursor: "pointer" }} />
                      </AmountContainer>
                      <Button onClick={handleAddToCart}>ADD TO CART</Button>
                    </AddContainer>
                  </InfoContainer>
                </>
              )
            }
          </>
        </>
      )}
    </ProductPage>
  );
};

export default Product;
