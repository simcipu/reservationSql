/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author simonecipullo
 */
public class Report {

    private ReportCustomerDto customer;

    private Integer totalVisit;

    private Double total;

    private List<String> rooms = new ArrayList<>();

    private List<String> rates;

    private List<String> checkInDate = new ArrayList<>();

    private List<String> checkOutDate = new ArrayList<>();

    private List<Guarantees> Guarantees = new ArrayList<>();

    private List<String> reservationNumber = new ArrayList<>();
    
    private Integer page;
    
    private Integer size;


    public List<String> getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(List<String> reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public List<Guarantees> getGuarantees() {
        return Guarantees;
    }

    public void setGuarantees(List<Guarantees> Guarantees) {
        this.Guarantees = Guarantees;
    }

    public List<String> getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(List<String> checkInDate) {
        this.checkInDate = checkInDate;
    }

    public ReportCustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(ReportCustomerDto customer) {
        this.customer = customer;
    }

    public Integer getTotalVisit() {
        return totalVisit;
    }

    public void setTotalVisit(Integer totalVisit) {
        this.totalVisit = totalVisit;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<String> getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(List<String> checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public List<String> getRooms() {
        return rooms;
    }

    public void setRooms(List<String> rooms) {
        this.rooms = rooms;
    }

    public List<String> getRates() {
        return rates;
    }

    public void setRates(List<String> rates) {
        this.rates = rates;
    }

    
 
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
  

}
