package org.eugens21.hostaway.technical_assignment.test.filter;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.commons.lang3.Range;
import org.assertj.core.api.Assertions;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteria;
import org.eugens21.hostaway.technical_assignment.model.SearchGridItemContent;
import org.eugens21.hostaway.technical_assignment.pages.SearchPage;
import org.eugens21.hostaway.technical_assignment.service.FilterCriteriaExpectedMapperService;
import org.eugens21.hostaway.technical_assignment.service.RandomDateGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

@Epic("All Listings Page Verification Epic")
@Feature("Properties Grid Feature")
@Story("View all available properties on the listings page")
public class SearchPageGridTest extends AbstractTest {

    @Autowired
    FilterCriteriaExpectedMapperService mapperService;


    //    @Test(dataProviderClass = SearchPageFilterTestDataProvider.class, dataProvider = "criteriaToFilterBy")
    @Description("As a user, I want to be able to use the feature grid on the search page to quickly identify the properties that meet my specific needs and preferences. " +
            "The feature grid will allow me to easily view the different features and amenities of each property and compare them to my requirements.")
    public void verifyGridItemsFilteringByPrice(FilterCriteria criteria) {
        var searchProperties = RandomDateGeneratorService.get().generateRandomSearchPropertiesCriteria();
        SearchPage searchPage = homePage.withCriteria(searchProperties).searchProperties();
        searchPage.toolbar()
                .filter()
                .byCriteria(mapperService.map(criteria))
                .apply();

        List<SearchGridItemContent> itemsFromGrid = searchPage.grid().items();

        Assertions.assertThat(itemsFromGrid)
                .describedAs("Expecting items from grid to be filtered according criteria: <%s>", criteria)
                .allSatisfy(item -> {
                    Assertions.assertThat(((Range<BigDecimal>) criteria.getPrice()).contains(item.getPrice().getAmount()));
                });
    }

}
