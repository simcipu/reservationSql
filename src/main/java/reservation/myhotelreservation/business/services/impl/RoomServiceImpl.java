/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reservation.myhotelreservation.business.exception.ServiceRestException;
import reservation.myhotelreservation.business.service.RoomService;
import reservation.myhotelreservation.dto.Room;
import reservation.myhotelreservation.model.RoomModel;
import reservation.myhotelreservation.repository.RoomRepository;
import reservation.myhotelreservation.utils.MarshalUtils;

/**
 *
 * @author simonecipullo
 */
@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository repo;

    @Autowired
    private MarshalUtils mapper;

    @Override
    public List<Room> create(List<Room> l) {

        l.stream().forEach((r) -> {
            create(r);

        });

        return l;
    }

    @Override
    public void update(List<Room> l) {

        l.stream().forEach((r) -> {
            update(r);

        });

    }

    @Override
    public List<Room> get() {

        List<RoomModel> li = repo.findAll();

        List<Room> dto = new ArrayList<>();

        li.stream().forEach((r) -> {
            dto.add(mapper.map(r));
        });

        return dto;
    }

    @Override
    public Boolean delete(String number) {

        Boolean result = true;

        RoomModel r = repo.findByRoomNumber(number);

        if (Objects.isNull(r)) {

            throw new ServiceRestException("the room don't exits!!");
        }

        repo.delete(r);

        return result;
    }

    @Override
    public Room create(Room room) {

        if (Objects.nonNull(repo.findByRoomNumber(room.getRoomNumber()))) {

            throw new ServiceRestException("the room already exits!!");

        }

        RoomModel ro = mapper.map(room);

        repo.saveAndFlush(ro);

        return room;
    }

    @Override
    public Boolean update(Room l) {

        Boolean result = true;

        if (Objects.isNull(repo.findByRoomNumber(l.getRoomNumber()))) {

            throw new ServiceRestException("the room don't exits!!");

        }

        RoomModel m = repo.findByRoomNumber(l.getRoomNumber());

        m.setFloor(l.getFloor());
        m.setNote(l.getNote());
        m.setRoomNumber(l.getRoomNumber());
        m.setType(l.getType());
        m.setService(l.getService());

        repo.saveAndFlush(m);

        return result;
    }

    @Override
    public List<Room> findFromFloor(Integer floor) {

        List<RoomModel> l = repo.findByFloor(floor);
        List<Room> list = new ArrayList<>();
        if (!l.isEmpty()) {

            l.stream().forEach((r) -> {
                list.add(mapper.map(r));
            });

        }

        return list;

    }

}
