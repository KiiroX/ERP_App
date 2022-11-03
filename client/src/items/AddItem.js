import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

export default function AddItem() {
  let navigate = useNavigate();

  /*--- GET SUPPLIERS FROM SERVER AND SET THEM IN suppliers ---*/
  const [suppliers, setSuppliers] = useState([]);

  useEffect(() => {
    loadSuppliers();
  }, []);

  const loadSuppliers = async () => {
    const result = await axios.get("http://localhost:8080/supplier/supplier");
    setSuppliers(result.data);
  };
  /*----------*/

  /*--- DEFINE ITEM AND SAVE IT ---*/
  const [item, setItem] = useState({
    itemCode: "",
    description: "",
    price: "",
    state: "ACTIVE",
    supplier: "",
    creationDate: getCurrentDate(),
    creator: ""
  });

  const { itemCode, description, price, state, supplier, creationDate, creator } = item;
  /*----------*/

  //PREPARE JSON TO POST
  var json = {
    "itemCode": item.itemCode,
    "description": item.description,
    "price": item.price,
    "state": item.state,
    "supplier": {
        "idSupplier": item.supplier
    },
    "creationDate": item.creationDate,
    "creator": {
        "idUser": 1 //TODO: get idUser from the login
    }
}

function getCurrentDate() {
  var today = new Date();
  var dd = String(today.getDate()).padStart(2, '0');
  var mm = String(today.getMonth() + 1).padStart(2, '0');
  var yyyy = today.getFullYear();

  return today = yyyy + '-' + mm + '-' + dd;
}


  /*--- HANDLERS ---*/
  const handleChange = (e) => {
    setItem({ ...item, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if(item.itemCode != "" && item.description != "" && item.price != "" && item.supplier != "") {
      await axios.post("http://localhost:8080/item/addItem", json);
      navigate("/");
    } else {
      alert("All fields must be filled!");
    }
  };
  /*----------*/

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
                  type="number"
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
                <select name="supplier" className="form-control" onChange={(e) => handleChange(e)}>
                  <option></option>
                  {suppliers.map((supplier, index) => (
                    <option key={index} value={supplier.idSupplier}>{supplier.name}</option>
                  ))}
                </select>
              </div>
              <button type="submit" className="btn btn-outline-primary">
                Submit
              </button>
              <Link type="submit" className="btn btn-outline-danger mx-2" to="/">
                Cancel
              </Link>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}
