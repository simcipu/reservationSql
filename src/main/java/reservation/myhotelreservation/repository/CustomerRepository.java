/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import reservation.myhotelreservation.model.CustomerModel;

/**
 *
 * @author simonecipullo
 */
public interface CustomerRepository extends Repository<CustomerModel, Integer> {

    @Query("select u from CustomerModel u where u.document.name=?1 or u.document.surname=?2")
    Page<CustomerModel> fromPersonName(String name, String surname, Pageable page);

    @Query("select u from CustomerModel u where u.document.dateOfBirth=?1")
    Page<CustomerModel> fromDate(String date, Pageable page);

    @Query("select u from CustomerModel u where u.document.number=?1")
    Page<CustomerModel> fromDoc(String numberDoc, Pageable page);

    @Query("select u from CustomerModel u where u.blackList=?1 and u.id=?2")
    CustomerModel findByflag(Boolean flag, Long id);

}
