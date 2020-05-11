/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.services.impl;

import com.google.gson.Gson;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import reservation.myhotelreservation.ApplicationTest;
import reservation.myhotelreservation.business.service.ReservationService;
import reservation.myhotelreservation.dto.Reservation;
import reservation.myhotelreservation.model.CheckInModel;
import reservation.myhotelreservation.model.CustomerModel;
import reservation.myhotelreservation.model.DocumentModel;
import reservation.myhotelreservation.model.GuaranteesModel;
import reservation.myhotelreservation.model.GuestModel;
import reservation.myhotelreservation.model.ReservationModel;
import reservation.myhotelreservation.model.RoomModel;
import reservation.myhotelreservation.repository.CustomerRepository;
import reservation.myhotelreservation.utils.MarshalUtils;

/**
 *
 * @author Utente
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
@Transactional
public class JsonTest {
    
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(JsonTest.class);


    @Autowired
    public CustomerRepository crepo;

    public CheckInModel ch;

    public CustomerModel p;

    public DocumentModel doc;

    public ReservationModel r;

    public RoomModel room;

    public RoomModel room1;

    public GuestModel gu;

    public GuaranteesModel m;


    @Autowired
    public MarshalUtils mapper;



    @Before
    public void setUp() {

        m = new GuaranteesModel();
        gu = new GuestModel();
        room = new RoomModel();
        room1 = new RoomModel();
        r = new ReservationModel();
        ch = new CheckInModel();
        p = new CustomerModel();
        doc = new DocumentModel();

        m.setCreditCard("klsdakdlaksl");
        room1.setFloor(1);
        room1.setRoomNumber("002");
        room1.setNote("ciao");
        room1.setService("service");
        room1.setType("single");
     

        room.setFloor(2);
        room.setNote("tv");
        room.setRoomNumber("001");
        room.setService("bed");
        room.setType("double room");
     

        gu.setDateOfBirth(LocalDateTime.of(1980, Month.JANUARY, 07, 0, 0));

        gu.setName("sim");

        gu.setSurname("cip");

        gu.setNationality("italt");
        gu.setPlaceOfBirth("comune");
        r.setDateOfArrival(LocalDateTime.of(2020, Month.MARCH, 06, 0, 0));

        r.setNumberReservation("aaaaa1111");

        doc.setExpiredDoc(LocalDateTime.of(2020, Month.MARCH, 20, 0, 0));
        doc.setName("simone");
        doc.setNationality("ita");
        doc.setNumber("ao12330so");
        doc.setPlaceOfBirth("Roma");
        doc.setRelesed(LocalDateTime.of(1980, Month.MARCH, 20, 0, 0));
        doc.setSurname("cipullo");
        doc.setType("CI");

        p.setDocument(doc);
        p.setNote("ottimo cliente");
        p.getRooms().add(room);
        p.getRooms().add(room1);
        p.getGuests().add(gu);
        p.setBlackList(true);

        ch.setCheckOutDate(LocalDateTime.of(2020, Month.JANUARY, 22, 0, 0));
        ch.setCostForNight(60.50);
        ch.setDailyTax(3.50);
        ch.setTotalCost(70.00);

        ch.setCustomer(p);

        r.setWebSite("booking");
        r.setCheck(ch);
        r.setGuarentees(m);
        

    }
    
    @Test
    public void jsonTest() {

         Gson gson = new Gson();
         Reservation re = mapper.map(r);
         String res=gson.toJson(re, Reservation.class);
         
         logger.info("OGGETTO::PER TEST REST");
         logger.info("OGGETTO::::");
         logger.info("OGGETTO JSON:: "+res);
         logger.info("OGGETTO::::");
    }

   

    

   

    
}
