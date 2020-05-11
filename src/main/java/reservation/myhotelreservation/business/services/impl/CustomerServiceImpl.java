/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservation.myhotelreservation.dto.Customer;
import reservation.myhotelreservation.model.CustomerModel;
import reservation.myhotelreservation.utils.MarshalUtils;
import reservation.myhotelreservation.utils.PageRequestCustomer;
import reservation.myhotelreservation.utils.ValidatePage;
import reservation.myhotelreservation.repository.CustomerRepository;
import reservation.myhotelreservation.business.service.CustomerService;
import reservation.myhotelreservation.model.BlackListModel;
import reservation.myhotelreservation.model.ReservationModel;
import reservation.myhotelreservation.repository.BlackListRepository;
import reservation.myhotelreservation.repository.ReservationRepository;
import reservation.myhotelreservation.utils.MergeCustomer;

/**
 *
 * @author simonecipullo
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repo;

    @Autowired
    private MarshalUtils mapper;

    @Autowired
    private ReservationRepository reRepo;

    @Autowired
    private BlackListRepository blRepo;

    @Autowired
    private MergeCustomer merge;

    //ok
    @Override
    public PageRequestCustomer fromName(String name, String surname, Integer page, Integer number) {

        Pageable p = ValidatePage.validatePg(page, number);

        List<Customer> l = new ArrayList<>();

        Page<CustomerModel> list = repo.fromPersonName(name, surname, p);

        PageRequestCustomer request = new PageRequestCustomer();

        if (!list.getContent().isEmpty()) {

            list.getContent().stream().forEach((d) -> {
                l.add(mapper.map(d));
            });
        }

        request.setList(l);
        request.setPage(p.getPageNumber() + 1);
        request.setNumber(p.getPageSize());
        request.setTotalRecord(l.size());

        return request;
    }

    //ok
    @Override
    public PageRequestCustomer findAll(Integer page, Integer number) {

        Pageable p = ValidatePage.validatePg(page, number);

        List<Customer> l = new ArrayList<>();

        Page<CustomerModel> list = repo.findAll(p);

        PageRequestCustomer request = new PageRequestCustomer();

        if (!list.getContent().isEmpty()) {

            list.getContent().stream().forEach((d) -> {
                l.add(mapper.map(d));
            });
        }

        request.setList(l);
        request.setPage(p.getPageNumber() + 1);
        request.setNumber(p.getPageSize());
        request.setTotalRecord(l.size());

        return request;
    }

    //ok
    @Override
    public Boolean delete(Integer id) {

        boolean result = true;
        CustomerModel customer = repo.findOne(id);

        if (Objects.isNull(customer)) {

            return false;
        }

        BlackListModel bkl = blRepo.findOne(1L);
        ReservationModel r = reRepo.fromCustomer(id);
        Set<CustomerModel> l = new HashSet<>();
        

        if (Objects.nonNull(r)) {

            r.getCheck().setCustomer(null);
            reRepo.save(r);
        }

        if (!bkl.getCustomer().isEmpty()) {

            for (CustomerModel m : bkl.getCustomer()) {
                if (customer.getId().equals(m.getId())) {
                    l.add(m);
                    

                }
            }

        }
        
        bkl.getCustomer().removeAll(l);
        blRepo.save(bkl);

        repo.delete(customer);

        return result;
    }

    @Override
    //ok
    public CustomerModel save(Customer customer) {

        CustomerModel m = merge.mergeSave(customer);

        CustomerModel m1 = repo.save(m);

        return m1;

    }

    @Override//ok
    public Boolean update(Customer customer) {

        boolean result = true;
        CustomerModel cu = repo.findOne(customer.getId());

        if (Objects.isNull(cu)) {

            return false;
        }

        CustomerModel m = merge.merge(cu, customer);

        repo.save(m);

        return result;

    }
}
