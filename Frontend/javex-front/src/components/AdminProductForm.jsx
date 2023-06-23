import { useState, useEffect } from "react";
import styled from "styled-components";

//#region styled components
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

const AdminProductForm = ({ product, addProduct, saveProduct }) => {
  const [prod, setProd] = useState({
    id: null,
    name: "",
    description: "",
    price: "",
  });

  useEffect(() => {
    setProd({
      id: product?.id,
      name: product?.name,
      description: product?.description,
      price: product?.price,
    });
  }, []);

  const handleChange = (e) => {
    setProd({ ...prod, [e.target.name]: e.target.value });
  };

  return (
    <>
      <hr />
      <div>
        <Row>
          <Title>ID:</Title> {prod?.id}
        </Row>

        <Row>
          <Title> Name: </Title>
          <Field
            name="name"
            type="text"
            value={prod?.name || ""}
            onChange={handleChange}
          />
        </Row>

        <Row>
          <Title>Description:</Title>
          <Field
            name="description"
            type="text"
            value={prod?.description || ""}
            onChange={handleChange}
          />
        </Row>

        <Row>
          <Title>Price:</Title>
          <Field
            name="price"
            type="text"
            value={prod?.price || ""}
            onChange={handleChange}
          />
        </Row>

        <ButtonContainer>
          <Button
            onClick={() =>
              saveProduct({
                id: prod?.id,
                name: prod?.name,
                description: prod?.description,
                price: prod?.price,
              })
            }
          >
            Save
          </Button>
        </ButtonContainer>
      </div>
    </>
  );
};

export default AdminProductForm;
