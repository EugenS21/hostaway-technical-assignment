package org.eugens21.hostaway.technical_assignment.configuration;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class FakerConfiguration {

    @Bean
    public Faker faker() {
        return new Faker(Locale.ENGLISH);
    }

}
