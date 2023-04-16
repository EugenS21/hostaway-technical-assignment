package org.eugens21.hostaway.technical_assignment.test.filter;


import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.pages.SearchPage;
import org.eugens21.hostaway.technical_assignment.service.RandomDateGeneratorService;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.DirtiesContext;

@Epic("Home Page Verification Epic")
@Feature("Home Page Search Properties Feature")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomePageSearchTest extends AbstractTest {

    @Test
    @Story("User tries to search a property from home page")
    @Description("As a user I need to be able to search properties by provided criteria")
    @DirtiesContext
    public void verifySearchOnHomePage() {
        var criteria = RandomDateGeneratorService.get().generateRandomSearchPropertiesCriteria();
        SearchPage searchPage = homePage.withCriteria(criteria)
                .searchProperties();

        String actualUrl = searchPage.getCurrentPageUrl();
        String expectedUrl = searchPage.getExpectedUrl();

        softAssertions.assertThat(actualUrl)
                .describedAs("Expecting current URL <%s> to match <%s>", actualUrl, expectedUrl)
                .containsIgnoringCase(expectedUrl);
    }

}
