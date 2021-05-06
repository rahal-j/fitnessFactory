package com.school.school.dto;

public class InvoiceProductDto {

  private int qty;
  private double unitPrice;



    public InvoiceProductDto() {
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
