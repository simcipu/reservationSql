/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.service;

import java.util.List;
import reservation.myhotelreservation.dto.Room;

/**
 *
 * @author simonecipullo
 */
public interface RoomService {

    List<Room> create(List<Room> l);

    void update(List<Room> l);

    List<Room> get();
    
    Boolean delete(String number);
    
    Room create(Room room);
    
    Boolean update(Room l);
    
    List<Room> findFromFloor(Integer floor);

}
