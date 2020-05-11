/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author simonecipullo
 */
@Entity
@Table(name = "checkOut")
public class CheckOutModel implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "check_out_date")
    private LocalDateTime checkOutDate;

    @Column(name = "check_in_date")
    private LocalDateTime checkInDate;
    
    @Column(name = "total")
    private Double total;
    
    @Column(name = "daly_tax")
    private Double dalyTax;
    
    @Column(name = "cost_day")
    private Double costDay;

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
    
    

    public Long getId() {
        return id;
    }

}
