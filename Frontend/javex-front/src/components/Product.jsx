import React, { useEffect, useRef, useState } from "react";
import { Add, Remove } from "@material-ui/icons";
import styled from "styled-components";
import img1 from "../assets/Images/14.webp";
import { useAxios } from "../hooks/useAxios";

//#region Styled Components
const ProductPage = styled.div`
  display: flex;
  padding: 50px;
  background-color: #f5fbfd;
`;

const InfoContainer = styled.div`
  flex: 1;
  padding: 0px 50px;
  width: 100%;
`;

const ImageContainer = styled.div`
  flex: 1;
`;

const ProductImage = styled.img`
  width: 100%;
  height: 90vh;
  min-width: 200px;
  object-fit: cover;
  border-radius: 10px;
`;

const ProductTitle = styled.h1`
  font-size: 2.4rem;
  margin-bottom: 1rem;
  text-align: center;
  justify-content: center;
`;

const ProductDescription = styled.p`
  font-size: 1.3rem;
  text-align: center;
  justify-content: center;
  margin: 20px 0px;
`;

const ProductPrice = styled.p`
  font-size: 40px;
  font-weight: bold;
  margin-bottom: 2rem;
  text-align: center;
  justify-content: center;
`;

const AddContainer = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 20px;
`;

const AmountContainer = styled.div`
  display: flex;
  align-items: center;
  font-weight: 700;
`;

const Amount = styled.span`
  background-color: white;
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
  width: 100%;
  margin: 30px 0px;
  display: flex;
  justify-content: space-evenly;
  gap: 20px;
`;

const Filter = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-evenly;
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
  const [product, setProduct] = useState(null);
  const [amount, setAmount] = useState(1);
  const [selectedColor, setSelectedColor] = useState();
  const [reservesJson, setReservesJson] = useState({ reserves: [] });
  const [sizes, setSizes] = useState([]);
  const [colors, setColors] = useState([]);

  const token =
    "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoidGVzdFVzZXIiLCJleHAiOjE2ODY3OTUxMzQsImlhdCI6MTY4NjczNTEzNCwic2NvcGUiOiJST0xFX0FETUlOIn0.Wyr_9x9VsYD857SctBq46dAEWz8No-w3hRxS_yIsxY_DSUVVWIeMWEX0zEbYWiz-oLEWuvk95vq_HbfdkEpxRssjIV495nhLrrLYofioZhQ-xWybCvDTc8rJEAkmjIw5bvnQ66DaSOxnuDIh3k33g6Kg6H7rLY5MS-BooqAAP9b27wEE0O-HS242Nai9KJFt-t_CPGgtR2STUAViPyQFoK7fJ7qDUH3hqi3FinjPzqw7tqLD9dETHud_16a3RkQ5aivos4sqGUZXqY8HST8ar80WHOAAQL-2Gx_XAQYBgXs3GtHwOxGtGE35O4z99VFre_dSMrDaxhTKEwsboapgDQ";

  const { response, loading, error } = useAxios({
    method: "GET",
    url: "/g/single/Product",
    params: { id: props.id ? props.id : 99 }, //potem usunąć ifa
    auth: {
      username: "testUser",
      password: "pasword123",
    }, //zabezpieczyć
    headers: {
      accept: "*/*",
      // authorization: `Bearer ${token}`,
    },
  });

  useEffect(() => {
    response &&
      (() => {
        setProduct(response?.[0]);
        var resJson = { reserves: [] };
        product &&
          product?.reserves?.map((item) => {
            resJson.reserves.push({
              amount: item?.amount,
              color: item?.color,
              size: item?.size,
            });

            let uniqueSizes = [
              ...new Map(
                resJson?.reserves?.map((item) => [item.size["key"], item.size])
              ).values(),
            ];
            //testowo
            uniqueSizes.push(
              { id: 2, name: "S" },
              { id: 3, name: "M" },
              { id: 5, name: "XL" }
            );
            let ORDER = ["XS", "S", "M", "L", "XL", "XXL"];
            uniqueSizes.sort(
              (a, b) => ORDER.indexOf(a.name) - ORDER.indexOf(b.name)
            );

            setSizes(uniqueSizes);

            let uniqueColors = [
              ...new Map(
                resJson?.reserves?.map((item) => [
                  item.color["key"],
                  item.color,
                ])
              ).values(),
            ];
            //testowo
            uniqueColors.push(
              { id: 2, name: "red" },
              { id: 3, name: "blue" },
              { id: 5, name: "green" }
            );
            //console.log(uniqueColors);
            setColors(uniqueColors);

            return setReservesJson(resJson);
          });
      })();
  }, [response, product]);

  const handleColorChange = (e) => {
    setSelectedColor(e.target.id);
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
                    <ProductTitle>{product && product?.name}</ProductTitle>
                    <ProductDescription>
                      {product && product?.description?.value}
                    </ProductDescription>
                    <ProductPrice>{product && product?.price} PLN</ProductPrice>
                    <FilterContainer>
                      <Filter>
                        <FilterTitle>Color</FilterTitle>
                        {/* kolory sa w jezyku polskim i baza nie jest poprawnie uzupelniona */}
                        <>
                          {colors &&
                            colors.map((item) => (
                              <FilterColor
                                key={item.id}
                                id={item.id}
                                color={
                                  item.name === "Czarny" ? "black" : item.name
                                }
                                checked={selectedColor == item.id}
                                onChange={() => true}
                                onClick={handleColorChange}
                              />
                            ))}
                        </>
                      </Filter>
                      <Filter>
                        <FilterTitle>Size</FilterTitle>
                        <FilterSize>
                          <FilterSizeOption defaultChecked>
                            Size
                          </FilterSizeOption>
                          {sizes &&
                            sizes?.map((item) => (
                              <FilterSizeOption key={item.id}>
                                {item.name}
                              </FilterSizeOption>
                            ))}
                        </FilterSize>
                      </Filter>
                    </FilterContainer>
                    <AddContainer>
                      <AmountContainer>
                        <Remove
                          onClick={() => {
                            if (amount > 1) setAmount(amount - 1);
                          }}
                          style={{ cursor: "pointer" }}
                        />
                        <Amount>{amount}</Amount>
                        <Add
                          onClick={() => {
                            if (amount < 100) setAmount(amount + 1);
                          }}
                          style={{ cursor: "pointer" }}
                        />
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
