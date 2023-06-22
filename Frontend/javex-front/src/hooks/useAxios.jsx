import { useState, useEffect, useCallback } from "react";
import axios from "axios";

axios.defaults.baseURL = "http://localhost:8008";

/**
 fixed :
  - no need to JSON.stringify to then immediatly do a JSON.parse
  - don't use export defaults, because default imports are hard to search for
  - axios already support generic request in one parameter, no need to call specialized ones
**/
export const useAxios = () => {
  const [response, setResponse] = useState();
  const [error, setError] = useState();
  const [loading, setLoading] = useState(true);

 async function fetchData (params) {
    console.log("fetchData...");
    console.log(params);
    try {
      let result = await axios.request(params);
      setResponse(result.data);
    } catch (error) {
      setError(error);
    } finally {
      setLoading(false);
    }
  };

  // useEffect(() => {
  //   console.log("axiosParams...");
  //   console.log(axiosParams);
  //   fetchData(axiosParams);
  // }, []); // execute when axiosParams changes

  // useEffect(() => {
  //   console.log("axiosParams...");
  //   console.log(axiosParams);
  //   //fetchData(axiosParams);
  // }, []); // execute once only

  // useEffect(() => {
  //   console.log(error);
  // }, [error]); // execute when error changes

  // useEffect(() => {
  //   console.log(data);
  //   console.log(data);
  // }, [data]); // execute when response changes

  // const PutAxios = (productList) =>
  // {
  //  console.log("PutAxios..." );
  //  console.log(productList);
  // };

  return { fetchData, response, error, loading };
};
