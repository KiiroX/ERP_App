package com.andre.server.dto;

public class SupplierDTO {

    private long idSupplier;
    private String name;
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

    @Override
    public String toString() {
        return "SupplierDTO{" +
                "idSupplier=" + idSupplier +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}
