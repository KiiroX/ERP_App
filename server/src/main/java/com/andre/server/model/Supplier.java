package com.andre.server.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Supplier {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSupplier;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "item_supplier", joinColumns = @JoinColumn(name = "supplier_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "item_id", nullable = false))
    private List<Item> items;

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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        if(this.items == null) {
            this.items = new ArrayList<>();
        }

        this.items.add(item);
    }

}
