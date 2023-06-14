import CoverVideo from "../components/CoverVideo";
import About from "../sections/About";
import Marquee from "../sections/Marquee";
import NewArrival from "../sections/NewArrival";
import Shop from "../sections/Shop";

const HomePage = () => {
  return (
    <>
      <CoverVideo/>
      <About key="about" />
      <Shop key="Shop" />
      <Marquee key="marquee" />
      <NewArrival key="new arrival" />
    </>
  );
};

export default HomePage;
