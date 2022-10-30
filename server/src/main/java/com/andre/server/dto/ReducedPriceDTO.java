package com.andre.server.dto;

import java.time.LocalDate;

public class ReducedPriceDTO {

    private long idReducedPrice;
    private double reducedPrice;
    private LocalDate startDate;
    private LocalDate endDate;
    private ItemDTO item;

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

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "ReducedPriceDTO{" +
                "idReducedPrice=" + idReducedPrice +
                ", reducedPrice=" + reducedPrice +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", item=" + item.getDescription() +
                '}';
    }

}
