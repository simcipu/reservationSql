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
import reservation.myhotelreservation.model.CustomerModel;
import reservation.myhotelreservation.model.ReservationModel;

/**
 *
 * @author simonecipullo
 */
public interface ReservationRepository extends Repository<ReservationModel, Long> {

    @Query("select u from ReservationModel u where u.dateOfArrival=?1")
    Page<ReservationModel> fromDate(LocalDateTime dateOfArrival, Pageable page);

    @Query("select u from ReservationModel u where  (u.dateOfArrival between ?1 and ?2)")
    Page<ReservationModel> fromDateAt(LocalDateTime dateOfArrival, LocalDateTime at, Pageable page);

    @Query("select u from ReservationModel u where u.check.customer.document.name=?1 or u.check.customer.document.surname=?2 or u.check.customer.document.number=?3")
    Page<ReservationModel> fromPersonName(String name, String surname, String numberDoc, Pageable page);

    ReservationModel findByNumberReservation(String number);

    @Query("select u from ReservationModel u where u.check.id=?1")
    ReservationModel findByCheckId(Long id);

    @Query("select u from ReservationModel u where u.check.customer.document.number=?1")
    List<CustomerModel> findByDoc(String doc);

    @Query("select u from ReservationModel u where u.check.customer.document.number=?1")
    List<ReservationModel> findReByDoc(String doc);

    @Query("select u from ReservationModel u where u.check.customer.id=?1")
    ReservationModel fromCustomer(Integer id);

    @Query("select u from ReservationModel u where u.status=?1")
    List<ReservationModel> findByStatus(String status);

    

}
