import React, { useState } from "react";
import { Form } from "react-bootstrap";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import axios from "axios";

export default function ItemModalUpdate({ item }) {

  const [show, setShow] = useState(false);
  const [isActive, setIsActive] = useState(
    item.state === "ACTIVE" ? true : false
  );
  const [updatedItem, setUpdatedItem] = useState({
    description: "",
    price: "",
  });

  const { description, price } = updatedItem;

  var json = {
    idItem: item.idItem,
    itemCode: item.itemCode,
    description: updatedItem.description,
    price: updatedItem.price,
    state: isActive ? "ACTIVE" : "DISCONTINUED",
    supplier: {
      idSupplier: item.supplier.idSupplier,
      name: item.supplier.name,
      country: item.supplier.country,
    },
    creationDate: item.creationDate,
    creator: {
      idUser: item.creator.idUser,
      name: item.creator.name,
      email: item.creator.email,
    },
  };

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  const handleSave = async (e) => {
    if (updatedItem.description != "" && updatedItem.price != "") {
      console.log(json);
      await axios.put("http://localhost:8080/item/updateItem", json);
      window.location.reload();
    } else {
      alert("All fields must be filled!");
    }
  };

  const handleChangeCheck = (e) => {
    setIsActive(e.target.checked);
  };

  const handleChange = (e) => {
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
