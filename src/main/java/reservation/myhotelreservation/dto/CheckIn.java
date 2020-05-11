/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.dto;

import reservation.myhotelreservation.ConstantsPayment;

/**
 *
 * @author simonecipullo
 */
public class CheckIn {

    private Long id;

    private Customer customer;

    private Double costForNight;

    private Double dailyTax;

    private String checkOutDate;

    private String checkInDate;

    private String StatusPayment = ConstantsPayment.TO_PAY;

    private Double totalCost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
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

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getStatusPayment() {
        return StatusPayment;
    }

    public void setStatusPayment(String StatusPayment) {
        this.StatusPayment = StatusPayment;
    }

}
