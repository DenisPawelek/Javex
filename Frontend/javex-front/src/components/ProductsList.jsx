import styled from "styled-components";
//import { popularProducts } from "../data";
import products from "../test/products";
import ProductPreview from "./ProductPreview";
import { useAxios } from "../hooks/useAxios";
import { useEffect } from "react";

const Container = styled.div`
  padding: 5px;
  display: flex;
  flex-wrap: wrap;
  width: auto;
`;

const ProductsList = () => {
  const { fetchData, response, loading, error } = useAxios();

  useEffect (() => {
    fetchData({
      method: "GET",
      url: "/g/many/Product",
      auth: {
        username: "testUser",
        password: "pasword123",
      },
      headers: {
        accept: "*/*",
      },
    });
  }, []);


  return (
    <Container>
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
                  {response.map((item, key = item.id) => (
                    <ProductPreview item={item} key={item.id} />
                  ))}
                </>
              )
            }
          </>
        </>
      )}
    </Container>
  );
};

export default ProductsList;
