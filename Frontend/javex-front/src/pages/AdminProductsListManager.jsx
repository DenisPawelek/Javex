import React, { useEffect, useRef, useState } from "react";
import styled from "styled-components";
import { useAxios } from "../hooks/useAxios";
import AdminProductListItem from "../components/AdminProductListItem";
import AdminProductForm from "../components/AdminProductForm";
import AdminProductAdd from "../components/AdminProductAdd";

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

const AdminProductsListManager = (props) => {
  const [products, setProducts] = useState([]);
  const [selectedProduct, setSelectedProduct] = useState();
  const isNew = useRef(false);

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

  const handleRowClick = (product) => {
    setSelectedProduct(product);
    console.log(selectedProduct);
  };

  const handleAddProduct = (product) => {
    // console.log("before add");
    // console.log(product);
    // console.log(product.product);
    // console.log(product.product.product);
    // console.log(product.product.product.typeName);
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
      // let p = selectedProduct;
      // delete p.isLong;
      // delete p.reserves;
      // console.log(p);
      console.log("product");
      console.log(product);
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
    } catch (error) {
      console.log(error);
    }
  };

  const handleDeleteProduct = (id, typeName) => {
    console.log("delete");
    console.log(id);
    console.log(typeName);
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

    
    //   .then((response) => {
    //     if (response.ok) {
    //       return response;
    //     }
    //     throw Error(response.status);
    //   })
    //   .then(setProducts(products.filter((item) => item.id !== id)))
    //   .catch((error) => console.log(error));
  };

  const productsList = products.map((item) => {
    return (
      <AdminProductListItem
        key={item.id}
        product={item}
        clickRow={handleRowClick}
        deleteProduct={handleDeleteProduct}
        saveProduct={handleSaveProduct}
      />
    );
  });

  return (
    <ProductPage>
      {
        <div>
          {loading ? (
            "Loading..."
          ) : error ? (
            <div>
              <p>{error}</p>
              <p>{error.message}</p>
            </div>
          ) : (
            <div>
              <ul>{productsList}</ul>
              <br />
              <p>Adding product</p>
              <AdminProductAdd product={{}} addProduct={handleAddProduct} />
            </div>
          )}
        </div>
      }
    </ProductPage>
  );
};

export default AdminProductsListManager;
