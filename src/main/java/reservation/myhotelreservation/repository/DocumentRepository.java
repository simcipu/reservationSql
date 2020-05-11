/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.repository;

import java.util.List;
import reservation.myhotelreservation.model.DocumentModel;

/**
 *
 * @author simonecipullo
 */
public interface DocumentRepository extends Repository<DocumentModel, Long> {

    List<DocumentModel> findByName(String name);

    List<DocumentModel> findBySurname(String surname);

    DocumentModel findByNumber(String number);

}
