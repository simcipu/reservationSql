/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.utils;

import java.util.Objects;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author simonecipullo
 */
public class ValidatePage {

    public static Pageable validatePg(Integer page, Integer number) {

        Pageable p = null;
      

        if (Objects.isNull(page) || Objects.isNull(number)) {

            p = new PageRequest(0, 50);
            return p;
        }
        if (page <= 1) {

            page = 0;
        }

        if (page > 1) {

            page = page - 1;
        }

        p = new PageRequest(page, number);

        return p;
    }

}
