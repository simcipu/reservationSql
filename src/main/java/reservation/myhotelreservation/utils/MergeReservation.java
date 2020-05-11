/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.utils;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import reservation.myhotelreservation.dto.Guest;
import reservation.myhotelreservation.dto.Reservation;
import reservation.myhotelreservation.dto.Room;
import reservation.myhotelreservation.model.CustomerModel;
import reservation.myhotelreservation.model.GuestModel;
import reservation.myhotelreservation.model.ReservationModel;
import reservation.myhotelreservation.model.RoomModel;
import reservation.myhotelreservation.repository.CustomerRepository;
import reservation.myhotelreservation.repository.GuestRepository;
import reservation.myhotelreservation.repository.RoomRepository;

/**
 *
 * @author simonecipullo
 */
@Component
public class MergeReservation {

    @Autowired
    private MarshalUtils mapper;

    @Autowired
    private GuestRepository guRepository;

    @Autowired
    private RoomRepository rRepository;

    @Autowired
    private CustomerRepository cuRepository;

    public ReservationModel merge(ReservationModel model, Reservation dto) {

        model.setDateOfArrival(ConvertDate.toString(dto.getDateOfArrival()));
        model.setNote(dto.getNote());
        model.setNumberReservation(dto.getNumberReservation());
        model.setService(dto.getService());
        model.setWebSite(dto.getWebSite());
        if (Objects.nonNull(model.getCheck())) {
            if (Objects.nonNull(dto.getCheck())) {
                model.getCheck().setCostForNight(dto.getCheck().getCostForNight());
                model.getCheck().setDailyTax(dto.getCheck().getDailyTax());
                model.getCheck().setTotalCost(dto.getCheck().getTotalCost());
                if (!StringUtils.isEmpty(dto.getCheck().getCheckInDate())) {
                    model.getCheck().setCheckInDate(ConvertDate.toString(dto.getCheck().getCheckInDate()));
                }
                if (!StringUtils.isEmpty(dto.getCheck().getCheckOutDate())) {
                    model.getCheck().setCheckOutDate(ConvertDate.toString(dto.getCheck().getCheckOutDate()));
                }

                if (Objects.nonNull(model.getCheck().getCustomer())
                        && (Objects.nonNull(dto.getCheck().getCustomer()))) {

                    model.getCheck().getCustomer().setBlackList(dto.getCheck().getCustomer().getBlackList());
                    model.getCheck().getCustomer().setName(dto.getCheck().getCustomer().getName());
                    model.getCheck().getCustomer().setNote(dto.getCheck().getCustomer().getNote());
                    model.getCheck().getCustomer().setSurname(dto.getCheck().getCustomer().getSurname());

                    if (!model.getCheck().getCustomer().getGuests().isEmpty()
                            && !dto.getCheck().getCustomer().getGuests().isEmpty()) {

                        model.getCheck().getCustomer().getGuests().addAll(
                                mergeGuest(model.getCheck().getCustomer(), dto.getCheck().getCustomer().getGuests()));

                    }

                    if (!model.getCheck().getCustomer().getRooms().isEmpty()
                            && !dto.getCheck().getCustomer().getRooms().isEmpty()) {
                        model.getCheck().getCustomer().getRooms().addAll(
                                mergeRooms(model.getCheck().getCustomer(), dto.getCheck().getCustomer().getRooms()));

                    }

                    if (Objects.nonNull(model.getCheck().getCustomer().getDocument())
                            && Objects.nonNull(dto.getCheck().getCustomer().getDocument())) {
                        if (!StringUtils.isEmpty(dto.getCheck().getCustomer().getDocument().getDateOfBirth())) {
                            model.getCheck().getCustomer().getDocument().setDateOfBirth(ConvertDate.toString(dto.getCheck().getCustomer().getDocument().getDateOfBirth()));
                        }

                        if (!StringUtils.isEmpty(dto.getCheck().getCustomer().getDocument().getExpiredDoc())) {

                            model.getCheck().getCustomer().getDocument().setExpiredDoc(ConvertDate.toString(dto.getCheck().getCustomer().getDocument().getExpiredDoc()));
                        }

                        model.getCheck().getCustomer().getDocument().setName(dto.getCheck().getCustomer().getDocument().getName());
                        model.getCheck().getCustomer().getDocument().setNationality(dto.getCheck().getCustomer().getDocument().getNationality());
                        model.getCheck().getCustomer().getDocument().setResident(dto.getCheck().getCustomer().getDocument().getResidence());
                        model.getCheck().getCustomer().getDocument().setSurname(dto.getCheck().getCustomer().getDocument().getSurname());
                        model.getCheck().getCustomer().getDocument().setType(dto.getCheck().getCustomer().getDocument().getType());
                        model.getCheck().getCustomer().getDocument().setPlaceOfBirth(dto.getCheck().getCustomer().getDocument().getPlaceOfBirth());

                        if (!StringUtils.isEmpty(dto.getCheck().getCustomer().getDocument().getRelesed())) {

                            model.getCheck().getCustomer().getDocument().setRelesed(ConvertDate.toString(dto.getCheck().getCustomer().getDocument().getRelesed()));
                        }

                    }

                }

                if (Objects.isNull(model.getCheck().getCustomer())
                        && (Objects.nonNull(dto.getCheck().getCustomer()))) {

                    model.getCheck().setCustomer(mapper.map(dto.getCheck().getCustomer()));
                    model.getCheck().getCustomer().getRooms().clear();

                    dto.getCheck().getCustomer().getRooms().stream().forEach((r) -> {
                        model.getCheck().getCustomer().getRooms().add(rRepository.findByRoomNumber(r.getRoomNumber()));
                    });

                }

            }

        } else if (Objects.isNull(model.getCheck()) && Objects.nonNull(dto.getCheck())) {

            model.setCheck(mapper.map(dto.getCheck()));

        }
        if (Objects.nonNull(model.getGuarentees())
                && Objects.nonNull(dto.getGuarantees())) {

            model.getGuarentees().setCreditCard(dto.getGuarantees().getCreditCard());
            model.getGuarentees().setCro(dto.getGuarantees().getCro());
            model.getGuarentees().setDeposit(dto.getGuarantees().getDeposit());
            model.getGuarentees().setSecurityCode(dto.getGuarantees().getSecurityCode());
            model.getGuarentees().setExpiredCreditCard(dto.getGuarantees().getExpiredCreditCard());

        }

        return model;

    }

    private Set<GuestModel> mergeGuest(CustomerModel l, Set<Guest> dto) {

        Set<GuestModel> gu = l.getGuests();
        l.getGuests().clear();
        cuRepository.save(l);

        if (!gu.isEmpty()) {

            l.getGuests().stream().forEach((g) -> {
                guRepository.delete(g.getId());
            });

        }

        Set<GuestModel> gu1 = new HashSet<>();

        dto.stream().forEach((h) -> {
            gu1.add(mapper.map(h));
        });

        return gu1;
    }

    private Set<RoomModel> mergeRooms(CustomerModel l, Set<Room> dto) {

        l.getRooms().clear();
        cuRepository.save(l);
        Set<RoomModel> gu1 = new HashSet<>();

        for (Room r : dto) {

            RoomModel ro = rRepository.findByRoomNumber(r.getRoomNumber());

            if (Objects.nonNull(ro)) {

                gu1.add(ro);

            }

        }

        return gu1;
    }

}
