/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.exception;

/**
 *
 * @author simonecipullo
 */
public class ServiceRestException extends RuntimeException {

    public ServiceRestException() {
    }

    public ServiceRestException(String message) {
        super(message);
    }

    public ServiceRestException(String message, Throwable cause) {
        super(message, cause);
    }

}
