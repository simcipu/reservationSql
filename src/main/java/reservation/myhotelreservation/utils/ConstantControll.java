/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.utils;

import org.springframework.util.StringUtils;
import reservation.myhotelreservation.Constants;
import reservation.myhotelreservation.ConstantsPayment;

/**
 *
 * @author simonecipullo
 */
public class ConstantControll {

    public static Boolean validateReservationStatus(String status) {

        Boolean result = false;

        if (StringUtils.isEmpty(status)) {

            return true;
        }

        if ((status.equals(Constants.IN) || status.equals(Constants.OUT))
                || (status.equals(Constants.CONFIRMED) || status.equals(Constants.DELETED))) {

            result = true;

        }

        return result;
    }

    public static Boolean validateChechInStatus(String status) {

        Boolean result = false;

        if (StringUtils.isEmpty(status)) {

            return true;
        }

        if ((status.equals(ConstantsPayment.GUARANTEED) || status.equals(ConstantsPayment.PAID))
                || (status.equals(ConstantsPayment.TO_PAY))) {

            result = true;

        }

        return result;
    }

}
