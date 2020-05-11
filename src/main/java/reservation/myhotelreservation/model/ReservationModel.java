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
import reservation.myhotelreservation.Constants;

/**
 *
 * @author simonecipullo
 */
@Entity
@Table(name = "reservation")
public class ReservationModel implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    @Column(name = "status", length = 50)
    private String status = Constants.CONFIRMED;

    @Column(name = "number_reservation", length = 50, unique = true)
    private String numberReservation;

    @Column(name = "web_site", length = 50)
    private String webSite;

    @Column(name = "note", columnDefinition="TEXT")
    private String note;

    @Column(name = "date_of_arrival")
    private LocalDateTime dateOfArrival = LocalDateTime.now();

    @Column(name = "date_reservation")
    private String dateArrivalReservation = LocalDateTime.now().toString();

    @Column(name = "service")
    private String Service;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "guarentee_id")
    private GuaranteesModel guarentees;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "check_id")
    private CheckInModel check;

    public CheckInModel getCheck() {
        return check;
    }

    public void setCheck(CheckInModel check) {
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

    public LocalDateTime getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(LocalDateTime dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public String getService() {
        return Service;
    }

    public void setService(String Service) {
        this.Service = Service;
    }

    public GuaranteesModel getGuarentees() {
        return guarentees;
    }

    public void setGuarentees(GuaranteesModel guarentees) {
        this.guarentees = guarentees;
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
