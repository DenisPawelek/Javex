import styled from "styled-components";
// import Navbar from "../components/Navbar";
// import Announcement from "../components/Announcement";
import ProductsList from "../components/ProductsList";
// import Newsletter from "../components/Newsletter";
// import Footer from "../components/Footer";
// import { mobile } from "../responsive";

const Container = styled.div``;

const Title = styled.h1`
  margin: 20px;
`;

const FilterContainer = styled.div`
  display: flex;
  justify-content: space-between;
`;

const Filter = styled.div`
  margin: 20px;
`;

const FilterText = styled.span`
  font-size: 20px;
  font-weight: 600;
  margin-right: 20px;
`;

const Select = styled.select`
  padding: 10px;
  margin-right: 20px;
`;
const Option = styled.option``;

const ProductsPage = () => {
  return (
    <Container>
      {/* <Navbar /> */}
      {/* <Announcement /> */}
      <Title>Woman</Title>
      <FilterContainer>
        <Filter>
          <FilterText>Filter Products:</FilterText>
          <Select defaultValue={"Color"}>
            <Option disabled>
              Color
            </Option>
            <Option>White</Option>
            <Option>Black</Option>
            <Option>Red</Option>
            <Option>Blue</Option>
            <Option>Yellow</Option>
            <Option>Green</Option>
          </Select>
          <Select defaultValue={"Size"}>
            <Option disabled>
              Size
            </Option>
            <Option>XS</Option>
            <Option>S</Option>
            <Option>M</Option>
            <Option>L</Option>
            <Option>XL</Option>
          </Select>
        </Filter>
        <Filter>
          <FilterText>Sort Products:</FilterText>
          <Select defaultValue={"Newest"}>
            <Option >Newest</Option>
            <Option>Price (asc)</Option>
            <Option>Price (desc)</Option>
          </Select>
        </Filter>
      </FilterContainer>
      <ProductsList />
      {/* <Newsletter /> */}
      {/* <Footer /> */}
    </Container>
  );
};

export default ProductsPage;