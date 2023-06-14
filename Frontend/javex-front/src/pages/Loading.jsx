//loading component
import React from "react";
import styled from "styled-components";
import { motion } from "framer-motion";

const LoadingContainer = styled(motion.div)`
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
`;
const Loading = () => {
  return (
    <LoadingContainer
      initial={{ opacity: 1 }}
      animate={{ opacity: 1 }}
      exit={{ opacity: 0 }}
    >
      <h1>Loading...</h1>
    </LoadingContainer>
  );
};
export default Loading;
