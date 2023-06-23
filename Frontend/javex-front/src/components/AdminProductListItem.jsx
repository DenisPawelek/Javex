import { useEffect, useState } from "react";
import AdminProductForm from "./AdminProductForm";
import styled from "styled-components";

//#region styled components
const ItemContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: left;
  justify-content: center;
  margin: 20px 10px 0px 10px;
  padding: 20px;
  border: 2px solid teal;
  border-radius: 10px;
  background-color: #f5fbfd;
  width: 100%;
  max-width: 500px;
  gap: 20px;
  font-size: 18px;
`;

const ButtonContainer = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  gap: 20px;
`;

const Button = styled.button`
  padding: 15px;
  border: 2px solid teal;
  border-radius: 10px;
  background-color: white;
  cursor: pointer;
  font-weight: 500;
  margin: 0px 5px 0px 0px;

  &:hover {
    background-color: #e7e7e7;
  }
`;

const Row = styled.p`
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: left;
  margin: 0px 0px; 10px 0px;
`;

const Title = styled.span`
  font-size: 20px;
  font-weight: 200;
  margin: 0px 10px 0px 0px;
`;
//#endregion

const AdminProductListItem = ({
  product,
  clickRow,
  deleteProduct,
  saveProduct,
}) => {
  const [isActive, setIsActive] = useState(false);

  const handleClick = () => {
    setIsActive(!isActive);
    clickRow(product, setIsActive);
  };

  useEffect(() => {
    setIsActive(false);
  }, [product]);

  return (
    <ItemContainer>
      <span>
        <Row>
          <Title>ID:</Title> <strong>{product?.id}</strong>
        </Row>
        <Row>
          <Title>Name:</Title> <strong>{product?.name}</strong>
        </Row>
        <Row>
          <Title> Description:</Title> <strong>{product?.description}</strong>
        </Row>
        <Row>
          <Title> Pice:</Title> <strong>{product?.price} PLN</strong>
        </Row>
      </span>
      <ButtonContainer>
        <Button onClick={() => deleteProduct(product?.id, product?.typeName)}>
          Delete
        </Button>
        {!isActive ? <Button onClick={handleClick}> Edit</Button> : null}
      </ButtonContainer>
      {isActive ? (
        <AdminProductForm product={product} saveProduct={saveProduct} />
      ) : null}
    </ItemContainer>
  );
};

export default AdminProductListItem;
