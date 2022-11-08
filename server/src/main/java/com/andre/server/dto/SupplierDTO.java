package com.andre.server.dto;

import java.util.ArrayList;
import java.util.List;

public class SupplierDTO {

    private long idSupplier;
    private String name;
    private String country;
    private List<ItemDTO> items;

    public long getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(long idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public void addItem(ItemDTO item) {
        if(this.items == null) {
            this.items = new ArrayList<>();
        }

        this.items.add(item);
    }

}
