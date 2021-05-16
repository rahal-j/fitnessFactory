package com.school.school.dto;

public class InvoiceProductDto {

  private int qty;
  private Float unitPrice;



    public InvoiceProductDto() {
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }
}
