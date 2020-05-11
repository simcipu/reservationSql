/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.services.impl;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import reservation.myhotelreservation.ApplicationTest;
import reservation.myhotelreservation.business.service.CheckInService;
import reservation.myhotelreservation.business.service.ReservationService;
import reservation.myhotelreservation.model.CheckInModel;
import reservation.myhotelreservation.model.DocumentModel;
import reservation.myhotelreservation.model.GuestModel;
import reservation.myhotelreservation.model.CustomerModel;
import reservation.myhotelreservation.model.GuaranteesModel;
import reservation.myhotelreservation.model.ReservationModel;
import reservation.myhotelreservation.model.RoomModel;
import reservation.myhotelreservation.repository.CheckInRepository;
import reservation.myhotelreservation.repository.ReservationRepository;
import reservation.myhotelreservation.repository.RoomRepository;
import reservation.myhotelreservation.utils.ConvertDate;
import reservation.myhotelreservation.utils.MarshalUtils;

/**
 *
 * @author simonecipullo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
@Transactional
public class CheckInServiceImplTest {

    @Autowired
    public ReservationService service;

    @Autowired
    public CheckInService chService;

    @Autowired
    public CheckInRepository chrepo;

    public CheckInModel ch1;

    public CustomerModel p1;

    public DocumentModel doc1;

    public ReservationModel r1;

    public RoomModel room;

    public RoomModel room1;

    public GuestModel gu1;

    public GuaranteesModel g1;

    @Autowired
    public MarshalUtils mapper;

    @Autowired
    public ReservationRepository repo;

    @Autowired
    public RoomRepository roomRepo;

    @Before
    public void setUp() {

        g1 = new GuaranteesModel();
        gu1 = new GuestModel();
        room = new RoomModel();
        room1 = new RoomModel();
        r1 = new ReservationModel();
        ch1 = new CheckInModel();
        p1 = new CustomerModel();
        doc1 = new DocumentModel();

        gu1.setDateOfBirth(LocalDateTime.of(1980, Month.JANUARY, 07, 0, 0));

        gu1.setName("sim");

        gu1.setSurname("cip");

        gu1.setNationality("italt");
        gu1.setPlaceOfBirth("comune");
        r1.setDateOfArrival(LocalDateTime.of(2017, Month.MARCH, 06, 0, 0));

        room1.setFloor(1);
        room1.setRoomNumber("100");
        room1.setNote("ciao");
        room1.setService("service");
        room1.setType("single");
        room1 = roomRepo.saveAndFlush(room1);

        room.setFloor(2);
        room.setNote("tv");
        room.setRoomNumber("101");
        room.setService("bed");
        room.setType("double room");
        room = roomRepo.saveAndFlush(room);

        r1.setNumberReservation("aaaaa1111");

        doc1.setExpiredDoc(LocalDateTime.of(2020, Month.MARCH, 20, 0, 0));
        doc1.setName("simone");
        doc1.setNationality("ita");
        doc1.setNumber("ao12330so");
        doc1.setPlaceOfBirth("Roma");
        doc1.setRelesed(LocalDateTime.of(1980, Month.MARCH, 20, 0, 0));
        doc1.setSurname("cipullo");
        doc1.setType("CI");

        p1.setDocument(doc1);
        p1.setNote("ottimo cliente");
        p1.getRooms().add(room);
        p1.getRooms().add(room1);
        p1.getGuests().add(gu1);

        ch1.setCheckOutDate(LocalDateTime.of(2017, Month.JANUARY, 22, 0, 0));
        ch1.setCostForNight(60.50);
        ch1.setDailyTax(3.50);
        ch1.setTotalCost(70.00);

        g1.setCreditCard("111222233");
        g1.setCro("dsd");
        g1.setDeposit(33.4);
        g1.setExpiredCreditCard("22-05");
        g1.setSecurityCode(222);
        g1.setTotal(333.5);

        ch1.setCustomer(p1);

        r1.setWebSite("booking");
        r1.setCheck(ch1);
        r1.setGuarentees(g1);
        repo.save(r1);

    }

    @Test
    public void findByPropertiesTestAndSave() {

        String date = "2015-08-04T00:00";

        LocalDateTime t = ConvertDate.toString(date);

        String r = ConvertDate.toDate(t);
        
        Pageable p=new PageRequest(0, 50);
        
        Page<CheckInModel> l=chrepo.fromCostForNight(60.50, p);
        
        Page<CheckInModel> l1=chrepo.fromDocument("ao12330so", p);

    }

}
