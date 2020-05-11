/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.dto;

/**
 *
 * @author simonecipullo
 */
public class CheckOut {

    private Long id;

    private String checkOutDate;

    private String checkInDate;

    private Double total;

    private Double dalyTax;

    private Double costDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDalyTax() {
        return dalyTax;
    }

    public void setDalyTax(Double dalyTax) {
        this.dalyTax = dalyTax;
    }

    public Double getCostDay() {
        return costDay;
    }

    public void setCostDay(Double costDay) {
        this.costDay = costDay;
    }
    
    

}
