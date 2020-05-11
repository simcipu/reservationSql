/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.build;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import reservation.myhotelreservation.dto.Report;
import reservation.myhotelreservation.dto.ReportCustomerDto;
import reservation.myhotelreservation.model.CheckInModel;
import reservation.myhotelreservation.model.CustomerModel;
import reservation.myhotelreservation.model.GuaranteesModel;
import reservation.myhotelreservation.model.GuestModel;
import reservation.myhotelreservation.model.ReservationModel;
import reservation.myhotelreservation.model.RoomModel;
import reservation.myhotelreservation.repository.CheckInRepository;
import reservation.myhotelreservation.repository.CustomerRepository;
import reservation.myhotelreservation.repository.ReservationRepository;
import reservation.myhotelreservation.utils.MarshalUtils;
import reservation.myhotelreservation.utils.ReportUtils;
import reservation.myhotelreservation.utils.ValidatePage;

/**
 *
 * @author simonecipullo
 */
@Component
public class BuilderReport {

    @Autowired
    private CustomerRepository repoCustomer;

    @Autowired
    private MarshalUtils mapper;

    @Autowired
    private CheckInRepository chRepo;

    @Autowired
    private ReservationRepository reRepo;

    @Autowired
    private ReportUtils utils;

    public Report build(String number, Integer page, Integer size) {

        Pageable p = ValidatePage.validatePg(page, size);
        Page<CustomerModel> list = repoCustomer.fromDoc(number, p);
        List<CheckInModel> l = chRepo.fromDocument(number);
        List<String> rates = new ArrayList<>();
        Set<RoomModel> rooms = new HashSet<>();
        List<ReservationModel> repo = reRepo.findReByDoc(number);
        List<GuaranteesModel> gu = new ArrayList<>();
        List<GuestModel> guest = new ArrayList<>();

        Report report = new Report();

        if (list.getContent().isEmpty() || l.isEmpty()) {

            return report;
        }
        if (repo.isEmpty()) {

            return report;
        }

        ReportCustomerDto dto = utils.report(list.getContent());

        utils.customer(list, guest, rooms);

        Double to = 0.0;
        if (!l.isEmpty()) {
            for (CheckInModel ch : l) {
                report.getCheckInDate().add(ch.getCheckInDate().toString());
                report.getCheckOutDate().add(ch.getCheckOutDate().toString());
                to = to + ch.getTotalCost();
                rates.add(ch.getCostForNight().toString());
            }
        }

        if (!repo.isEmpty()) {
            repo.stream().map((r3) -> {
                report.getReservationNumber().add(r3.getNumberReservation());
                return r3;
            }).filter((r3) -> (Objects.nonNull(r3.getGuarentees()))).forEach((r3) -> {
                gu.add(r3.getGuarentees());
            });
        }

        if (!gu.isEmpty()) {
            report.getGuarantees().addAll(utils.returnGu(gu));
        }

        utils.returnGuest(guest).stream().forEach((m) -> {
            dto.getGuests().add(mapper.map(m));
        });

        if (!rooms.isEmpty()) {
            report.getRooms().addAll(utils.returnRooms(rooms));
        }
        report.setTotal(to);
        report.setTotalVisit(l.size());
        report.setCustomer(dto);
        report.setPage(list.getNumber() + 1);
        report.setSize(list.getSize());
        report.setRates(utils.returnRate(rates));

        return report;
    }

}
