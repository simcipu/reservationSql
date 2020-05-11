/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation.utils;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import org.springframework.util.StringUtils;

;

/**
 *
 * @author simonecipullo
 */
public class ConvertDate {

    public static LocalDateTime toString(String date) {
        DateTimeFormatter formatter = null;

        LocalDateTime dateTime = null;

        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        if (!StringUtils.isEmpty(date)) {
            LocalDate dt = LocalDate.parse(date, formatter);

            dateTime = LocalDateTime.of(dt.getYear(), dt.getMonth(), dt.getDayOfMonth(), 0, 0);
        }
        return dateTime;
    }

    public static String toDate(LocalDateTime time) {

        if(Objects.isNull(time)){
        
        return "null";
        }
        
        return time.toString();

    }

}
