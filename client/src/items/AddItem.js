import React, { useState } from "react";

export default function AddItem() {
  const [item, setItem] = useState({
    itemCode: "",
    description: "",
    state: "",
    price: "",
  });

  const { itemCode, description, state, price } = item;

  const handleChange = (e) => {
    setItem({ ...item, [e.target.name]: e.target.value });
  };

  return (
    <div>
      <div className="container">
        <div className="row">
          <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
            <h2 className="text-center m-4">Add a new item</h2>
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
              <label htmlFor="state" className="form-label">
                State:
              </label>
              <input
                type="text"
                className="form-control"
                name="state"
                value={state}
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
            <button type="submit" className="btn btn-outline-primary">
              Submit
            </button>
            <button type="submit" className="btn btn-outline-danger mx-2">
              Cancel
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}
