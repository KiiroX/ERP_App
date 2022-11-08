package com.andre.server.dto;

import com.andre.server.model.StateEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ItemDTO {

    private long idItem;
    private long itemCode;
    private String description;
    private double price;
    private StateEnum state;
    private List<SupplierDTO> suppliers;
    private LocalDate creationDate;
    private UserDTO creator;

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }

    public long getItemCode() {
        return itemCode;
    }

    public void setItemCode(long itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public List<SupplierDTO> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<SupplierDTO> suppliers) {
        this.suppliers = suppliers;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }

    public void addSupplier(SupplierDTO supplier) {
        if(this.suppliers == null) {
            this.suppliers = new ArrayList<>();
        }

        this.suppliers.add(supplier);
    }

}
