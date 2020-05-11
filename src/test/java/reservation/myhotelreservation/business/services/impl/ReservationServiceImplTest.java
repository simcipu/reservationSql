/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.services.impl;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.AssertTrue;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
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
import reservation.myhotelreservation.business.service.ReservationService;
import reservation.myhotelreservation.dto.Reservation;
import reservation.myhotelreservation.model.CheckInModel;
import reservation.myhotelreservation.model.DocumentModel;
import reservation.myhotelreservation.model.GuestModel;
import reservation.myhotelreservation.model.CustomerModel;
import reservation.myhotelreservation.model.ReservationModel;
import reservation.myhotelreservation.model.RoomModel;
import reservation.myhotelreservation.repository.ReservationRepository;
import reservation.myhotelreservation.repository.RoomRepository;
import reservation.myhotelreservation.utils.MarshalUtils;
import reservation.myhotelreservation.model.BlackListModel;
import reservation.myhotelreservation.model.GuaranteesModel;
import reservation.myhotelreservation.repository.BlackListRepository;
import reservation.myhotelreservation.repository.CustomerRepository;
import reservation.myhotelreservation.specification.InSpecification;
import reservation.myhotelreservation.utils.ConvertDate;
import reservation.myhotelreservation.utils.PageRequestReservation;

/**
 *
 * @author simonecipullo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationTest.class)
@Transactional
public class ReservationServiceImplTest {

    @Autowired
    public ReservationService service;

    @Autowired
    public ReservationRepository re;

    @Autowired
    public BlackListRepository repository;

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
    public ReservationService reservice;

    @Autowired
    public MarshalUtils mapper;

    @Autowired
    public ReservationRepository repo;

    @Autowired
    public RoomRepository roomRepo;

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

        gu.setDateOfBirth(LocalDateTime.of(1980, Month.JANUARY, 07, 0, 0));

        gu.setName("sim");

        gu.setSurname("cip");

        gu.setNationality("italt");
        gu.setPlaceOfBirth("comune");
        r.setDateOfArrival(LocalDateTime.of(2017, Month.MARCH, 06, 0, 0));

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

        ch.setCheckOutDate(LocalDateTime.of(2017, Month.JANUARY, 22, 0, 0));
        ch.setCostForNight(60.50);
        ch.setDailyTax(3.50);
        ch.setTotalCost(70.00);

        ch.setCustomer(p);

        r.setWebSite("booking");
        r.setCheck(ch);
        r.setGuarentees(m);
        repo.saveAndFlush(r);

    }

    @Test
    public void findByPropertiesTestAndSave() {

        CheckInModel ch1 = null;

        CustomerModel p1;

        DocumentModel doc1;

        ReservationModel r1;

        GuestModel gu1;

        GuaranteesModel g1;

        g1 = new GuaranteesModel();
        gu1 = new GuestModel();
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

        r1.setNumberReservation("aaaaa1112");

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
        p1.getGuests().add(gu1);
        p1.getRooms().add(room);
        p1.getRooms().add(room1);

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

        repo.saveAndFlush(r1);

        List<CustomerModel> list = crepo.findAll(new InSpecification<>("blackList", true));

        List<BlackListModel> l = repository.findAll();

        List<ReservationModel> l1 = repo.findAll();

        Pageable request = new PageRequest(0, 50);
        Page<ReservationModel> rs = repo.fromDateAt(LocalDateTime.of(2017, Month.MARCH, 06, 0, 0), LocalDateTime.of(2017, Month.DECEMBER, 4, 0, 0), request);

        if (rs.getContent().size() != 2) {
            fail();

        }
        PageRequestReservation rs6 = reservice.fromByDate("2017-03-06T00:00", "2018-12-04T00:00", 0, 50);

        if (rs6.list.size() != 2) {
            fail();

        }

    }

    @Test
    public void UpDate() {

        RoomModel rml = roomRepo.findByRoomNumber("100");

        CheckInModel ch1;

        CustomerModel p1;

        DocumentModel doc1;

        ReservationModel r1;

        GuestModel gu1;

        GuaranteesModel g1;

        g1 = new GuaranteesModel();
        gu1 = new GuestModel();
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

        r1.setNumberReservation("aaaaa1161");

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
        p1.getGuests().add(gu1);
        p1.getRooms().add(room);

        ch1.setCheckOutDate(LocalDateTime.of(2017, Month.JANUARY, 22, 0, 0));
        ch1.setCostForNight(60.50);
        ch1.setDailyTax(3.50);
        ch1.setTotalCost(70.00);

        g1.setCreditCard("111222233");
        g1.setCro("dsd");
        g1.setDeposit(33.4);
        g1.setExpiredCreditCard("22-07");
        g1.setSecurityCode(222);
        g1.setTotal(333.5);

        ch1.setCustomer(p1);

        r1.setWebSite("booking");
        r1.setCheck(ch1);
        r1.setGuarentees(g1);

        repo.saveAndFlush(r1);

    }

    @Test
    public void mapperTest() {

        Reservation dto = mapper.map(r);

        ReservationModel m1 = mapper.map(dto);

    }

    @Test
    public void forTest() {

        List<GuestModel> l = new ArrayList<>();
        List<GuestModel> l2 = new ArrayList<>();
        GuestModel gu1 = new GuestModel();
        gu1.setName("ciccio");
        gu1.setSurname("pippo");

        GuestModel gu2 = new GuestModel();
        gu2.setName("no");
        gu2.setSurname("si");

        GuestModel gu3 = new GuestModel();
        gu3.setName("no");
        gu3.setSurname("si");

        l.add(gu1);
        l.add(gu2);
        l.add(gu);
        l.add(gu3);

        Set<GuestModel> s = new HashSet<>();

        for (GuestModel h : l) {

            s.add(h);

        }

    }

    @Test
    public void testDate() {

        LocalDateTime ch = ConvertDate.toString("2020-03-06T00:00");
        LocalDateTime a = LocalDateTime.of(ch.getYear(), ch.getMonth(), ch.getDayOfMonth(), 0, 0, 0);
        LocalDateTime b = LocalDateTime.now();

        Boolean result = a.isAfter(b);

        assertTrue(result);
    }

}
