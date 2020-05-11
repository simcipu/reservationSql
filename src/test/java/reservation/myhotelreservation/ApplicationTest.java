/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.myhotelreservation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ActiveProfiles;


/**
 *
 * @author simonecipullo
 */
@ActiveProfiles({Profiles.TEST})
@SpringBootApplication
public class ApplicationTest extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(this.getClass());
    }
    
      @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurerDev()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }
   


}
