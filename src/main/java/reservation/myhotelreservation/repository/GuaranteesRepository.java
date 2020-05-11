/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import reservation.myhotelreservation.model.GuaranteesModel;

/**
 *
 * @author simonecipullo
 */
public interface GuaranteesRepository extends Repository<GuaranteesModel, Long> {

    @Query("select u from GuaranteesModel u where u.creditCard=?1")
    List<GuaranteesModel> findByCreditCard(String creditCard);

}
