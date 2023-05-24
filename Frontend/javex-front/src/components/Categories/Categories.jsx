//Tutaj jest zrobiony blok ze zdjęciami przekierowywujący na konkretne podstrony

import React from "react";
import "./Categories.scss";
import { Link } from "react-router-dom";

const Categories = () => {
  return (
    <div className="categories">
      <div className="col">
        <div className="row">
          <img
            src="/img/Category1.jpg"
            alt=""
          />
          <button>
          
            <Link  className="link" to="/products/1">
              WYPRZEDAŻ
            </Link>
            
          </button>
        </div>
        <div className="row">
          <img
            src="/img/Category2.jpg"
            alt=""
          />
          <button>
            <Link to="/products/2" className="link">
              NOWOŚCI
            </Link>
          </button>
        </div>
      </div>
      <div className="col">
        <div className="row">
          {" "}
          <img
            src="/img/Category3.jpg"
            alt=""
          />
          <button>
            <Link to="/products/3" className="link">
              KOBIETA
            </Link>
          </button>
        </div>
      </div>
      <div className="col col-l">
        <div className="row">
          <div className="col">
            <div className="row">
              <img
                src="/img/Category4.jpg"
                alt=""
              />
              <button>
                <Link to="/products/4" className="link">
                  MĘŻCZYZNA
                </Link>
              </button>
            </div>
          </div>
          <div className="col">
            <div className="row">
              {" "}
              <img
            src="/img/Category5.jpg"
            alt=""
              />
              <button>
                <Link to="/products/5" className="link">
                  DZIEWCZYNKA
                </Link>
              </button>
            </div>
          </div>
        </div>
        <div className="row">
          <img
            src="/img/Category6.jpg"
            alt=""
          />
          <button>
            <Link to="/products/6" className="link">
              CHŁOPIEC
            </Link>
          </button>
        </div>
      </div>
    </div>
  );
};

export default Categories;
