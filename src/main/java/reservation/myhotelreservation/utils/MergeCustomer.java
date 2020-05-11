/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reservation.myhotelreservation.dto.Customer;
import reservation.myhotelreservation.dto.Room;
import reservation.myhotelreservation.model.CustomerModel;
import reservation.myhotelreservation.model.RoomModel;
import reservation.myhotelreservation.repository.RoomRepository;

/**
 *
 * @author simonecipullo
 */
@Component
public class MergeCustomer {

    @Autowired
    private MarshalUtils mapper;

    @Autowired
    private RoomRepository repo;

    public CustomerModel merge(CustomerModel model, Customer dto) {

        List<RoomModel> l = new ArrayList<>();

        model.setBlackList(dto.getBlackList());
        model.setName(dto.getName());
        model.setNote(dto.getNote());
        model.setSurname(dto.getSurname());

        if (!dto.getGuests().isEmpty()) {

            model.getGuests().clear();

            dto.getGuests().stream().forEach((g) -> {
                model.getGuests().add(mapper.map(g));
            });

        }

        if (Objects.nonNull(model.getDocument()) && Objects.nonNull(dto.getDocument())) {

            model.getDocument().setDateOfBirth(ConvertDate.toString(dto.getDocument().getDateOfBirth()));
            model.getDocument().setExpiredDoc(ConvertDate.toString(dto.getDocument().getExpiredDoc()));
            model.getDocument().setName(dto.getName());
            model.getDocument().setNationality(dto.getDocument().getNationality());
            model.getDocument().setNumber(dto.getDocument().getNumber());
            model.getDocument().setPlaceOfBirth(dto.getDocument().getPlaceOfBirth());
            model.getDocument().setRelesed(ConvertDate.toString(dto.getDocument().getRelesed()));
            model.getDocument().setResident(dto.getDocument().getResidence());
            model.getDocument().setSurname(dto.getSurname());
            model.getDocument().setType(dto.getDocument().getType());

        }

        if (!dto.getRooms().isEmpty()) {

            dto.getRooms().stream().map((r) -> repo.findByRoomNumber(r.getRoomNumber())).filter((mo) -> (Objects.nonNull(mo))).forEach((mo) -> {
                l.add(mo);
            });

        }

        model.getRooms().clear();

        model.getRooms().addAll(l);

        return model;
    }

    public CustomerModel mergeSave(Customer customer) {

        RoomModel room = null;
        List<RoomModel> l = new ArrayList<>();
        if (!customer.getRooms().isEmpty()) {
            for (Room c : customer.getRooms()) {

                room = repo.findByRoomNumber(c.getRoomNumber());
                if (Objects.nonNull(room)) {
                    l.add(room);
                }
            }
        }

        customer.getRooms().clear();

        CustomerModel cu = mapper.map(customer);

        cu.getRooms().addAll(l);

        return cu;
    }

}
