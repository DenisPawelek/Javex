//error page
import React from "react";
import styled from "styled-components";
import { motion } from "framer-motion";
//import { Link } from "react-router-dom";

const ErrorContainer = styled(motion.div)`
  position: absolute;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;

  background-color: ${(props) => props.theme.body};
  z-index: 1000;

  display: flex;
  justify-content: center;
  align-items: center;

  h1 {
    font-size: ${(props) => props.theme.fontxl};
    font-weight: 600;
    color: ${(props) => props.theme.text};
  }
`;

const Error = () => {
  return (
    <ErrorContainer
      initial={{ opacity: 1 }}
      animate={{ opacity: 1 }}
      exit={{ opacity: 0 }}
    >
      <h1>ERROR 404</h1>
    </ErrorContainer>
  );
};

export default Error;
