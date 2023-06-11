import React, { useEffect } from "react";
import { listProduct } from "../redux/actions/productActions";
import { useSelector, useDispatch } from "react-redux";
import { useParams } from "react-router-dom";
import Product from "../newComponents/Product";
import { Row, Col } from "react-bootstrap";
import Loading from "../newComponents/Loading";
import Message from "../newComponents/Message";
import Meta from "../newComponents/Meta";
import Paginate from "../newComponents/Paginate";
//import ProductCarousel from "../components/ProductCarousel";
import products from "../test/products";

const HomeScreen = () => {
  let params = useParams();
  const keyword = params.keyword;
  const pageNumber = params.pageNumber || 1;
  const dispatch = useDispatch();

  const productList = useSelector((state) => state.productList);

  // const { products, loading, error, page, pages } = productList;
  const { loading, error, page, pages } = products;

  useEffect(() => {
    dispatch(listProduct(keyword, pageNumber));
  }, [dispatch, keyword, pageNumber]);

  return (
    <>
      <div>Home</div>
      <Meta title="Clothshop | Home" />
      {/* {!keyword && <ProductCarousel />} */}
      <h3>Latest Products</h3>
      <Row>
        {/* {loading ? (
          <Loading />
        ) : error ? (
          <Message variant="danger">{error}</Message>
        ) : ( */}
          {(products.map((product, index) => (
            <Col sm={12} md={6} lg={4} xl={3}>
              <Product product={product} key={index} />
            </Col>
          ))
        )}
      </Row>
      <Paginate page={page} pages={pages} keyword={keyword ? keyword : ""} />
    </>
  );
};

export default HomeScreen;
