/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.service.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reservation.myhotelreservation.business.service.BlackListService;
import reservation.myhotelreservation.dto.BlackList;

/**
 *
 * @author simonecipullo
 */
@RestController
public class BlackListController {

    @Autowired
    private BlackListService service;

    @RequestMapping(value = {"/reservation/show/blacklist"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<BlackList> getBlackList() {

        BlackList dto = service.getBlackList();

        return new ResponseEntity<>(dto, HttpStatus.OK);

    }

}
