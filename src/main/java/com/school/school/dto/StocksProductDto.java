package com.school.school.dto;

import java.io.Serializable;
import java.util.List;

public class StocksProductDto implements Serializable {

    private List<String> products;
    private List<String> quantities;
    private List<String> expiredates;
    private List<String> batchNos;
    private List<String> datesCreated;


    public StocksProductDto() {
    }

    public List<String> getDatesCreated() {
        return datesCreated;
    }

    public void setDatesCreated(List<String> datesCreated) {
        this.datesCreated = datesCreated;
    }

    public List<String> getBatchNos() {
        return batchNos;
    }

    public void setBatchNos(List<String> batchNos) {
        this.batchNos = batchNos;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public List<String> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<String> quantities) {
        this.quantities = quantities;
    }

    public List<String> getExpiredates() {
        return expiredates;
    }

    public void setExpiredates(List<String> expiredates) {
        this.expiredates = expiredates;
    }
}
