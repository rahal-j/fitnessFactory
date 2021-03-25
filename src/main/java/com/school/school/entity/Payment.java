package com.school.school.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "subscription_id")
    private Subscription subscriptionId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "payment_from_date")
    private Date paymentFromDate;

    @Column(name = "payment_to_date")
    private Date paymentToDate;

    @Column(name = "amount")
    private String amount;

    @Column(name = "status")
    private String status;

    @Column(name = "created_user")
    private String createdUser;

    public Payment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Subscription getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Subscription subscriptionId) {
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
