/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.collins.loan.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author KEN19283
 */
@Data
@Entity
@Table(name = "loan")
public class LoanModel implements Serializable {
  private static final long serialVersionUID = 1L;
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "mobile")
    private String mobile;
    @Column(name = "location")
    private String location;
    @Column(name = "date")
    private String date;
    @Column(name = "duedate")
    private String duedate;
    @Column(name = "amount_requested")
    private long amount_requested;
    @Column(name = "amount_due")
    private long amount_due;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public long getAmount_requested() {
        return amount_requested;
    }

    public void setAmount_requested(long amount_requested) {
        this.amount_requested = amount_requested;
    }

    public long getAmount_due() {
        return amount_due;
    }

    public void setAmount_due(long amount_due) {
        this.amount_due = amount_due;
    }

   
   
    

}
