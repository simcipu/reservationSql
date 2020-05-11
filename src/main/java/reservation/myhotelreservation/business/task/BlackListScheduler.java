/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.task;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reservation.myhotelreservation.Profiles;
import reservation.myhotelreservation.model.BlackListModel;
import reservation.myhotelreservation.model.CustomerModel;
import reservation.myhotelreservation.repository.BlackListRepository;
import reservation.myhotelreservation.repository.CustomerRepository;
import reservation.myhotelreservation.specification.InSpecification;

/**
 *
 * @author simonecipullo
 */
@Component
@Profile(Profiles.APPLICATION)
public class BlackListScheduler {

    @Autowired
    private CustomerRepository repo;

    @Autowired
    private BlackListRepository repository;

    private BlackListModel l;

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BlackListScheduler.class);

    @Scheduled(fixedRate = 300000)
    public void blackListAddTask() {

        l = repository.findOne(1l);

        if (Objects.isNull(l)) {

            l = new BlackListModel();
            l.setId(1l);
            l = repository.saveAndFlush(l);

        }

        List<CustomerModel> listTrue = repo.findAll(new InSpecification<>("blackList", true));
        logger.info("start scheduler blacklist");

        if (!listTrue.isEmpty()) {

            listTrue.stream().forEach((p) -> {

                if (l.getCustomer().isEmpty()) {

                    l.getCustomer().add(p);
                    l = repository.saveAndFlush(l);

                }

            });

            listTrue.stream().forEach((p) -> {

                if (!l.getCustomer().isEmpty()) {
                    Optional<CustomerModel> op = l.getCustomer().stream().filter(u -> u.getId().equals(p.getId())).findFirst();
                    if (!op.isPresent()) {
                        l.getCustomer().add(p);
                        logger.info("add customer");

                    }

                }

            });
        }

        l = repository.saveAndFlush(l);

        List<CustomerModel> listFalse = repo.findAll(new InSpecification<>("blackList", false));

        if (!listFalse.isEmpty()) {

            listFalse.stream().forEach((p) -> {
                if (!l.getCustomer().isEmpty()) {
                    Optional<CustomerModel> op = l.getCustomer().stream().filter(u -> u.getId().equals(p.getId())).findFirst();
                    if (op.isPresent()) {
                        l.getCustomer().remove(op.get());
                        logger.info("remove customer");
                        repository.saveAndFlush(l);
                    }
                }
            });

        }
    }

}
