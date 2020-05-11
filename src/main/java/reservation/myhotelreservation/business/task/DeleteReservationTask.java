/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.task;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reservation.myhotelreservation.Profiles;
import reservation.myhotelreservation.model.BlackListModel;
import reservation.myhotelreservation.model.CustomerModel;
import reservation.myhotelreservation.model.ReservationModel;
import reservation.myhotelreservation.repository.BlackListRepository;
import reservation.myhotelreservation.repository.CustomerRepository;
import reservation.myhotelreservation.repository.ReservationRepository;
import reservation.myhotelreservation.specification.InSpecification;

/**
 *
 * @author simonecipullo
 */
@Component
@Profile(Profiles.APPLICATION)
public class DeleteReservationTask {

    @Autowired
    private ReservationRepository repo;

    @Autowired
    private BlackListRepository blRepo;

    @Autowired
    private CustomerRepository cRepo;

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(DeleteReservationTask.class);

    @Scheduled(fixedRate = 100000)
    public void deleteReservationTask() {

        List<ReservationModel> list = repo.findAll(new InSpecification<>("status", "DELETED"));

        BlackListModel bkl = blRepo.findOne(1L);
        Set<CustomerModel> l = new HashSet<>();
        Set<CustomerModel> c = new HashSet<>();

        logger.info("start scheduler deleteReservationTask");

        if (!list.isEmpty()) {

            list.stream().filter((r) -> (Objects.isNull(r.getCheck().getCustomer()))).map((r) -> {
                logger.info("delete reservation: " + r.getNumberReservation());
                return r;
            }).forEach((r) -> {
                repo.delete(r);
            });

            list.stream().map((r) -> {
                if (Objects.nonNull(r.getCheck().getCustomer())) {

                    if (!bkl.getCustomer().isEmpty()) {

                        for (CustomerModel m : bkl.getCustomer()) {
                            if (r.getCheck().getCustomer().getId().equals(m.getId())) {
                                l.add(m);

                            }
                        }
                        c.add(r.getCheck().getCustomer());
                    }
                    r.getCheck().setCustomer(null);
                }
                return r;
            }).map((r) -> repo.save(r)).map((r) -> {
                logger.info("delete reservation: " + r.getNumberReservation());
                return r;
            }).forEach((r) -> {
                repo.delete(r);
            });

            bkl.getCustomer().removeAll(l);
            blRepo.save(bkl);

            for (CustomerModel m : c) {
                logger.info("delete customer :" + m.getId());
                m.getRooms().clear();
                m=cRepo.save(m);
                cRepo.delete(m);
            }

        }

    }

}
