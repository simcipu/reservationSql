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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reservation.myhotelreservation.business.service.CheckInService;
import reservation.myhotelreservation.request.ObjectsRequest;
import reservation.myhotelreservation.utils.PageRequestCheckIn;

/**
 *
 * @author simonecipullo
 */
@RestController
public class CheckInController {

    @Autowired
    private CheckInService service;

    @RequestMapping(value = {"/reservation/checkIn/doc"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PageRequestCheckIn> fromDoc(@RequestBody ObjectsRequest request) {

        PageRequestCheckIn customer = service.fromDoc(request.getNumberDoc(), request.getPage(), request.getNumber());

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = {"/reservation/checkIn/total"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PageRequestCheckIn> fromTotal(@RequestBody ObjectsRequest request) {

        PageRequestCheckIn customer = service.fromTotal(request.getTotalCost(), request.getPage(), request.getNumber());

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = {"/reservation/checkIn/check"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PageRequestCheckIn> fromCheck(@RequestBody ObjectsRequest request) {

        PageRequestCheckIn customer = service.fromCheck(request.getCheckInDate(), request.getCheckOutDate(), request.getPage(), request.getNumber());

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
