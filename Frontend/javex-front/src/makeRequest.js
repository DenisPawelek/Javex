import axios from "axios";

// const baseURL = "http://localhost:8008/g/";

export const makeRequest = axios.create({
  baseURL : "http://localhost:8008/g/",
  //baseURL: process.env.REACT_APP_API_URL,
  //headers: {
    //Authorization: "bearer " + process.env.REACT_APP_API_TOKEN,
  //},
});
