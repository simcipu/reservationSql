/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reservation.myhotelreservation.Constants;
import reservation.myhotelreservation.ConstantsPayment;
import reservation.myhotelreservation.Profiles;
import reservation.myhotelreservation.model.ReservationModel;
import reservation.myhotelreservation.repository.ReservationRepository;

/**
 *
 * @author simonecipullo
 */
@Component
@Profile(Profiles.APPLICATION)
public class StatusReservationTask {

    @Autowired
    private ReservationRepository repo;

    private final LocalDateTime time = LocalDateTime.now();

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(StatusReservationTask.class);

    @Scheduled(fixedRate = 120000)
    public void statusTask() {

        List<ReservationModel> list = repo.findByStatus(Constants.IN);
        List<ReservationModel> listg = repo.findByStatus(Constants.CONFIRMED);

        logger.info("start status task");
        if (!list.isEmpty()) {
            list.stream().filter((r) -> (Objects.nonNull(r.getCheck()))).filter((r) -> (Objects.nonNull(r.getCheck().getCheckOutDate()))).forEach((r) -> {
                LocalDateTime a
                        = LocalDateTime.of(
                                r.getCheck().getCheckOutDate().getYear(),
                                r.getCheck().getCheckOutDate().getMonth(),
                                r.getCheck().getCheckOutDate().getDayOfMonth(), 0, 0);
                if (a.isBefore(time)) {
                    r.setStatus(Constants.OUT);
                    logger.info("set status reservation OUT with number: " + r.getNumberReservation());
                }
            });

        }

        if (!listg.isEmpty()) {
            listg.stream().map((r) -> {
                if (Objects.nonNull(r.getGuarentees())
                        && Objects.nonNull(r.getCheck())) {
                    r.getCheck().setStatusPayment(ConstantsPayment.GUARANTEED);
                    logger.info("set status checkIn GUARANTEED with number: " + r.getNumberReservation());
                }
                return r;
            }).forEach((r) -> {
                repo.saveAndFlush(r);
            });

        }

    }

}
