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
@Table(name = "document")
public class DocumentModel implements Serializable {

    private static final long serialVersionUID = -7441453015228637956L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    @Column(name = "number", length = 50)
    private String number;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "place_Of_Birth", length = 50,nullable=false)
    private String placeOfBirth;

    @Column(name = "resident", length = 50)
    private String resident;

    @Column(name = "date_Of_Birth")
    private LocalDateTime dateOfBirth;

    @Column(name = "nationality", length = 50)
    private String nationality;

    @Column(nullable = false, name = "expiredDoc")
    private LocalDateTime expiredDoc;

    @Column(nullable = false, length = 50, name = "name")
    private String name;

    @Column(nullable = false, length = 50, name = "surname")
    private String surname;

    @Column(nullable = false, name = "relesed")
    private LocalDateTime relesed;

    public String getResident() {
        return resident;
    }

    public void setResident(String resident) {
        this.resident = resident;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDateTime getExpiredDoc() {
        return expiredDoc;
    }

    public void setExpiredDoc(LocalDateTime expiredDoc) {
        this.expiredDoc = expiredDoc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDateTime getRelesed() {
        return relesed;
    }

    public void setRelesed(LocalDateTime relesed) {
        this.relesed = relesed;
    }

}
