/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import reservation.myhotelreservation.ConstantsPayment;

/**
 *
 * @author simonecipullo
 */
@Entity
@Table(name = "checkIn")
public class CheckInModel implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status", length = 50)
    private String statusPayment = ConstantsPayment.TO_PAY;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;

    @Column(name = "cost_for_night")
    private Double costForNight;

    @Column(name = "daily_tax")
    private Double dailyTax;

    @Column(name = "check_out_date")
    private LocalDateTime checkOutDate;

    @Column(name = "check_in_date")
    private LocalDateTime checkInDate;

    @Column(name = "total_cost")
    private Double totalCost;

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public Double getCostForNight() {
        return costForNight;
    }

    public void setCostForNight(Double costForNight) {
        this.costForNight = costForNight;
    }

    public Double getDailyTax() {
        return dailyTax;
    }

    public void setDailyTax(Double dailyTax) {
        this.dailyTax = dailyTax;
    }

    public LocalDateTime getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDateTime checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public LocalDateTime getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDateTime checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Long getId() {
        return id;
    }

    public String getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(String statusPayment) {
        this.statusPayment = statusPayment;
    }

}
