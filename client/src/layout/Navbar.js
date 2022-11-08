import React from "react";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

export default function MyNavbar() {
  return (
    <>
      <Navbar bg="dark" variant="dark">
        <Container fluid>
          <Navbar.Brand href="/">ERP_App</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="/">Items</Nav.Link>
            <Nav.Link href="priceReduction">Reductions</Nav.Link>
            <Nav.Link href="supplier">Suppliers</Nav.Link>
            <Nav.Link href="user">Users</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
    </>
  );
}