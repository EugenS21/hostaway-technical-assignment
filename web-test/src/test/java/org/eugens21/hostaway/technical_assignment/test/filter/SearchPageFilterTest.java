package org.eugens21.hostaway.technical_assignment.test.filter;

import org.eugens21.hostaway.technical_assignment.model.SearchPropertiesCriteria;
import org.eugens21.hostaway.technical_assignment.pages.SearchPage;
import org.junit.jupiter.api.Test;

public class SearchPageFilterTest extends AbstractTest {

    @Test
    public void verifyFilteringConditions() {
        var criteria = SearchPropertiesCriteria.builder()
                .checkInAndOutDates(randomDateGeneratorService.generateDateInterval())
                .build();
        SearchPage searchPage = homePage.withCriteria(criteria).searchProperties();

    }

}
