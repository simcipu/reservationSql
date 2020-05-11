/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.services.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservation.myhotelreservation.business.service.CheckInService;
import reservation.myhotelreservation.dto.CheckIn;
import reservation.myhotelreservation.model.CheckInModel;
import reservation.myhotelreservation.repository.CheckInRepository;
import reservation.myhotelreservation.utils.ConvertDate;
import reservation.myhotelreservation.utils.MarshalUtils;
import reservation.myhotelreservation.utils.PageRequestCheckIn;
import reservation.myhotelreservation.utils.ValidatePage;

/**
 *
 * @author simonecipullo
 */
@Service
@Transactional
public class CheckInServiceImpl implements CheckInService {

    @Autowired
    private CheckInRepository repository;

    @Autowired
    private MarshalUtils mapper;



    @Override
    public PageRequestCheckIn fromDoc(String numberDoc, Integer Page, Integer number) {

        Pageable p = ValidatePage.validatePg(Page, number);

        Page<CheckInModel> list = repository.fromDocument(numberDoc, p);
        List<CheckIn> l = new ArrayList<>();

        reservation.myhotelreservation.utils.PageRequestCheckIn request = new PageRequestCheckIn();

        if (!list.getContent().isEmpty()) {
            list.getContent().stream().forEach((d) -> {
                l.add(mapper.map(d));
            });
        }

        request.setList(l);

        request.setPage(p.getPageNumber() + 1);
        request.setNumber(p.getPageSize());
        request.setTotalRecord(list.getNumberOfElements());

        return request;
    }

    @Override
    public PageRequestCheckIn fromTotal(Double totalCost, Integer Page, Integer number) {

        Pageable p = ValidatePage.validatePg(Page, number);

        Page<CheckInModel> list = repository.fromTotal(totalCost, p);
        List<CheckIn> l = new ArrayList<>();

        reservation.myhotelreservation.utils.PageRequestCheckIn request = new PageRequestCheckIn();

        if (!list.getContent().isEmpty()) {

            list.getContent().stream().forEach((d) -> {
                l.add(mapper.map(d));
            });
        }

        request.setList(l);
        request.setPage(p.getPageNumber() + 1);

        request.setNumber(p.getPageSize());

        request.setTotalRecord(list.getNumberOfElements());

        return request;
    }

    @Override
    public PageRequestCheckIn fromCheck(String checkInDate, String checkOutDate, Integer Page, Integer number) {

        Pageable p = ValidatePage.validatePg(Page, number);

        Page<CheckInModel> list = repository.fromCheckIn(ConvertDate.toString(checkInDate), ConvertDate.toString(checkOutDate), p);
        List<CheckIn> l = new ArrayList<>();

        reservation.myhotelreservation.utils.PageRequestCheckIn request = new PageRequestCheckIn();

        if (!list.getContent().isEmpty()) {

            list.getContent().stream().forEach((d) -> {
                l.add(mapper.map(d));
            });
        }

        request.setList(l);

        request.setPage(p.getPageNumber() + 1);

        request.setNumber(p.getPageSize());

        request.setTotalRecord(list.getNumberOfElements());

        return request;
    }

}
