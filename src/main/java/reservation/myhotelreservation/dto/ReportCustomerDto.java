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
public class ReportCustomerDto {

    private Integer id;

    private String name;

    private String surname;

    private Document document;

    private List<Guest> guests = new ArrayList<>();

    private String note;

    private Boolean blackList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Boolean getBlackList() {
        return blackList;
    }

    public void setBlackList(Boolean blackList) {
        this.blackList = blackList;
    }


    
    

}
