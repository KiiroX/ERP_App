import React, { useState } from "react";
import axios from "axios";
import { Form } from "react-bootstrap";
import Button from "react-bootstrap/Button";
import Table from "react-bootstrap/Table";
import Modal from "react-bootstrap/Modal";

export default function ItemModalView({ item }) {
  const [show, setShow] = useState(false);
  const [reducedPrices, setReducedPrices] = useState([]);

  const loadReducedPrices = async () => {
    const result = await axios.get(
      "http://localhost:8080/price/price/" + item.itemCode
    );
    setReducedPrices(result.data);
  };

  const handleClose = () => setShow(false);
  const handleShow = () => {
    loadReducedPrices();
    setShow(true);
  };

  return (
    <>
      <button className="btn btn-primary max-2" onClick={handleShow}>
        View
      </button>

      <Modal show={show} onHide={handleClose} centered>
        <Modal.Header closeButton>
          <Modal.Title>Item {item.itemCode} </Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <Form.Label htmlFor="reducedPrice">Price reductions:</Form.Label>
          <Table>
            <thead>
              <tr>
                <th>Reduced price</th>
                <th>Start date</th>
                <th>End date</th>
              </tr>
            </thead>
            <tbody>
              {reducedPrices.map((reducedPrice, index) => (
                <tr key={index}>
                  <td>{reducedPrice.reducedPrice}</td>
                  <td>{reducedPrice.startDate}</td>
                  <td>{reducedPrice.endDate}</td>
                </tr>
              ))}
            </tbody>
          </Table>
          <Form.Label htmlFor="supplier">Supplier:</Form.Label>
          <Table>
            <thead>
              <tr>
                <th>Name</th>
                <th>Country</th>
              </tr>
            </thead>
            <tbody>
                <tr>
                  <td>{item.supplier.name}</td>
                  <td>{item.supplier.country}</td>
                </tr>
            </tbody>
          </Table>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
}
