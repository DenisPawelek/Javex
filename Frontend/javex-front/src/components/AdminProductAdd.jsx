import { useState, useEffect } from "react";
import Combobox from "react-widgets/Combobox";
import "react-widgets/scss/styles.scss";
import styled from "styled-components";

//#region styled components
const Container = styled.div`
  width: 100%;
  max-width: 500px;
  flex-direction: column;
  margin: 20px 0px;
  margin-left: auto;
  margin-right: auto;
`;

const Button = styled.button`
  padding: 15px;
  border: 2px solid teal;
  border-radius: 10px;
  background-color: white;
  cursor: pointer;
  font-weight: 500;
  margin: 10px 5px 0px 0px;

  &:hover {
    background-color: #e7e7e7;
  }
`;

const ButtonContainer = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  gap: 20px;
`;

const Row = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: left;
  margin: 0px 0px; 10px 0px;
`;

const Title = styled.div`
  font-size: 20px;
  font-weight: 200;
  margin: 0px 10px 0px 0px;
`;

const Field = styled.input`
  padding: 5px;
  border: 2px solid teal;
  border-radius: 10px;
  background-color: white;
  cursor: pointer;
  font-size: 14px;
  margin: 5px 5px 5px 0px;
  width: 100%;
`;
//#endregion

const AdminProductAdd = ({ productRef, addProduct, saveProduct }) => {
  //#region Słowniki
  const materialDictionary = [
    { id: 30, material_name: "Jeans" },
    { id: 31, material_name: "Bawełna" },
    { id: 32, material_name: "Poliester" },
    { id: 33, material_name: "Skóra" },
    { id: 34, material_name: "Skaja" },
    { id: 35, material_name: "Eko-skóra" },
  ];

  const categoryDictionary = [
    { id: 21, category_name: "Wyjściowe" },
    { id: 22, category_name: "Eleganckie" },
    { id: 23, category_name: "Sportowe" },
  ];

  const sexDictionary = [
    { id: 13, sex_name: "Woman" },
    { id: 14, sex_name: "Uni-sex" },
    { id: 15, sex_name: "Boy" },
    { id: 16, sex_name: "Girl" },
    { id: 17, sex_name: "Kid" },
    { id: 44, sex_name: "Man" },
  ];

  const brandDictionary = [
    { id: 18, brand_name: "Javex" },
    { id: 19, brand_name: "Abibas" },
  ];

  const typeDictionary = [{ id: 43, type_name: "Joggery" }];

  const colorDictionary = [
    { id: 45, color_name: "black" },
    { id: 46, color_name: "white" },
    { id: 47, color_name: "gray" },
    { id: 48, color_name: "brown" },
    { id: 49, color_name: "blue" },
    { id: 50, color_name: "green" },
  ];

  const sizeDictionary = [
    { id: 8, size_name: "XS" },
    { id: 9, size_name: "S" },
    { id: 10, size_name: "M" },
    { id: 11, size_name: "L" },
  ];

  const productTypeDictionary = [
    { id: 1, type_name: "Boots" },
    { id: 2, type_name: "Hoodie" },
    { id: 3, type_name: "Jacket" },
    { id: 4, type_name: "Pants" },
    { id: 5, type_name: "Sweater" },
    { id: 6, type_name: "Shirt" },
  ];
  //#endregion

  const [product, setProd] = useState({
    product: {
      img_url: "",
      price: 0,
      name: "",
      description: "",
      material: { id: 30 },
      category: { id: 21 },
      sex: { id: 44 },
      brand: { id: 18 },
      type: { id: 43 },
      typeName: "Boots",
    },
    reserves: [
      {
        amount: 10,
        color: { id: 45 },
        size: { id: 10 },
      },
      {
        amount: 30,
        color: { id: 46 },
        size: { id: 11 },
      },
      {
        amount: 30,
        color: { id: 47 },
        size: { id: 12 },
      },
    ],
  });

  //   useEffect(() => {
  //     setProd({
  //       //   id: product?.id,
  //       ...product,
  //       name: productRef?.name,
  //       description: productRef?.description,
  //       price: productRef?.price,
  //     });
  //   }, []);

  const handleChange = (e) => {
    setProd({
      ...product,
      product: {
        ...product.product,
        [e.target.name]: e.target.value,
      },
    });
    console.log(product);
  };

  return (
    <Container>
      <Row>
        <Title>Name:</Title>
        <Field
          name="name"
          type="text"
          value={product?.product?.name || ""}
          onChange={handleChange}
        />
      </Row>

      <Row>
        <Title>Description:</Title>
        <Field
          name="description"
          type="text"
          value={product?.product?.description || ""}
          onChange={handleChange}
        />
      </Row>

      <Row>
        <Title>Price:</Title>
        <Field
          name="price"
          type="text"
          value={product?.product?.price || ""}
          onChange={handleChange}
        />
      </Row>

      <Row>
        <Title>Type:</Title>
        <Combobox
          data={productTypeDictionary}
          dataKey="id"
          textField="type_name"
          defaultValue={productTypeDictionary[0]}
          onChange={(item) => {
            return setProd({
              ...product,
              product: { ...product.product, typeName: item.type_name },
            });
          }}
        />
      </Row>

      <ButtonContainer>
        <Button
          onClick={() => {
            console.log(product);
            return addProduct({ product });
          }}
        >
          Add Product
        </Button>
      </ButtonContainer>
    </Container>
  );
};

export default AdminProductAdd;
