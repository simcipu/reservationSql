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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reservation.myhotelreservation.business.service.RoomService;
import reservation.myhotelreservation.dto.Room;

/**
 *
 * @author simonecipullo
 */
@RestController
public class RoomController {

    @Autowired
    private RoomService service;

    @RequestMapping(value = {"/reservation/room/create"}, method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Room> create(@RequestBody Room dto) {

        Room ro = service.create(dto);

        return new ResponseEntity<>(ro, HttpStatus.CREATED);
    }

    @RequestMapping(value = {"/reservation/room/update"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Boolean> update(@RequestBody Room dto) {

        Boolean b = service.update(dto);

        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @RequestMapping(value = {"/reservation/rooms/all"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Room>> getAll() {

        return new ResponseEntity<>(service.get(), HttpStatus.OK);
    }

    @RequestMapping(value = {"/reservation/room/delete/{number}"}, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Boolean> delete(@PathVariable String number) {

        Boolean b = service.delete(number);

        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @RequestMapping(value = {"/reservation/rooms/{floor}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Room>> findFloor(@PathVariable Integer floor) {

        List<Room> l = service.findFromFloor(floor);

        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @RequestMapping(value = {"/reservation/rooms/create"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Room>> createRooms(@RequestBody List<Room> list) {

        List<Room> l = service.create(list);

        return new ResponseEntity<>(l, HttpStatus.OK);
    }

}
