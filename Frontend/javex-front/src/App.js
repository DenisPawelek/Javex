// import "locomotive-scroll/dist/locomotive-scroll.css";

// import { AnimatePresence } from "framer-motion";
// import { useRef, useState, useEffect } from "react";
// import { LocomotiveScrollProvider } from "react-locomotive-scroll";
// import { ThemeProvider } from "styled-components";

// import Loader from "./components/Loader";
// import ScrollTriggerProxy from "./components/ScrollTriggerProxy";
// import About from "./sections/About";
// import Footer from "./sections/Footer";
// import Home from "./sections/Home";
// import Marquee from "./sections/Marquee";
// import NewArrival from "./sections/NewArrival";
// import Shop from "./sections/Shop";
// import GlobalStyles from "./styles/GlobalStyles";
// import { dark } from "./styles/Themes";

// function App() {
  
//   const containerRef = useRef(null);
//   const [Loaded, setLoaded] = useState(false);

//   useEffect(() => {
//     setTimeout(() => {
//       setLoaded(true);
//     }, 3000);
//   }, []);

//   return (
//     <>
//       <GlobalStyles />
//       <ThemeProvider theme={dark}>
//         <LocomotiveScrollProvider
//           options={{
//             smooth: true,
//             smartphone: {
//               smooth: true,
//             },
//             tablet: {
//               smooth: true,
//             },
//           }}
//           watch={
//             []
//           }
//           containerRef={containerRef}
//         >
//           <AnimatePresence>{Loaded ? null : <Loader />}</AnimatePresence>
//           <main className="App" data-scroll-container ref={containerRef}>
//             <ScrollTriggerProxy />
//             <AnimatePresence>
//               {Loaded ? null : <Loader />}

//               <Home key="home" />
//               <About key="about" />
//               <Shop key="Shop" />
//               <Marquee key="marquee" />
//               <NewArrival key="new arrival" />
//               <Footer key="Footer" />
//             </AnimatePresence>
//           </main>
//         </LocomotiveScrollProvider>
//       </ThemeProvider>
//     </>
//   );
// }

// export default App;



import React from 'react'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import HomepageLayout from './pages/HomepageLayout'
import Kobieta from './pages/Kobieta'
import NotFound from './pages/NotFound'

const App = () => {
  return (
    <Router>
      {/* <Layout> */}
        <Routes>
          <Route exact path="/" element={<HomepageLayout/>}/>
          <Route exact path="/kobieta" element={<Kobieta/>}/>
          <Route path="*" element={<NotFound/>}/> 
        </Routes>
      {/* </Layout> */}
    </Router>
  );
}

export default App;