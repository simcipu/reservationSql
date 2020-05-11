/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.services.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservation.myhotelreservation.business.service.CheckOutService;
import reservation.myhotelreservation.dto.CheckOut;
import reservation.myhotelreservation.model.ReservationModel;
import reservation.myhotelreservation.repository.CheckOutRepository;
import reservation.myhotelreservation.repository.ReservationRepository;
import reservation.myhotelreservation.utils.MarshalUtils;

/**
 *
 * @author simonecipullo
 */
@Service
@Transactional
public class CheckOutServiceImpl implements CheckOutService {

    @Autowired
    private CheckOutRepository repo;

    @Autowired
    private ReservationRepository reseRepo;

    @Autowired
    private MarshalUtils mapper;

    @Override
    public CheckOut save(String numberReservation) {

        LocalDateTime now = LocalDateTime.now();
        ReservationModel reservation = reseRepo.findByNumberReservation(numberReservation);

        if (Objects.nonNull(reservation)) {

            if (Objects.nonNull(reservation.getCheck())) {
                LocalDateTime time = LocalDateTime.of(reservation.getCheck().getCheckOutDate().getYear(),
                        reservation.getCheck().getCheckOutDate().getMonth(),
                        reservation.getCheck().getCheckOutDate().getDayOfMonth(), 0, 0);

            }

        }

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(String numberReservation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
