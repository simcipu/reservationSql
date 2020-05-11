/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.dto;

import java.time.LocalDateTime;
import reservation.myhotelreservation.Constants;


/**
 *
 * @author simonecipullo
 */
public class Reservation {

    private String webSite;

    private String numberReservation;

    private String note;
    
    private String dateArrivalReservation=LocalDateTime.now().toString();
    
    private String status = Constants.CONFIRMED;;

    private String dateOfArrival ;

    private String Service;

    private CheckIn check;

    private Guarantees guarantees;

    public Guarantees getGuarantees() {
        return guarantees;
    }

    public void setGuarantees(Guarantees guarantees) {
        this.guarantees = guarantees;
    }

    public CheckIn getCheck() {
        return check;
    }

    public void setCheck(CheckIn check) {
        this.check = check;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getNumberReservation() {
        return numberReservation;
    }

    public void setNumberReservation(String numberReservation) {
        this.numberReservation = numberReservation;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(String dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }
    

    public String getService() {
        return Service;
    }

    public void setService(String Service) {
        this.Service = Service;
    }

    public String getDateArrivalReservation() {
        return dateArrivalReservation;
    }

    public void setDateArrivalReservation(String dateArrivalReservation) {
        this.dateArrivalReservation = dateArrivalReservation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    
}
