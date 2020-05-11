/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.nyhotelreservation.repository;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import reservation.myhotelreservation.utils.ConvertDate;

/**
 *
 * @author simonecipullo
 */
public class convertDateTest {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(convertDateTest.class);

    @Test
    public void lDateTest() throws DatatypeConfigurationException {

        LocalDateTime date = LocalDateTime.now();

        XMLGregorianCalendar xcal = convert(date);

        logger.debug("prima", xcal);
        assertTrue(Objects.nonNull(xcal));

    }

    @Test
    public void xDateTest() throws DatatypeConfigurationException {

        String dt = "2015-09-12T00:00";
        LocalDateTime lo = ConvertDate.toString(dt);
        logger.debug(lo.toString());
        LocalDateTime lo1=lo.plusDays(30);
        logger.debug(lo1.toString());
        
        

    }
 

    public LocalDateTime convert(XMLGregorianCalendar xcal) {

        Date date = xcal.toGregorianCalendar().getTime();
        Instant instant = Instant.ofEpochMilli(date.getTime());
        LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.systemDefault());

        return ldt;
    }

    public XMLGregorianCalendar convert(LocalDateTime calendar) throws DatatypeConfigurationException {

        Date c1 = Date.from(calendar.atZone(ZoneId.systemDefault()).toInstant());

        GregorianCalendar c = new GregorianCalendar();
        c.setTime(c1);
        XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

        return date;
    }

    public static LocalDateTime clean(LocalDateTime time) {

        LocalDateTime date = LocalDateTime.of(time.getYear(), time.getMonth(), time.getDayOfMonth(), 0, 0, 0);

        return date;
    }

}
