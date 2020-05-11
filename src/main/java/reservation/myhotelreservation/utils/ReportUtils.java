/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import reservation.myhotelreservation.dto.Guarantees;
import reservation.myhotelreservation.dto.ReportCustomerDto;
import reservation.myhotelreservation.model.CustomerModel;
import reservation.myhotelreservation.model.GuaranteesModel;
import reservation.myhotelreservation.model.GuestModel;
import reservation.myhotelreservation.model.ReservationModel;
import reservation.myhotelreservation.model.RoomModel;
import reservation.myhotelreservation.repository.GuaranteesRepository;
import reservation.myhotelreservation.repository.ReservationRepository;

/**
 *
 * @author simonecipullo
 */
@Component
public class ReportUtils {

    @Autowired
    private MarshalUtils mapper;

    @Autowired
    private GuaranteesRepository guRepo;

    @Autowired
    private ReservationRepository reRepo;

    public List<String> returnRooms(Set<RoomModel> r) {

        List<RoomModel> rooms = new ArrayList<>();
        List<String> ro = new ArrayList<>();

        r.stream().forEach((m) -> {
            rooms.add(m);
        });

        rooms.stream().forEach((rmh) -> {
            ro.add(rmh.getRoomNumber());
        });

        return ro;
    }

    public List<Guarantees> returnGu(List<GuaranteesModel> list) {

        List<GuaranteesModel> l = new ArrayList<>();
        List<Guarantees> dto = new ArrayList<>();
        Guarantees guDto = new Guarantees();

        if (!list.isEmpty()) {

            list.stream().forEach((p) -> {

                if (Objects.nonNull(p.getCreditCard())) {

                    l.addAll(guRepo.findByCreditCard(p.getCreditCard()));

                } else {
                    dto.add(mapper.map(p));

                }

            });

        }

        if (!l.isEmpty()) {
            guDto = mapper.map(l.get(0));

            dto.add(guDto);
        }
        return dto;
    }

    public List<String> returnRate(List<String> sourceList) {

        java.util.Set rate = new HashSet(sourceList);
        return new ArrayList(rate);
    }

    public List<String> numberReservation(String number) {

        List<ReservationModel> repo = reRepo.findReByDoc(number);
        List<String> l = new ArrayList<>();

        if (!repo.isEmpty()) {
            repo.stream().forEach((r) -> {
                l.add(r.getNumberReservation());
            });
        }

        return l;
    }

    public List<GuestModel> returnGuest(List<GuestModel> guests) {

        List<GuestModel> re = new ArrayList<>();

        Set<GuestModel> s = new HashSet<>();

        guests.stream().forEach((h) -> {
            s.add(h);
        });

        re.addAll(new ArrayList(s));

        return re;
    }

    public ReportCustomerDto report(List<CustomerModel> list) {

        ReportCustomerDto dto = new ReportCustomerDto();
        dto.setName(list.get(0).getName());
        dto.setNote(list.get(0).getNote());
        dto.setSurname(list.get(0).getSurname());
        dto.setBlackList(list.get(0).getBlackList());
        dto.setId(list.get(0).getId());

        if (Objects.nonNull(list.get(0).getDocument())) {
            dto.setDocument(mapper.map(list.get(0).getDocument()));
        }

        return dto;

    }

    public void customer(Page<CustomerModel> list, List<GuestModel> guest, Set<RoomModel> rooms) {

        list.getContent().stream().filter((cu) -> (!cu.getRooms().isEmpty())).forEach((cu) -> {
            rooms.addAll(cu.getRooms());
            if (!cu.getGuests().isEmpty()) {
                cu.getGuests().stream().forEach((g) -> {
                    guest.add(g);
                });

            }

        });

    }

}
