package org.eugens21.hostaway.technical_assignment.test.filter;


import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.Assertions;
import org.eugens21.hostaway.technical_assignment.pages.SearchPage;
import org.eugens21.hostaway.technical_assignment.service.RandomDateGeneratorService;
import org.testng.annotations.Test;

@Epic("Home Page Verification Epic")
@Feature("Search Properties Feature")
@Story("Property search from home page")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HomePageSearchTest extends AbstractTest {

    @Test
    @Description("As a user, I want to be able to search for properties using criteria that I provide from the home page." +
            "This will allow me to easily find the properties that meet my needs without having to navigate to a separate search page.")
    public void verifySearchOnHomePage() {
        var criteria = RandomDateGeneratorService.get().generateRandomSearchPropertiesCriteria();
        SearchPage searchPage = homePage.withCriteria(criteria)
                .searchProperties();

        String actualUrl = searchPage.getCurrentPageUrl();
        String expectedUrl = searchPage.getExpectedUrl();

        Assertions.assertThat(actualUrl)
                .describedAs("Expecting current URL <%s> to match <%s>", actualUrl, expectedUrl)
                .containsIgnoringCase(expectedUrl);
    }

}
