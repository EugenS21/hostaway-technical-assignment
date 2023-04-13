package org.eugens21.hostaway.technical_assignment.test.filter;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.model.SearchPropertiesCriteria;
import org.eugens21.hostaway.technical_assignment.pages.SearchPage;
import org.junit.jupiter.api.Test;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomePageSearchTest extends AbstractTest {

    @Test
    public void verifySearchOnHomePage() {
        var criteria = SearchPropertiesCriteria.builder()
                .checkInAndOutDates(randomDateGeneratorService.generateDateInterval())
                .build();
        SearchPage searchPage = homePage.withCriteria(criteria).searchProperties();

        String actualUrl = searchPage.getCurrentPageUrl();
        String expectedUrl = searchPage.getExpectedUrl();

        softAssertions.assertThat(actualUrl)
                .describedAs("Expecting current URL <%s> to match <%s>", actualUrl, expectedUrl)
                .containsIgnoringCase(expectedUrl);
    }

}
