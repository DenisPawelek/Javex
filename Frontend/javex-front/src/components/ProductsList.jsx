import styled from "styled-components";
//import { popularProducts } from "../data";
import products from "../test/products";
import ProductPreview from "./ProductPreview";
import { useAxios } from "../hooks/useAxios";

const Container = styled.div`
  padding: 5px;
  display: flex;
  flex-wrap: wrap;
  width: auto;
`;

const ProductsList = () => {
  const { response, loading, error } = useAxios({
    method: "GET",
    url: "/g/many/Product",
    headers: {
      accept: "*/*",
    },
    data: {},
  });

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
