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
import reservation.myhotelreservation.business.service.ReportService;
import reservation.myhotelreservation.dto.Report;
import reservation.myhotelreservation.request.ObjectsRequest;


/**
 *
 * @author simonecipullo
 */
@RestController
public class CustomerReport {

    @Autowired
    private ReportService service;

    @RequestMapping(value = {"/reservation/report/customer"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Report> findAll(@RequestBody ObjectsRequest request) {

        Report report = service.showReportCustomer(request.getNumberDoc(), request.getPage(), request.getNumber());

        return new ResponseEntity<>(report, HttpStatus.OK);
    }

}
