/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.utils;

import com.google.gson.Gson;
import reservation.myhotelreservation.dto.CheckIn;
import reservation.myhotelreservation.dto.Customer;
import reservation.myhotelreservation.dto.Document;
import reservation.myhotelreservation.dto.Guarantees;
import reservation.myhotelreservation.dto.Guest;
import reservation.myhotelreservation.dto.Reservation;
import reservation.myhotelreservation.dto.Room;
import reservation.myhotelreservation.request.ObjectsRequest;

/**
 *
 * @author simonecipullo
 */
public class JsonSchema {

     /*public static void main(String[] args) throws Exception {

        CheckIn ch;

        Customer p;

        Document doc;

        Reservation r;

        Room room;

        Room room1;

        Guest gu;

        Guarantees g3;

        gu = new Guest();
        room = new Room();
        room1 = new Room();
        r = new Reservation();
        ch = new CheckIn();
        p = new Customer();
        doc = new Document();
        g3 = new Guarantees();

        g3.setCreditCard("kdslakaslòkasdlòklòasd");
        g3.setCro("dllsd");
        g3.setDeposit(222.3);
        g3.setExpiredCreditCard("2015-09-02T00:00");
        g3.setSecurityCode(222);
        g3.setTotal(22222.3);

        gu.setDateOfBirth("2015-09-02T00:00");

        gu.setName("sim");

        gu.setSurname("cip");

        gu.setNationality("italt");
        gu.setPlaceOfBirth("comune");
        r.setDateOfArrival("2015-09-02T00:00");

        room1.setFloor(1);
        room1.setRoomNumber("100");
        room1.setNote("ciao");
        room1.setService("service");
        room1.setType("single");

        room.setFloor(1);
        room.setNote("tv");
        room.setRoomNumber("101");
        room.setService("bed");
        room.setType("single");

        r.setNumberReservation("1");

        doc.setExpiredDoc("2015-09-02T00:00");
        doc.setName("simone");
        doc.setNationality("ita");
        doc.setNumber("ao12330so");
        doc.setPlaceOfBirth("Roma");
        doc.setRelesed("2015-09-02T00:00");
        doc.setSurname("cipullo");
        doc.setType("CI");

        p.setDocument(doc);
        p.setNote("ottimo cliente");
        p.setBlackList(true);
        p.getRooms().add(room);
        p.getRooms().add(room1);
        p.setName("mario");
        p.setSurname("surname");

        p.getGuests().add(gu);

        ch.setCheckOutDate("2015-11-02T00:00");
        ch.setCheckInDate("2015-09-02T00:00");
        ch.setCostForNight(60.50);
        ch.setDailyTax(3.50);
        ch.setTotalCost(70.00);
        //ch.setCustomer(p);

        r.setWebSite("booking");
        r.setCheck(ch);
        r.setGuarantees(g3);

        Gson g = new Gson();

        String r1 = g.toJson(r, Reservation.class);
       System.out.print(r1);
       
     /*  String r5=g.toJson(p,Customer.class);
        System.out.print(r5);
       
       ObjectsRequest req=new ObjectsRequest();
       req.setAt("2016-09-02T00:00");
       req.setCheckInDate("2015-09-02T00:00");
       req.setCheckOutDate("2015-09-02T00:00");
       req.setCostForNight(60.50);
       req.setName("simone");
       req.setSurname("verdi");
       req.setTotalCost(70.00);
       req.setNumberDoc("04300234");
       req.setNumber(50);
       req.setDate("2016-09-02T00:00");
       req.setPage(1);
      
       
       
  
        Gson g1 = new Gson();
       String obj=g1.toJson(req,ObjectsRequest.class);
        System.out.print(obj);
 
        
        String r3 = g1.toJson(room, Room.class);
        String r20 = g1.toJson(room1, Room.class);
        System.out.print(r3);
        System.out.print(r20);*/

    //}

 
}
