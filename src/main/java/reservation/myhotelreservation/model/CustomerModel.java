/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author simonecipullo
 */
@Entity
@Table(name = "customer")
public class CustomerModel implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }
    @Column(name = "name")
    private String name;
    
    @Column(name = "surname")
    private String surname;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "document_id")
    private DocumentModel document;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Set<GuestModel> guests = new HashSet<>();

 
    @Column(name = "note", columnDefinition="TEXT")
    private String note;

    @Column(name = "black_List")
    private Boolean blackList;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.MERGE})
    @JoinTable(
            name = "rooms_to_customer", schema = "public",
            inverseJoinColumns = {
                @JoinColumn(name = "room_id", referencedColumnName = "id")},
            joinColumns = {
                @JoinColumn(name = "customer_id", referencedColumnName = "id")}
    )
    private Set<RoomModel> rooms = new HashSet<>();

    public Set<RoomModel> getRooms() {
        return rooms;
    }

    public void setRooms(Set<RoomModel> rooms) {
        this.rooms = rooms;
    }

    public Boolean getBlackList() {
        return blackList;
    }

    public void setBlackList(Boolean blackList) {
        this.blackList = blackList;
    }

    public DocumentModel getDocument() {
        return document;
    }

    public void setDocument(DocumentModel document) {
        this.document = document;
    }

    public Set<GuestModel> getGuests() {
        return guests;
    }

    public void setGuests(Set<GuestModel> guests) {
        this.guests = guests;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    
    
}
