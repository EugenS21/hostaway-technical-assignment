package org.eugens21.hostaway.technical_assignment.test.filter;

import org.apache.commons.lang3.Range;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteria;
import org.eugens21.hostaway.technical_assignment.model.SearchGridItemContent;
import org.eugens21.hostaway.technical_assignment.pages.SearchPage;
import org.eugens21.hostaway.technical_assignment.service.FilterCriteriaActualMapperService;
import org.eugens21.hostaway.technical_assignment.service.FilterCriteriaExpectedMapperService;
import org.eugens21.hostaway.technical_assignment.service.RandomDateGeneratorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.util.List;

public class SearchPageGridTest extends AbstractTest {

    @Autowired
    FilterCriteriaExpectedMapperService mapperService;
    @Autowired
    FilterCriteriaActualMapperService actualResultsMapper;

    public static List<FilterCriteria> criteriaToFilter() {
        return List.of(
                FilterCriteria.builder().bedrooms(2).bathrooms(1).build()
        );
    }

    @ParameterizedTest
    @MethodSource("criteriaToFilter")
    @DirtiesContext
    public void verifyGridItemsFiltering(FilterCriteria criteria) {
        var searchProperties = RandomDateGeneratorService.get().generateRandomSearchPropertiesCriteria();
        SearchPage searchPage = homePage.withCriteria(searchProperties).searchProperties();
        searchPage.toolbar()
                .filter()
                .byCriteria(mapperService.map(criteria))
                .apply();

        List<SearchGridItemContent> itemsFromGrid = searchPage.grid().items();

        softAssertions.assertThat(itemsFromGrid)
                .describedAs("Expecting items from grid to be filtered according criteria: <%s>", criteria)
                .allSatisfy(item -> {
                    softAssertions.assertThat(((Range<BigDecimal>) criteria.getPrice()).contains(item.getPrice().getAmount()));
                });
    }

}
