import {
  FavoriteBorderOutlined,
  SearchOutlined,
  ShoppingCartOutlined,
} from "@material-ui/icons";
import styled from "styled-components";
import img1 from "../assets/Images/10.webp";
import Rating from "@mui/material/Rating";
import Typography from "@mui/material/Typography";
import { useState } from "react";

const Info = styled.div`
  opacity: 0;
  width: 100%;
  height: 100%;
  position: absolute;
  border-radius: 5px;
  background-color: rgba(0, 0, 0, 0.2);
  z-index: 3;
  display: flex;
  flex:1;
  align-items: center;
  justify-content: center;
  transition: all 0.5s ease;
  cursor: pointer;
`;

const Container = styled.div`
  display: flex;
  flex: 30%;
  width: 100%;
  height: 100%;
  margin: 10px;
  border-radius: 5px;
  height: 350px;
  align-items: center;
  justify-content: space-evenly;
  background-color: #f5fbfd;
  position: relative;

  &:hover ${Info} {
    opacity: 1;
  }
`;

const Circle = styled.div`
  width: 200px;
  height: 200px;
  border-radius: 50%;
  background-color: white;
  position: absolute;
`;

const Image = styled.img`
  height: 90%;
  padding: 10px;
  border-radius: 15px;
  z-index: 2;
  flex: 1;
  object-fit: cover;
`;

const Description = styled.span`
  font-size: 20px;
  font-weight: 500;
  color: #555;
  flex: 1;
`;

const Icon = styled.div`
  width: 40px;
  height: 40px;
  border-radius: 50%;
  background-color: white;
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 10px;
  transition: all 0.5s ease;
  &:hover {
    background-color: #e9f5f5;
    transform: scale(1.1);
  }
`;

const ItemName = styled.h3`
  font-size: 20px;
  font-weight: bold;
  color: black;
  flex: 1;
  text-align: center;
  padding: 10px;
`;

const ItemBrand = styled.h4`
  font-size: 20px;
  font-weight: 200;
  color: #777;
  flex: 1;
  text-align: center;
`;

const ItemPrice = styled.h4`
  font-size: 40px;
  font-weight: 100;
  color: #222;
  flex: 1;
  text-align: center;
`;

const RatingContainer = styled.div`
  text-align: center;
  margin: 10px 0px;
`;

const Product = ({ item }) => {
  // const [value, setValue] = useState(2);
  let random = Math.random() * 5 + 3;

  return (
    <Container>
      {/* <Circle /> */}
      {/* <Preview> */}
      <Image src={img1} alt={item.brand.logoUrl} />
      <Description>
        <ItemName>{item.name}</ItemName>
        <ItemBrand>{item.brand.name}</ItemBrand>
        <ItemPrice>{item.price} PLN</ItemPrice>
        <RatingContainer>
          {/* <Typography component="legend">Controlled</Typography>
          <Rating
            name="simple-controlled"
            value={item.rating}
            onChange={(event, newValue) => {
              setValue(newValue);
            }}
          /> */}
          {/* <Typography component="legend">Rating</Typography> */}
          {/* <Rating name="read-only" value={item.rating} readOnly /> */}
          <Rating name="read-only" value={random} readOnly precision={0.5} />
          {/* <Typography component="legend">Disabled</Typography>
          <Rating name="disabled" value={item.rating} disabled />
          <Typography component="legend">No rating given</Typography>
          <Rating name="no-value" value={null} /> */}
        </RatingContainer>
      </Description>
      {/* </Preview> */}
      <Info>
        <Icon>
          <ShoppingCartOutlined />
        </Icon>
        <Icon>
          <SearchOutlined />
        </Icon>
        <Icon>
          <FavoriteBorderOutlined />
        </Icon>
      </Info>
    </Container>
  );
};

export default Product;
