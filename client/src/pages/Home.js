import React, { useEffect, useState } from "react";
import axios from "axios";
import ItemModalUpdate from "../modals/ItemModalUpdate";
import ItemModalView from "../modals/ItemModalView";

export default function Home() {

  const [items, setItems] = useState([]);

  useEffect(() => {
    loadItems();
  }, []);

  const loadItems = async () => {
    const result = await axios.get("http://localhost:8080/item/item");
    setItems(result.data);
  };

  return (
    <div className="container">
      <div className="py-4">
        <table className="table shadow">
          <thead>
            <tr>
              <th scope="col">Code</th>
              <th scope="col">Description</th>
              <th scope="col">State</th>
              <th scope="col">Price</th>
              <th scope="col">Creation date</th>
              <th scope="col">Creator</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            {items.map((item, index) => (
              <tr key={index}>
                <th scope="row">{item.itemCode}</th>
                <td>{item.description}</td>
                <td>{item.state}</td>
                <td>{item.price}</td>
                <td>{item.creationDate}</td>
                <td>{item.creator.name}</td>
                <td>
                  <ItemModalView item={item} />
                  <ItemModalUpdate item={item} />
                  <button className="btn btn-danger max-2">Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
