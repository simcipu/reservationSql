/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import reservation.myhotelreservation.model.CheckInModel;

/**
 *
 * @author simonecipullo
 */
public interface CheckInRepository extends Repository<CheckInModel, Long> {

    @Query("select u from CheckInModel u where (u.checkInDate between ?1 and ?2)")
    Page<CheckInModel> fromCheckIn(LocalDateTime checkInDate, LocalDateTime checkOutDate, Pageable page);

    @Query("select u from CheckInModel u where u.customer.document.number=?1")
    Page<CheckInModel> fromDocument(String numberDoc, Pageable page);

    @Query("select u from CheckInModel u where u.customer.document.name=?1 or u.customer.document.surname=?2")
    Page<CheckInModel> fromPersonName(String name, String surname, Pageable page);

    @Query("select u from CheckInModel u where u.totalCost=?1")
    Page<CheckInModel> fromTotal(Double totalCost, Pageable page);

    @Query("select u from CheckInModel u where u.costForNight=?1")
    Page<CheckInModel> fromCostForNight(Double costForNight, Pageable page);

    @Query("select u from CheckInModel u where u.customer.document.number=?1")
    List<CheckInModel> fromDocument(String numberDoc);

    @Query("select u from CheckInModel u where u.customer.id=?1")
    CheckInModel fromCustomer(Integer id);

}
