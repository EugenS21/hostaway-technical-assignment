package org.eugens21.hostaway.technical_assignment.test.filter;


import com.github.javafaker.Faker;
import org.apache.commons.lang3.tuple.Pair;
import org.eugens21.hostaway.technical_assignment.model.SearchPropertiesCriteria;
import org.eugens21.hostaway.technical_assignment.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class FilterTest extends AbstractTest {


    @Autowired
    HomePage homePage;
    Faker faker;
    SearchPropertiesCriteria searchPropertiesCriteria;

    @BeforeEach
    public void beforeTest() {
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusDays(faker.number().numberBetween(1, 100));
        searchPropertiesCriteria = SearchPropertiesCriteria.builder()
                .checkInAndOutDates(Pair.of(today, endDate))
                .build();
    }

    @Test
    public void doIt() {
        homePage.withCriteria(searchPropertiesCriteria).searchProperties();
    }

}
