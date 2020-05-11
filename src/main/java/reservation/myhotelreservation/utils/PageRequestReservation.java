/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.utils;

import java.util.ArrayList;
import java.util.List;
import reservation.myhotelreservation.dto.Reservation;

/**
 *
 * @author simonecipullo
 */
public class PageRequestReservation {
    
    
    public List<Reservation> list=new ArrayList<>();
    
    public Integer number;
    
    public Integer page;
    
    public Integer totalRecord;

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<Reservation> getList() {
        return list;
    }

    public void setList(List<Reservation> list) {
        this.list = list;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

}
