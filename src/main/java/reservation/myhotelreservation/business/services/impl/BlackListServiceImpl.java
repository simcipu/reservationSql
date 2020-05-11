/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservation.myhotelreservation.business.service.BlackListService;
import reservation.myhotelreservation.dto.BlackList;
import reservation.myhotelreservation.model.BlackListModel;
import reservation.myhotelreservation.repository.BlackListRepository;
import reservation.myhotelreservation.utils.MarshalUtils;

/**
 *
 * @author simonecipullo
 */
@Service
@Transactional
public class BlackListServiceImpl implements BlackListService {

    @Autowired
    private BlackListRepository repository;

    @Autowired
    private MarshalUtils mapper;

    @Override
    public BlackList getBlackList() {

        BlackListModel dt = repository.findOne(1l);

        return mapper.map(dt);

    }

}
