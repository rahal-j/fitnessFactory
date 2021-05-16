package com.school.school.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PaymentDto {

    private Integer id;
    private Integer subscriptionId;
    private Integer memberId;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateCreated;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date paymentFromDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date paymentToDate;
    private Float amount;
    private String status;
    private String createdUser;
    private String memberStatus;
    private String firstName;
    private String lastName;
    private String Title;
    private String email;
    private Date expireDate;
    private String oldexpireDate;

    public PaymentDto() {

    }


    public String getOldexpireDate() {
        return oldexpireDate;
    }

    public void setOldexpireDate(String oldexpireDate) {
        this.oldexpireDate = oldexpireDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
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

    public Integer  getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
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

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
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
