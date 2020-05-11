/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.repository;

import java.util.List;
import reservation.myhotelreservation.model.RoomModel;

/**
 *
 * @author simonecipullo
 */
public interface RoomRepository extends Repository<RoomModel, Long> {

    RoomModel findByRoomNumber(String number);

    List<RoomModel> findByFloor(Integer floor);

}
