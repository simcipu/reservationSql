/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservation.myhotelreservation.Constants;
import reservation.myhotelreservation.business.exception.ServiceRestException;
import reservation.myhotelreservation.business.service.ReservationService;
import reservation.myhotelreservation.dto.Reservation;
import reservation.myhotelreservation.dto.Room;
import reservation.myhotelreservation.model.ReservationModel;
import reservation.myhotelreservation.model.RoomModel;
import reservation.myhotelreservation.repository.ReservationRepository;
import reservation.myhotelreservation.repository.RoomRepository;
import reservation.myhotelreservation.utils.ConstantControll;
import reservation.myhotelreservation.utils.ConvertDate;
import reservation.myhotelreservation.utils.MarshalUtils;
import reservation.myhotelreservation.utils.MergeReservation;
import reservation.myhotelreservation.utils.PageRequestReservation;
import reservation.myhotelreservation.utils.ValidatePage;

/**
 *
 * @author simonecipullo
 */
@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private MarshalUtils mapper;

    @Autowired
    private ReservationRepository repository;

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private MergeReservation merge;

    //ok
    @Override
    public Reservation save(Reservation dto) {

        ReservationModel reserv = repository.findByNumberReservation(dto.getNumberReservation());

        if (Objects.nonNull(reserv)) {

            throw new ServiceRestException("number reservation already exits!!!");
        }

        Boolean result = ConstantControll.validateReservationStatus(dto.getStatus());

        if (result == false) {

            throw new ServiceRestException("bad reservation status,you can insert : IN,OUT,CONFIRMED,DELETED");
        }

        RoomModel room = null;

        ReservationModel re = mapper.map(dto);
        if (Objects.nonNull(dto.getCheck())) {
            Boolean flag = ConstantControll.validateChechInStatus(dto.getCheck().getStatusPayment());

            if (flag == false) {

                throw new ServiceRestException("bad checkIn status,you can insert : PAID,TO_PAY,GUARANTEED");
            }

            if (Objects.nonNull(re.getCheck().getCustomer())) {
                re.getCheck().getCustomer().getRooms().clear();
                if (!dto.getCheck().getCustomer().getRooms().isEmpty()) {

                    for (Room r : dto.getCheck().getCustomer().getRooms()) {

                        room = roomRepo.findByRoomNumber(r.getRoomNumber());

                        if (Objects.isNull(room)) {

                            throw new ServiceRestException("room don't exits!!!");

                        }

                        re.getCheck().getCustomer().getRooms().add(room);

                    }

                }
            }
        }

        Reservation request = mapper.map(repository.saveAndFlush(re));

        return request;
    }

    //ok
    @Override
    public Boolean update(Reservation dto) {

        Boolean result = false;
        ReservationModel re = repository.findByNumberReservation(dto.getNumberReservation());
        if (Objects.isNull(re)) {

            throw new ServiceRestException("reservation don't exits!!!!");
        }

        Boolean flag = ConstantControll.validateReservationStatus(dto.getStatus());

        if (flag == false) {

            throw new ServiceRestException("bad reservation status,you can insert : IN,OUT,CONFIRMED,DELETED");
        }

        if (Objects.nonNull(dto.getCheck())) {
            Boolean flag1 = ConstantControll.validateChechInStatus(dto.getCheck().getStatusPayment());

            if (flag1 == false) {

                throw new ServiceRestException("bad checkIn status,you can insert : PAID,TO_PAY,GUARANTEED");
            }
        }

        repository.saveAndFlush(merge.merge(re, dto));

        ReservationModel re2 = repository.findByNumberReservation(dto.getNumberReservation());

        if (Objects.nonNull(re2)) {

            result = true;
        }

        return result;

    }

    //ok
    @Override
    public Boolean delete(String numberReservation) {

        ReservationModel re = repository.findByNumberReservation(numberReservation);

        Boolean result = false;
        if (Objects.isNull(re)) {

            throw new ServiceRestException("reservation don't exits!!!!");
        }

        re.getCheck().setCustomer(null);

        repository.saveAndFlush(re);

        repository.delete(re);

        ReservationModel re1 = repository.findByNumberReservation(numberReservation);

        if (Objects.isNull(re1)) {

            result = true;
        }

        return result;
    }

    //ok
    @Override
    public Reservation findById(String numberReservation) {

        ReservationModel m = repository.findByNumberReservation(numberReservation);

        if (Objects.isNull(m)) {

            throw new ServiceRestException("reservation don't exits!!!");
        }

        Reservation r = mapper.map(m);

        return r;

    }

    //ok
    @Override
    public PageRequestReservation findByDate(String date, Integer page, Integer size) {

        Pageable p = ValidatePage.validatePg(page, size);

        List<Reservation> l = new ArrayList<>();
        LocalDateTime lo = ConvertDate.toString(date);

        Page<ReservationModel> re = repository.fromDate(lo, p);

        if (Objects.isNull(re) || re.getContent().isEmpty()) {

            throw new ServiceRestException("There are no reservations !!!");
        }

        PageRequestReservation request = new PageRequestReservation();

        request.setPage(p.getPageNumber() + 1);

        request.setNumber(p.getPageSize());

        request.setTotalRecord(re.getNumberOfElements());

        re.getContent().stream().forEach((le) -> {
            l.add(mapper.map(le));
        });

        request.getList().addAll(l);

        return request;
    }

    //ok
    @Override
    public PageRequestReservation fromByDate(String date, String from, Integer page, Integer size) {

        Pageable p = ValidatePage.validatePg(page, size);

        List<Reservation> l = new ArrayList<>();
        LocalDateTime lo = null;
        LocalDateTime at = null;

        lo = ConvertDate.toString(date);
        at = ConvertDate.toString(from);

        if (Objects.isNull(lo)) {

            throw new ServiceRestException("date from is empty !!!");
        }

        if (Objects.isNull(at)) {

            throw new ServiceRestException("date at is empty !!!");
        }

        Page<ReservationModel> re = repository.fromDateAt(lo, at, p);

        if (Objects.isNull(re)) {

            throw new ServiceRestException("There are no reservations !!!");
        }

        PageRequestReservation request = new PageRequestReservation();

        request.setPage(p.getPageNumber() + 1);
        request.setNumber(p.getPageSize());

        request.setTotalRecord(re.getNumberOfElements());

        re.getContent().stream().forEach((le) -> {
            l.add(mapper.map(le));
        });

        request.getList().addAll(l);

        return request;
    }

    //ok
    @Override
    public PageRequestReservation fromCustomer(String name, String surname, String number, Integer page, Integer size) {

        Pageable p = ValidatePage.validatePg(page, size);

        List<Reservation> l = new ArrayList<>();

        Page<ReservationModel> re = repository.fromPersonName(name, surname, number, p);

        if (Objects.isNull(re) || re.getContent().isEmpty()) {

            throw new ServiceRestException("There are no reservations !!!");
        }

        PageRequestReservation request = new PageRequestReservation();

        request.setPage(p.getPageNumber() + 1);

        request.setNumber(p.getPageSize());

        re.getContent().stream().forEach((le) -> {
            l.add(mapper.map(le));
        });
        request.setPage(p.getPageNumber() + 1);
        request.setTotalRecord(re.getNumberOfElements());
        request.setNumber(p.getPageSize());
        request.getList().addAll(l);

        return request;
    }

    //ok
    @Override
    public PageRequestReservation findAll(Integer page, Integer size) {

        Pageable p = ValidatePage.validatePg(page, size);

        List<Reservation> l = new ArrayList<>();

        Page<ReservationModel> re = repository.findAll(p);

        if (Objects.isNull(re) || re.getContent().isEmpty()) {

            throw new ServiceRestException("There are no reservations !!!");
        }

        PageRequestReservation request = new PageRequestReservation();

        request.setPage(p.getPageNumber() + 1);
        request.setNumber(p.getPageSize());

        re.getContent().stream().forEach((le) -> {
            l.add(mapper.map(le));
        });
        request.setTotalRecord(re.getNumberOfElements());
        request.getList().addAll(l);

        return request;

    }

    @Override
    public Boolean changeStatus(String number, String status) {

        boolean result = false;

        ReservationModel re = repository.findByNumberReservation(number);

        if (Objects.nonNull(re)) {

            re.setStatus(status);
            repository.saveAndFlush(re);
            result = true;
        }

        return result;
    }

    @Override
    public List<ReservationModel> findByStatusIn() {

        List<ReservationModel> list = repository.findByStatus(Constants.IN);

        if (list.isEmpty()) {

            list = new ArrayList<>();
        }

        return list;

    }

}
