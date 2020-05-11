/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author simonecipullo
 * @param <E>
 * @param <ID>
 */
@NoRepositoryBean
public interface Repository<E, ID extends Serializable> extends JpaSpecificationExecutor<E>, JpaRepository<E, ID> {
    
}
