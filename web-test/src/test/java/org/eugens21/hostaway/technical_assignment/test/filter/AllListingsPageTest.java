package org.eugens21.hostaway.technical_assignment.test.filter;


import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.assertj.core.api.Assertions;
import org.eugens21.hostaway.technical_assignment.pages.AllListingsPage;
import org.eugens21.hostaway.technical_assignment.pages.nested_elements.search.grid.AllListingsPageGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

@Epic("All Listings Page Verification Epic")
@Feature("Properties Grid Feature")
@Story("View all available properties on the listings page")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AllListingsPageTest extends AbstractTest {

    @Autowired
    AllListingsPage allListingsPage;

    @Test
    @Description("As a user, I want to be able to view all properties available on the listings page. This will allow me to easily browse and find the property that best suits my needs.")
    public void verifyListingsOnAllListingsPage() {
        AllListingsPageGrid grid = allListingsPage.open().grid();
        var items = grid.items();

        Assertions.assertThat(items)
                .describedAs("Expecting that page has the same amount of listings as the 'All' label")
                .hasSize(grid.getAll());
    }

}
