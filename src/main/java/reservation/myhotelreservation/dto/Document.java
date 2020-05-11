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
public class Document {

    private Long id;

    private String number;

    private String type;

    private String placeOfBirth;

    private String nationality;

    private String expiredDoc;

    private String name;

    private String surname;

    private String relesed;
    
    private String residence;
    
    private String dateOfBirth;

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getExpiredDoc() {
        return expiredDoc;
    }

    public void setExpiredDoc(String expiredDoc) {
        this.expiredDoc = expiredDoc;
    }

    public String getRelesed() {
        return relesed;
    }

    public void setRelesed(String relesed) {
        this.relesed = relesed;
    }

}
