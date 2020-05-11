/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.service;

import reservation.myhotelreservation.dto.CheckOut;

/**
 *
 * @author simonecipullo
 */
public interface CheckOutService {

    public CheckOut save(String numberReservation);

    public String delete(String numberReservation);
}
