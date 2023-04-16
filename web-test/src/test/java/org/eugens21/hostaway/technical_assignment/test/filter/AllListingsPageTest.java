package org.eugens21.hostaway.technical_assignment.test.filter;


import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.nested_elements.search.grid.AllListingsPageGrid;
import org.eugens21.hostaway.technical_assignment.pages.AllListingsPage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

@Epic("All Listings Page Verification Epic")
@Feature("All Listings Page Feature")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AllListingsPageTest extends AbstractTest {

    @Autowired
    AllListingsPage allListingsPage;

    @Test
    @Story("User tries to search a property from home page")
    @Description("As a user I need to be able to search properties by provided criteria")
    @DirtiesContext
    public void verifyListingsOnAllListingsPage() {
        AllListingsPageGrid grid = allListingsPage.open().grid();
        var items = grid.items();

        softAssertions.assertThat(items)
                .describedAs("Expecting that page has the same amount of listings as the 'All' label")
                .hasSize(grid.getAll());
    }

}
