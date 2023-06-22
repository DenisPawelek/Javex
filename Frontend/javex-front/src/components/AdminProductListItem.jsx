import { useEffect, useState } from "react";
import AdminProductForm from "./AdminProductForm";

const AdminProductListItem = ({
  product,
  clickRow,
  deleteProduct,
  saveProduct,
}) => {
  const [isActive, setIsActive] = useState(false);

  const handleClick = () => {
    setIsActive(!isActive);
    // console.log(product);
    clickRow(product);
  };

  useEffect(() => {
    setIsActive(false);
  }, [product]);

  return (
    <>
      <li
        key={product?.id}
        // onClick={() => {
        //   handleClick();
        // }}
      >
        <span>
          <p>
            id: <strong>{product?.id}</strong>
          </p>
          <p>
            name: <strong>{product?.name}</strong>
          </p>
          <p>
            description: <strong>{product?.description}</strong>
          </p>
          <p>
            price: <strong>{product?.price} PLN</strong>
          </p>
        </span>
        <button onClick={() => deleteProduct(product?.id, product?.typeName)}>Delete</button>
        {!isActive ? <button onClick={handleClick}> Edit</button> : null}

        {isActive ? (
          <AdminProductForm product={product} saveProduct={saveProduct} />
        ) : null}
      </li>
    </>
  );
};

export default AdminProductListItem;
