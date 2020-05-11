/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import reservation.myhotelreservation.dto.BlackList;
import reservation.myhotelreservation.dto.CheckIn;
import reservation.myhotelreservation.dto.CheckOut;
import reservation.myhotelreservation.dto.Document;
import reservation.myhotelreservation.dto.Guarantees;
import reservation.myhotelreservation.dto.Guest;
import reservation.myhotelreservation.dto.Customer;
import reservation.myhotelreservation.dto.Reservation;
import reservation.myhotelreservation.dto.Room;
import reservation.myhotelreservation.model.BlackListModel;
import reservation.myhotelreservation.model.CheckInModel;
import reservation.myhotelreservation.model.CheckOutModel;
import reservation.myhotelreservation.model.DocumentModel;
import reservation.myhotelreservation.model.GuestModel;
import reservation.myhotelreservation.model.CustomerModel;
import reservation.myhotelreservation.model.GuaranteesModel;
import reservation.myhotelreservation.model.ReservationModel;
import reservation.myhotelreservation.model.RoomModel;

/**
 *
 * @author simonecipullo
 */
@Component
public class MarshalUtils {

    public CheckOut map(CheckOutModel ch) {

        CheckOut out = new CheckOut();

        out.setCheckInDate(ConvertDate.toDate(ch.getCheckInDate()));
        out.setCostDay(ch.getCostDay());
        out.setDalyTax(ch.getDalyTax());
        out.setTotal(ch.getTotal());
        out.setCheckOutDate(ConvertDate.toDate(ch.getCheckOutDate()));
        out.setId(ch.getId());

        return out;
    }

    public Guarantees map(GuaranteesModel g) {

        Guarantees d = new Guarantees();

        d.setId(g.getId());
        d.setCreditCard(g.getCreditCard());
        d.setCro(g.getCro());
        d.setDeposit(g.getDeposit());
        if (Objects.nonNull(g.getExpiredCreditCard())) {
            d.setExpiredCreditCard(g.getExpiredCreditCard());
        }
        d.setSecurityCode(g.getSecurityCode());
        if (Objects.nonNull(g.getTotal())) {
            d.setTotal(g.getTotal());
        }

        return d;
    }

    public Guest map(GuestModel g) {

        Guest guest = new Guest();

        guest.setId(g.getId());
        if (Objects.nonNull(g.getDateOfBirth())) {
            guest.setDateOfBirth(ConvertDate.toDate(g.getDateOfBirth()));
        }
        guest.setName(g.getName());
        guest.setNationality(g.getNationality());
        guest.setPlaceOfBirth(g.getPlaceOfBirth());
        guest.setSurname(g.getSurname());

        return guest;
    }

    public Document map(DocumentModel d) {

        Document dto = new Document();
        dto.setId(d.getId());
        if (Objects.nonNull(d.getExpiredDoc())) {
            dto.setExpiredDoc(ConvertDate.toDate(d.getExpiredDoc()));
        }
        dto.setName(d.getName());

        dto.setNationality(d.getNationality());

        dto.setNumber(d.getNumber());

        dto.setPlaceOfBirth(d.getPlaceOfBirth());

        if (Objects.nonNull(d.getRelesed())) {
            dto.setRelesed(ConvertDate.toDate(d.getRelesed()));
        }
        dto.setSurname(d.getSurname());

        dto.setType(d.getType());

        return dto;
    }

    public BlackList map(BlackListModel b) {

        BlackList d = new BlackList();

        if (!b.getCustomer().isEmpty()) {

            b.getCustomer().stream().forEach((p) -> {
                d.getCustomer().add(map(p));
            });
        }

        d.setId(b.getId());

        return d;
    }

    public Customer map(CustomerModel p) {

        Customer d = new Customer();
        d.setId(p.getId());

        if (Objects.nonNull(p.getDocument())) {
            d.setDocument(map(p.getDocument()));
        }

        d.setName(p.getName());
        d.setSurname(p.getSurname());

        d.setNote(p.getNote());

        if (!p.getGuests().isEmpty()) {

            p.getGuests().stream().forEach((gu) -> {
                d.getGuests().add(map(gu));
            });
        }

        if (!p.getRooms().isEmpty()) {

            p.getRooms().stream().forEach((t) -> {
                d.getRooms().add(map(t));
            });

        }

        d.setBlackList(p.getBlackList());

        return d;
    }

    public CheckIn map(CheckInModel ch) {

        CheckIn c = new CheckIn();

        c.setStatusPayment(ch.getStatusPayment());

        c.setId(ch.getId());
        if (Objects.nonNull(ch.getCheckOutDate())) {
            c.setCheckOutDate(ConvertDate.toDate(ch.getCheckOutDate()));
        }
        if (Objects.nonNull(ch.getCheckInDate())) {
            c.setCheckInDate(ConvertDate.toDate(ch.getCheckInDate()));
        }
        c.setCostForNight(ch.getCostForNight());
        c.setDailyTax(ch.getDailyTax());

        c.setTotalCost(ch.getTotalCost());

        if (Objects.nonNull(ch.getCustomer())) {

            c.setCustomer(map(ch.getCustomer()));

        }

        return c;
    }

    public Reservation map(ReservationModel r) {

        Reservation re = new Reservation();
        re.setStatus(r.getStatus());

        if (Objects.nonNull(r.getDateOfArrival())) {
            re.setDateOfArrival(ConvertDate.toDate(r.getDateOfArrival()));
        }
        re.setNote(r.getNote());
        re.setNumberReservation(r.getNumberReservation());
        re.setService(r.getService());
        re.setWebSite(r.getWebSite());
        if (Objects.nonNull(r.getDateArrivalReservation())) {
            re.setDateArrivalReservation(r.getDateArrivalReservation());
        }

        if (Objects.nonNull(r.getCheck())) {
            re.setCheck(map(r.getCheck()));

        }

        if (Objects.nonNull(r.getGuarentees())) {

            re.setGuarantees(map(r.getGuarentees()));
        }

        return re;
    }

    public ReservationModel map(Reservation r) {

        ReservationModel re = new ReservationModel();
        re.setStatus(r.getStatus());

        if (!StringUtils.isEmpty(r.getDateArrivalReservation())) {
            re.setDateArrivalReservation(r.getDateArrivalReservation());
        }
        if (!StringUtils.isEmpty(r.getDateOfArrival())) {
            re.setDateOfArrival(ConvertDate.toString(r.getDateOfArrival()));
        }
        re.setNote(r.getNote());
        re.setNumberReservation(r.getNumberReservation());
        re.setService(r.getService());
        re.setWebSite(r.getWebSite());

        if (Objects.nonNull(r.getCheck())) {

            re.setCheck(map(r.getCheck()));
        }

        if (Objects.nonNull(r.getGuarantees())) {

            re.setGuarentees(map(r.getGuarantees()));
        }

        return re;
    }

    public CheckInModel map(CheckIn ch) {

        CheckInModel c = new CheckInModel();

        c.setStatusPayment(ch.getStatusPayment());
        ch.setId(c.getId());
        if (!StringUtils.isEmpty(ch.getCheckOutDate())) {
            c.setCheckOutDate(ConvertDate.toString(ch.getCheckOutDate()));
        }
        if (!StringUtils.isEmpty(ch.getCheckInDate())) {
            c.setCheckInDate(ConvertDate.toString(ch.getCheckInDate()));
        }
        c.setCostForNight(ch.getCostForNight());
        c.setDailyTax(ch.getDailyTax());

        c.setTotalCost(ch.getTotalCost());

        if (Objects.nonNull(ch.getCustomer())) {

            c.setCustomer(map(ch.getCustomer()));

        }

        return c;
    }

    public CustomerModel map(Customer p) {

        CustomerModel d = new CustomerModel();

        d.setDocument(map(p.getDocument()));
        p.setId(d.getId());
        d.setName(p.getName());
        d.setSurname(p.getSurname());

        d.setNote(p.getNote());
        d.setBlackList(p.getBlackList());

        if (!p.getGuests().isEmpty()) {

            p.getGuests().stream().forEach((gu) -> {
                d.getGuests().add(map(gu));
            });
        }

        if (!p.getRooms().isEmpty()) {

            for (Room r : p.getRooms()) {

                d.getRooms().add(map(r));
            }
        }

        return d;

    }

    public BlackListModel map(BlackList b) {

        BlackListModel d = new BlackListModel();

        if (!b.getCustomer().isEmpty()) {

            b.getCustomer().stream().forEach((p) -> {
                d.getCustomer().add(map(p));
            });
        }

        return d;
    }

    public DocumentModel map(Document d) {

        DocumentModel dc = new DocumentModel();

        if (!StringUtils.isEmpty(d.getExpiredDoc())) {
            dc.setExpiredDoc(ConvertDate.toString(d.getExpiredDoc()));
        }
        dc.setName(d.getName());
        if (!StringUtils.isEmpty(d.getDateOfBirth())) {
            dc.setDateOfBirth(ConvertDate.toString(d.getDateOfBirth()));
        }
        dc.setNationality(d.getNationality());
        dc.setNumber(d.getNumber());
        dc.setPlaceOfBirth(d.getPlaceOfBirth());
        if (!StringUtils.isEmpty(d.getRelesed())) {
            dc.setRelesed(ConvertDate.toString(d.getRelesed()));
        }
        dc.setSurname(d.getSurname());
        dc.setResident(d.getResidence());
        dc.setType(d.getType());

        return dc;
    }

    public GuestModel map(Guest g) {

        GuestModel guest = new GuestModel();

        if (!StringUtils.isEmpty(g.getDateOfBirth())) {
            guest.setDateOfBirth(ConvertDate.toString(g.getDateOfBirth()));
        }
        guest.setName(g.getName());
        guest.setNationality(g.getNationality());
        guest.setPlaceOfBirth(g.getPlaceOfBirth());
        guest.setSurname(g.getSurname());

        return guest;
    }

    public RoomModel map(Room r) {

        RoomModel dto = new RoomModel();

        dto.setFloor(r.getFloor());
        dto.setNote(r.getNote());
        dto.setRoomNumber(r.getRoomNumber());
        dto.setService(r.getService());
        dto.setType(r.getType());

        return dto;
    }

    public Room map(RoomModel r) {

        Room dto = new Room();

        dto.setFloor(r.getFloor());
        dto.setNote(r.getNote());
        dto.setRoomNumber(r.getRoomNumber());
        dto.setService(r.getService());
        dto.setType(r.getType());

        return dto;
    }

    public List<Reservation> mapAll(List<ReservationModel> l) {

        List<Reservation> rlist = new ArrayList<>();

        for (ReservationModel r : l) {

            rlist.add(map(r));

        }

        return rlist;
    }

    public List<ReservationModel> mapAll1(List<Reservation> l) {

        List<ReservationModel> rlist = new ArrayList<>();

        for (Reservation r : l) {

            rlist.add(map(r));

        }

        return rlist;
    }

    public GuaranteesModel map(Guarantees g) {

        GuaranteesModel d = new GuaranteesModel();

        d.setCreditCard(g.getCreditCard());
        d.setCro(g.getCro());
        d.setDeposit(g.getDeposit());
        if (!StringUtils.isEmpty(g.getExpiredCreditCard())) {
            d.setExpiredCreditCard(g.getExpiredCreditCard());
        }
        d.setSecurityCode(g.getSecurityCode());
        d.setTotal(g.getTotal());

        return d;
    }

}
