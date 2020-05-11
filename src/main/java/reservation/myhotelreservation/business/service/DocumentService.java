/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.business.service;

import java.util.List;
import reservation.myhotelreservation.dto.Document;

/**
 *
 * @author simonecipullo
 */
public interface DocumentService {

    List<Document> findByType(String type);

}
