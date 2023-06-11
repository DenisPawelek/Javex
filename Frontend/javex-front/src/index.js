import React from "react";
import { createRoot } from "react-dom/client";
import App from "./App";
import { BrowserRouter } from "react-router-dom";
import { Provider } from "react-redux";
import store from "./test/store";
//import "./bootstrap.min.css";
import "./index.css";

const root = createRoot(document.getElementById("root"));

root.render(
    <BrowserRouter>
      <App />
    </BrowserRouter>
);
