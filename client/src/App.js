import React from "react";
import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./layout/Navbar";
import Home from "./pages/Home";
import AddItem from "./items/AddItem";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import PriceReduction from "./pages/PriceReduction";
import Supplier from "./pages/Supplier";
import User from "./pages/User";

function App() {
  return (
    <div className="App">
      <Router>
        <Navbar />
        <Routes>
          <Route exact path="/" element={<Home />} />
          <Route exact path="/additem" element={<AddItem />} />
          <Route exact path="/priceReduction" element={<PriceReduction/>} />
          <Route exact path="/supplier" element={<Supplier/>} />
          <Route exact path="/user" element={<User/>} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
