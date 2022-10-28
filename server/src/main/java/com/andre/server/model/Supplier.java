package com.andre.server.model;

import javax.persistence.*;

@Entity
public class Supplier {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSupplier;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String country;

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

}
