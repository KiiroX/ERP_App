package com.andre.server.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ReducedPrice {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReducedPrice;

    private double reducedPrice;
    private LocalDate startDate;
    private LocalDate endDate;

    public long getIdReducedPrice() {
        return idReducedPrice;
    }

    public void setIdReducedPrice(long idReducedPrice) {
        this.idReducedPrice = idReducedPrice;
    }

    public double getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(double reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

}
