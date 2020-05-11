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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reservation.myhotelreservation.business.service.ReservationService;
import reservation.myhotelreservation.dto.Reservation;
import reservation.myhotelreservation.request.ObjectsRequest;
import reservation.myhotelreservation.utils.PageRequestReservation;

/**
 *
 * @author simonecipullo
 */
@RestController
public class ReservationController {

    @Autowired
    public ReservationService service;

    @RequestMapping(value = {"/reservation/save"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Reservation> create(@RequestBody Reservation dto) {

        Reservation dmodel = service.save(dto);

        return new ResponseEntity<>(dmodel, HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/reservation/{numberReservation}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Reservation> findById(@PathVariable("numberReservation") String number) {

        Reservation r = service.findById(number);

        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    @RequestMapping(value = {"/reservation/update"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Boolean> update(@RequestBody Reservation dto) {

        Boolean result = service.update(dto);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = {"/reservation/delete/{numberReservation}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Boolean> delete(@PathVariable("numberReservation") String numberReservation) {

        Boolean result = service.delete(numberReservation);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = {"/reservation/date"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PageRequestReservation> findByDate(@RequestBody ObjectsRequest request) {

        PageRequestReservation res = service.findByDate(request.getDate(), request.getPage(), request.getNumber());

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = {"/reservation/from"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PageRequestReservation> fromByDate(@RequestBody ObjectsRequest request) {

        PageRequestReservation res = service.fromByDate(request.getDate(), request.getAt(), request.getPage(), request.getNumber());

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = {"/reservation/from/Customer"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PageRequestReservation> fromCustomer(@RequestBody ObjectsRequest request) {

        PageRequestReservation res = service.fromCustomer(request.getName(), request.getSurname(), request.getNumberDoc(), request.getPage(), request.getNumber());

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = {"/reservation/all"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PageRequestReservation> fromAll(@RequestBody ObjectsRequest request) {

        PageRequestReservation res = service.findAll(request.getPage(), request.getNumber());

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @RequestMapping(value = {"/reservation/change/{numberReservation}/status/{status}"}, 
            method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Boolean> changeStatus(
            @PathVariable("numberReservation") String numberReservation, 
            @PathVariable("status") String status) {

        boolean result = service.changeStatus(numberReservation, status);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
