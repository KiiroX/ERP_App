import axios from "axios";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

export default function AddItem() {
  let navigate = useNavigate();

  const [item, setItem] = useState({
    itemCode: "",
    description: "",
    state: "ACTIVE",
    price: "",
    supplier: ""
  });

  const { itemCode, description, state, price, supplier } = item;

  const handleChange = (e) => {
    setItem({ ...item, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    await axios.post("", item);
    navigate("/");
  };

  return (
    <div>
      <div className="container">
        <div className="row">
          <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
            <h2 className="text-center m-4">Add a new item</h2>
            <form onSubmit={(e) => handleSubmit(e)}>
              <div className="mb-3">
                <label htmlFor="itemCode" className="form-label">
                  Item code:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="itemCode"
                  value={itemCode}
                  onChange={(e) => handleChange(e)}
                />
              </div>
              <div className="mb-3">
                <label htmlFor="description" className="form-label">
                  Description:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="description"
                  value={description}
                  onChange={(e) => handleChange(e)}
                />
              </div>
              <div className="mb-3">
                <label htmlFor="price" className="form-label">
                  Price:
                </label>
                <input
                  type="number"
                  className="form-control"
                  name="price"
                  value={price}
                  onChange={(e) => handleChange(e)}
                />
              </div>
              <div className="mb-3">
                <label htmlFor="supplier" className="form-label">
                  Supplier:
                </label>
                <input
                  type="text"
                  className="form-control"
                  name="supplier"
                  value={supplier}
                  onChange={(e) => handleChange(e)}
                />
              </div>
              <button type="submit" className="btn btn-outline-primary">
                Submit
              </button>
              <button type="submit" className="btn btn-outline-danger mx-2">
                Cancel
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}
