/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.dto;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author simonecipullo
 */
public class BlackList {

    private Long id;

    Set<Customer> customer = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }

}
