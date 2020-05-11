/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author simonecipullo
 */
@Entity
@Table(name = "blackList")
public class BlackListModel implements Serializable {

    @Id
    private Long id;


    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "BlackList_to_customer", schema = "public",
            inverseJoinColumns = {
                @JoinColumn(name = "customer_id", referencedColumnName = "id")},
            joinColumns = {
                @JoinColumn(name = "blackList_id", referencedColumnName = "id")}
    )
    private Set<CustomerModel> customer = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Set<CustomerModel> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<CustomerModel> customer) {
        this.customer = customer;
    }

}
