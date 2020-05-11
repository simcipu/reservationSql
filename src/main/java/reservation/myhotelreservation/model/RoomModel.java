/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author simonecipullo
 */
@Entity
@Table(name = "room")
public class RoomModel implements Serializable {

    private static final long serialVersionUID = -7441453015228637956L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "service", length = 255)
    private String service;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

}
