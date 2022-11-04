import React, { useState } from "react";
import { Form } from "react-bootstrap";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import { useNavigate } from "react-router-dom";

export default function ItemModalUpdate({ item }) {
  let navigate = useNavigate();

  const [show, setShow] = useState(false);
  const [isActive, setIsActive] = useState(
    item.state === "ACTIVE" ? true : false
  );
  const [updatedItem, setUpdatedItem] = useState({
    description: "",
    price: "",
  });

  const { description, state, price } = updatedItem;

  var json = {
    idItem: 9,
    itemCode: 1212,
    description: "Item 1212 Modificado",
    price: 100.0,
    state: "ACTIVE",
    supplier: {
      idSupplier: 3,
      name: "Johana",
      country: "Spain",
    },
    creationDate: "2022-10-28",
    creator: {
      idUser: 1,
      name: "Andre",
      email: "andre@gmail.com",
    },
  };

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  const handleSave = (e) => {
    e.preventDefault();
    alert("Entered SAVE");
    if (
      item.itemCode != "" &&
      item.description != "" &&
      item.price != "" &&
      item.supplier != ""
    ) {
      //await axios.post("http://localhost:8080/item/updateItem", json);
      navigate("/");
    } else {
      alert("All fields must be filled!");
    }
  };

  const handleChangeCheck = (e) => {
    setIsActive(e.target.checked);
  };

  const handleChange = (e) => {
    console.log(e.target.name);
    console.log(e.target.value);
    setUpdatedItem({ ...updatedItem, [e.target.name]: e.target.value });
  };

  return (
    <>
      <button className="btn btn-outline-primary max-2" onClick={handleShow}>
        Edit
      </button>

      <Modal
        show={show}
        onHide={handleClose}
        backdrop="static"
        keyboard={false}
        centered
      >
        <Modal.Header closeButton>
          <Modal.Title>Edit item</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form>
            <Form.Group className="mb-3">
              <Form.Label htmlFor="description">Description</Form.Label>
              <Form.Control
                name="description"
                type="text"
                placeholder={item.description}
                onChange={handleChange}
              />
            </Form.Group>
            <Form.Group className="mb-3" controlId="formBasicCheckbox">
              <Form.Check
                name="state"
                type="checkbox"
                label="ACTIVE"
                onChange={handleChangeCheck}
                checked={isActive}
              />
            </Form.Group>
            <Form.Group className="mb-3">
              <Form.Label htmlFor="price">Price</Form.Label>
              <Form.Control
                name="price"
                placeholder={item.price}
                onChange={handleChange}
              />
            </Form.Group>
          </Form>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={handleSave}>
            Save
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}


