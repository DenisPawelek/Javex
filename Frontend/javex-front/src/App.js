import "locomotive-scroll/dist/locomotive-scroll.css";

import { AnimatePresence } from "framer-motion";
import { useRef, useState, useEffect } from "react";
import { LocomotiveScrollProvider } from "react-locomotive-scroll";
import { ThemeProvider } from "styled-components";

import Loader from "./components/Loader";
import ScrollTriggerProxy from "./components/ScrollTriggerProxy";
import Footer from "./sections/Footer";
import Home from "./sections/Header";
import GlobalStyles from "./styles/GlobalStyles";
import { dark } from "./styles/Themes";
import { Route, Routes } from "react-router-dom";
import Error from "./pages/Error";
import HomePage from "./pages/HomePage";
import ProductsView from "./pages/ProductsView";
import Header from "./sections/Header";
//import Header from "./newComponents/Header";
//import Footer from "./newComponents/Footer";
// import LoginScreen from "./screens/LoginScreen";
// import RegisterScreen from "./screens/RegisterScreen";
// import ProfileScreen from "./screens/ProfileScreen";
// import ShippingScreen from "./screens/ShippingScreen";
// import PaymentScreen from "./screens/PaymentScreen";
// import PlaceOrderScreen from "./screens/PlaceOrderScreen";
// import OrderScreen from "./screens/OrderScreen";
// import UserListScreen from "./screens/UserListScreen";
// import UserEditScreen from "./screens/UserEditScreen";
// import ProductListScreen from "./screens/ProductListScreen";
// import CreateProductScreen from "./screens/CreateProductScreen";
// import EditProductScreen from "./screens/EditProductScreen";
// import OrderListScreen from "./screens/OrderListScreen";
// import HomeScreen from "./screens/HomeScreen";
// import ProtectedRoute from "./newComponents/ProtectedRoute";
// import OnlyAdmin from "./newComponents/OnlyAdmin";
// import CartScreen from "./screens/CartScreen";
// import ProductScreen from "./screens/ProductScreen";
import Product from "./components/Product";
import ProductsPage from "./pages/ProductsPage";

import SignInForm from "./pages/SignInForm";
import SignUpForm from "./pages/SignUpForm";

import Profile from './pages/Profile';

function App() {
  const containerRef = useRef(null);
  const [Loaded, setLoaded] = useState(false);

  useEffect(() => {
    setTimeout(() => {
      setLoaded(true);
    }, 3000);
  }, []);

  return (
    <>
      <GlobalStyles />
      <ThemeProvider theme={dark}>
        <LocomotiveScrollProvider
          options={{
            smooth: true,
            smartphone: {
              smooth: true,
            },
            tablet: {
              smooth: true,
            },
          }}
          watch={[]}
          containerRef={containerRef}
        >
          <AnimatePresence>{Loaded ? null : <Loader />}</AnimatePresence>
          <main className="App" data-scroll-container ref={containerRef}>
            <ScrollTriggerProxy />
            <AnimatePresence>
              {/* {Loaded ? null : <Loader />} */}

              <Header key="Header" />
              {/* <Header /> */}
              <Routes>
                <Route index path="/" element={<HomePage />} />
                {/* <Route index path="/" element={<HomeScreen />} /> */}

                <Route path="/man" element={<ProductsView />} />
                <Route path="/woman" element={<ProductsPage />} />
                <Route path="/boy" element={<ProductsView />} />
                <Route path="/girl" element={<Product />} />
                <Route path="/new" element={<ProductsView />} />
                <Route path="/sale" element={<Product />} />

                <Route path="/login" element={<SignInForm/>} />
                <Route path="/register" element={<SignUpForm />} />

                <Route path="/profile" element={<Profile />} />

                {/* <Route path="/product:id" element={<ProductsView />} /> */}
                {/* <Route path="/product/:id" element={<ProductScreen />} />
                <Route path="/cart" element={<CartScreen />} />

                <Route path="/login" element={<LoginScreen />} />
                <Route path="/register" element={<RegisterScreen />} />

                <Route path="/profile" element={<ProtectedRoute />}>
                  <Route path="/profile" element={<ProfileScreen />} />
                </Route>

                <Route path="/shipping" element={<ProtectedRoute />}>
                  <Route path="/shipping" element={<ShippingScreen />} />
                </Route>
                <Route path="/payment" element={<ProtectedRoute />}>
                  <Route path="/payment" element={<PaymentScreen />} />
                </Route>
                <Route path="/placeorder" element={<ProtectedRoute />}>
                  <Route path="/placeorder" element={<PlaceOrderScreen />} />
                </Route>
                <Route path="/order/:id" element={<ProtectedRoute />}>
                  <Route path="/order/:id" element={<OrderScreen />} />
                </Route>
                <Route path="/admin/users" element={<OnlyAdmin />}>
                  <Route path="/admin/users" element={<UserListScreen />} />
                </Route>
                <Route path="/admin/users/edit/:id" element={<OnlyAdmin />}>
                  <Route
                    path="/admin/users/edit/:id"
                    element={<UserEditScreen />}
                  />
                </Route>
                <Route path="/admin/products" element={<OnlyAdmin />}>
                  <Route
                    path="/admin/products"
                    element={<ProductListScreen />}
                  />
                  <Route
                    path="/admin/products/:pageNumber"
                    element={<ProductListScreen />}
                  />
                </Route>
                <Route path="/admin/products/create" element={<OnlyAdmin />}>
                  <Route
                    path="/admin/products/create"
                    element={<CreateProductScreen />}
                  />
                </Route>
                <Route path="/admin/product/edit/:id" element={<OnlyAdmin />}>
                  <Route
                    path="/admin/product/edit/:id"
                    element={<EditProductScreen />}
                  />
                </Route>
                <Route path="/admin/orders" element={<OnlyAdmin />}>
                  <Route path="/admin/orders" element={<OrderListScreen />} />
                </Route>
                <Route path="/page/:pageNumber" element={<HomeScreen />} />
                <Route
                  path="/search/:keyword/page/:pageNumber"
                  element={<HomeScreen />}
                />
                <Route path="/search/:keyword" element={<HomeScreen />} /> */}

                <Route path="/*" element={<Error />} />
              </Routes>
              <Footer key="Footer" />
            </AnimatePresence>
          </main>
        </LocomotiveScrollProvider>
      </ThemeProvider>
    </>
  );
}

export default App;
