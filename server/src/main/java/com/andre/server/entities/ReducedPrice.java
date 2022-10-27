package com.andre.server.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class ReducedPrice {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idReducedPrice;

    @Column(nullable = false)
    private double reducedPrice;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Item item;

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
