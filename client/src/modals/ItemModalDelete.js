import React, { useState } from "react";
import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";
import { Form } from "react-bootstrap";
import axios from "axios";

export default function ItemModalDelete({ item }) {
  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  const handleDelete = async (e) => {
    if (document.getElementById("continue").checked) {
      await axios.delete(
        "http://localhost:8080/item/deleteItem/" + item.itemCode
      );
      window.location.reload();
    } else {
      alert("You must confirm that you want to continue deleting this item!");
    }
  };

  return (
    <>
      <button className="btn btn-danger max-2" onClick={handleShow}>
        Delete
      </button>

      <Modal show={show} onHide={handleClose} centered>
        <Modal.Header closeButton>
          <Modal.Title>
            You are about to delete item {item.itemCode}.<br />
            Do you want to continue?
          </Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form.Check
            id="continue"
            name="continue"
            type="checkbox"
            label="Yes, I want to continue"
          />
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="danger" onClick={handleDelete}>
            Delete
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}
