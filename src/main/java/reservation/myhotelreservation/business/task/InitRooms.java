/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.task;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reservation.myhotelreservation.Profiles;
import reservation.myhotelreservation.model.RoomModel;
import reservation.myhotelreservation.repository.RoomRepository;

/**
 *
 * @author Utente
 */
@Component
@Profile(Profiles.APPLICATION)
public class InitRooms {
 private final static org.slf4j.Logger logger = LoggerFactory.getLogger(InitRooms.class);
    @Autowired
    public RoomRepository roomRepo;

    @Scheduled(fixedRate = 130000)
    public void initRooms() {

        
        logger.debug("init rooms..............................");
        if (roomRepo.findAll().isEmpty()) {
logger.debug("save rooms..............................");
            RoomModel room = new RoomModel();

            RoomModel room1 = new RoomModel();

            room1.setFloor(1);
            room1.setRoomNumber("001");
            room1.setNote("ciao");
            room1.setService("service");
            room1.setType("single");

            room.setFloor(2);
            room.setNote("tv");
            room.setRoomNumber("002");
            room.setService("bed");
            room.setType("double room");

            room1 = roomRepo.saveAndFlush(room1);
            room = roomRepo.saveAndFlush(room);
        }

    }
}
