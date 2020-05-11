/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.service;

import reservation.myhotelreservation.dto.Customer;
import reservation.myhotelreservation.model.CustomerModel;
import reservation.myhotelreservation.utils.PageRequestCustomer;

/**
 *
 * @author simonecipullo
 */
public interface CustomerService {

    PageRequestCustomer fromName(String name, String surname, Integer page, Integer number);

    PageRequestCustomer findAll(Integer page, Integer number);

    Boolean delete(Integer id);

    CustomerModel save(Customer cutomer);
    
    Boolean update(Customer cutomer);

}
