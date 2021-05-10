package com.school.school.dto;

import org.apache.commons.lang.math.DoubleRange;

import java.io.Serializable;
import java.util.List;

public class StocksInvoiceDto implements Serializable {

    private List<String> products;
    private List<String> unitPrices;
    private List<String> availableQuantities;
    private List<String> quantities;
    private List<String> subTotals;
    private String memberId;
    private Integer discount;
    private Double total;


    public StocksInvoiceDto() {
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public List<String> getUnitPrices() {
        return unitPrices;
    }

    public void setUnitPrices(List<String> unitPrices) {
        this.unitPrices = unitPrices;
    }

    public List<String> getAvailableQuantities() {
        return availableQuantities;
    }

    public void setAvailableQuantities(List<String> availableQuantities) {
        this.availableQuantities = availableQuantities;
    }

    public List<String> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<String> quantities) {
        this.quantities = quantities;
    }

    public List<String> getSubTotals() {
        return subTotals;
    }

    public void setSubTotals(List<String> subTotals) {
        this.subTotals = subTotals;
    }
}
