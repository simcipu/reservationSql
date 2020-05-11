/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.service;

import reservation.myhotelreservation.utils.PageRequestCheckIn;

/**
 *
 * @author simonecipullo
 */
public interface CheckInService {



    PageRequestCheckIn fromDoc(String numberDoc, Integer Page, Integer number);

    PageRequestCheckIn fromTotal(Double totalPrice, Integer Page, Integer number);

    PageRequestCheckIn fromCheck(String checkInDate, String checkOutDate, Integer Page, Integer number);

}
