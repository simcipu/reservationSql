/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.service.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reservation.myhotelreservation.business.service.ReservationService;
import reservation.myhotelreservation.model.ReservationModel;

/**
 *
 * @author simonecipullo
 */
@RestController
public class PsSecurityController {

    @Autowired
    private ReservationService service;

    @RequestMapping(value = {"/reservation/create/ps"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Boolean> createPs() {

        Boolean result = false;

        List<ReservationModel> l = service.findByStatusIn();

        if (!l.isEmpty()) {

            for (ReservationModel r : l) {
                
                
                
            }

        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
