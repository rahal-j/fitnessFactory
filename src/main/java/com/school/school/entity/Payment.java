package com.school.school.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id_no")
    private Member memberId;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "payment_from_date")
    private Date paymentFromDate;

    @Column(name = "payment_to_date")
    private Date paymentToDate;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "status")
    private String status;

    @Column(name = "created_user")
    private String createdUser;

    @Column(name = "membership_expire_date")
    private Date expireDate;

    public Payment() {
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Member getMemberId() {
        return memberId;
    }

    public void setMemberId(Member memberId) {
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
