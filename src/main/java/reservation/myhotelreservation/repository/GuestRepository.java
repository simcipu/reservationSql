/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import reservation.myhotelreservation.model.GuestModel;

/**
 *
 * @author simonecipullo
 */
public interface GuestRepository extends Repository<GuestModel, Long> {

    @Query("select u from GuestModel u where u.name=?1 and u.surname=?2")
    List<GuestModel> findGuest(String name, String surname);

}
