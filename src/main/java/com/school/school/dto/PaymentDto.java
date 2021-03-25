package com.school.school.dto;

import java.util.Date;

public class PaymentDto {

    private Integer id;
    private Integer subscriptionId;
    private Integer userId;
    private Date dateCreated;
    private Date paymentFromDate;
    private Date paymentToDate;
    private String amount;
    private String status;
    private String createdUser;
    private String memberStatus;
    private String firstName;
    private String lastName;
    private String Title;
    private String email;

    public PaymentDto() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getPaymentFromDate() {
        return paymentFromDate;
    }

    public void setPaymentFromDate(Date paymentFromDate) {
        this.paymentFromDate = paymentFromDate;
    }

    public Date getPaymentToDate() {
        return paymentToDate;
    }

    public void setPaymentToDate(Date paymentToDate) {
        this.paymentToDate = paymentToDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }
}
