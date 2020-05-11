/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.service;

import java.util.List;
import reservation.myhotelreservation.dto.Reservation;
import reservation.myhotelreservation.model.ReservationModel;
import reservation.myhotelreservation.utils.PageRequestReservation;

/**
 *
 * @author simonecipullo
 */
public interface ReservationService {

    Reservation save(Reservation dto);

    Boolean update(Reservation dto);

    Boolean delete(String number);

    Reservation findById(String number);

    PageRequestReservation findByDate(String date, Integer page, Integer size);

    PageRequestReservation fromByDate(String date, String from, Integer page, Integer size);

    PageRequestReservation fromCustomer(String name, String surname, String number, Integer page, Integer size);

    PageRequestReservation findAll(Integer page, Integer size);

    Boolean changeStatus(String number, String status);
    
    List<ReservationModel> findByStatusIn();
}
