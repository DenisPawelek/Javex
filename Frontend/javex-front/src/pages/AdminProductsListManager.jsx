import React, { useEffect, useRef, useState } from "react";
import styled from "styled-components";
import { useAxios } from "../hooks/useAxios";
import AdminProductListItem from "../components/AdminProductListItem";
import AdminProductAdd from "../components/AdminProductAdd";

//#region Styled Components
const ProductPage = styled.div`
  display: flex;
  flex-direction: column;
  padding: 50px;
  background-color: #f5fbfd;
  justify-content: center;
`;

const ItemsContainer = styled.div`
  display: flex;
  flex: 50%;
  flex-direction: row;
  flex-wrap: wrap;
  align-items: center;
  justify-content: center;
`;

const Row = styled.p`
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  margin: 0px 0px; 10px 0px;
  font-size: 20px;
  font-weight: bold;
`;

const FilterSizeOption = styled.option``;
//#endregion

const AdminProductsListManager = (props) => {
  const [products, setProducts] = useState([]);
  const [selectedProduct, setSelectedProduct] = useState();
  const isNew = useRef(false);
  const Active = useRef();

  // const token =
  //   "eyJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJzZWxmIiwic3ViIjoidGVzdFVzZXIiLCJleHAiOjE2ODY3OTUxMzQsImlhdCI6MTY4NjczNTEzNCwic2NvcGUiOiJST0xFX0FETUlOIn0.Wyr_9x9VsYD857SctBq46dAEWz8No-w3hRxS_yIsxY_DSUVVWIeMWEX0zEbYWiz-oLEWuvk95vq_HbfdkEpxRssjIV495nhLrrLYofioZhQ-xWybCvDTc8rJEAkmjIw5bvnQ66DaSOxnuDIh3k33g6Kg6H7rLY5MS-BooqAAP9b27wEE0O-HS242Nai9KJFt-t_CPGgtR2STUAViPyQFoK7fJ7qDUH3hqi3FinjPzqw7tqLD9dETHud_16a3RkQ5aivos4sqGUZXqY8HST8ar80WHOAAQL-2Gx_XAQYBgXs3GtHwOxGtGE35O4z99VFre_dSMrDaxhTKEwsboapgDQ";

  const { fetchData, response, loading, error } = useAxios();

  useEffect(() => {
    fetchData({
      method: "GET",
      url: "/g/many/Product",
      auth: {
        username: "testUser",
        password: "pasword123",
      }, //zabezpieczyć
      headers: {
        accept: "*/*",
      },
    });
  }, []);

  useEffect(() => {
    console.log("response");
    console.log(response);
    if (products.length > 0) {
      if (isNew.current) {
        isNew.current = false;
        setProducts(() => {
          let newList = [...products];
          newList.push(response[0]);
          return newList;
        });
      } else {
        response &&
          setProducts(() => {
            return products.map((item) =>
              item.id === response[0]?.id ? response[0] : item
            );
          });
      }
    } else {
      response && setProducts(response);
    }
  }, [response]);

  const handleRowClick = (product, setIsActive) => {
    Active.current && Active.current(false);

    setSelectedProduct(product);
    Active.current = setIsActive;
    console.log(product);
  };

  const handleAddProduct = (product) => {
    isNew.current = true;
    try {
      fetchData({
        method: "POST",
        url:
          "/T/TP/Product/" + product?.product?.product?.typeName?.toLowerCase(),
        auth: {
          username: "testUser",
          password: "pasword123",
        },
        params: {
          a: 1,
          b: 1,
        },
        headers: {
          accept: "*/*",
        },
        data: product.product,
      });
    } catch (error) {
      console.log(error);
    }
  };

  const handleSaveProduct = (product) => {
    try {
      fetchData({
        method: "PUT",
        url: "/g/single/" + selectedProduct?.typeName,
        params: { id: product.id },
        auth: {
          username: "testUser",
          password: "pasword123",
        },
        headers: {
          accept: "*/*",
        },
        data: {
          ...selectedProduct,
          description: product.description,
          name: product.name,
          price: product.price,
        },
      });
    } catch (error) {}
  };

  const handleDeleteProduct = (id, typeName) => {
    fetchData({
      method: "DELETE",
      url: "/g/single/" + typeName.toLowerCase(),
      params: { id: id },
      auth: {
        username: "testUser",
        password: "pasword123",
      },
      headers: {
        accept: "*/*",
        "Content-Type": "application/json",
      },
    }).then(() => {
      const newList = products.filter((item) => item.id !== id);
      setProducts(newList);
    });
  };

  return (
    <ProductPage>
      <div>
        <Row>Adding product</Row>
        <AdminProductAdd product={{}} addProduct={handleAddProduct} />
        <hr />
      </div>
      <div>
        {loading ? (
          "Loading..."
        ) : error ? (
          <div>
            <p>{error}</p>
            <p>{error.message}</p>
          </div>
        ) : (
          <ItemsContainer>
            {products.map((item) => {
              return (
                <AdminProductListItem
                  key={item.id}
                  product={item}
                  clickRow={handleRowClick}
                  deleteProduct={handleDeleteProduct}
                  saveProduct={handleSaveProduct}
                />
              );
            })}
          </ItemsContainer>
        )}
      </div>
    </ProductPage>
  );
};

export default AdminProductsListManager;
