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
import reservation.myhotelreservation.business.service.CustomerService;
import reservation.myhotelreservation.dto.Customer;
import reservation.myhotelreservation.model.CustomerModel;
import reservation.myhotelreservation.request.ObjectsRequest;
import reservation.myhotelreservation.utils.PageRequestCustomer;

/**
 *
 * @author simonecipullo
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @RequestMapping(value = {"/reservation/customer/all"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PageRequestCustomer> findAll(@RequestBody ObjectsRequest request) {

        PageRequestCustomer customer = service.findAll(request.getPage(), request.getNumber());

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = {"/reservation/customer/from/name"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<PageRequestCustomer> findByNmae(@RequestBody ObjectsRequest request) {

        PageRequestCustomer customer = service.fromName(request.getName(), request.getSurname(), request.getPage(), request.getNumber());

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(value = {"/reservation/customer/update"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Boolean> update(@RequestBody Customer dto) {

        Boolean result = service.update(dto);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = {"/reservation/customer/delete/{id}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {

        Boolean result = service.delete(id);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = {"/reservation/customer/save"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CustomerModel> save(@RequestBody Customer dto) {

        CustomerModel result = service.save(dto);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
