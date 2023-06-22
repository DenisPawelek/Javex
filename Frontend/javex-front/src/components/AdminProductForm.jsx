import { useState, useEffect } from "react";

const AdminProductForm = ({ product, addProduct, saveProduct }) => {
  const [prod, setProd] = useState({
    id: null,
    name: "",
    description: "",
    price: "",
  });

  useEffect(() => {
    setProd({
      id: product?.id,
      name: product?.name,
      description: product?.description,
      price: product?.price,
    });
  }, []);

  const handleChange = (e) => {
    setProd({ ...prod, [e.target.name]: e.target.value });
  };

  return (
    <div>
      Id: {prod?.id}
      <br />
      Name:{" "}
      <input
        name="name"
        type="text"
        value={prod?.name || ""}
        onChange={handleChange}
      />
      <br />
      Description:{" "}
      <input
        name="description"
        type="text"
        value={prod?.description || ""}
        onChange={handleChange}
      />
      <br />
      Price:{" "}
      <input
        name="price"
        type="text"
        value={prod?.price || ""}
        onChange={handleChange}
      />
      <br />
      {prod?.id ? null : (
        <button
          onClick={() =>
            addProduct({
              name: prod?.name,
              description: prod?.description,
              price: prod?.price,
            })
          }
        >
          Add Product
        </button>
      )}
      {prod?.id ? (
        <button
          onClick={() =>
            saveProduct({
              id: prod?.id,
              name: prod?.name,
              description: prod?.description,
              price: prod?.price,
            })
          }
        >
          Save
        </button>
      ) : null}
    </div>
  );
};

export default AdminProductForm;
