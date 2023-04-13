package org.eugens21.hostaway.technical_assignment.test.filter;

import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.tuple.Pair;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteria;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteriaActualContent;
import org.eugens21.hostaway.technical_assignment.nested_elements.search.SearchPageFilterPopup;
import org.eugens21.hostaway.technical_assignment.pages.SearchPage;
import org.eugens21.hostaway.technical_assignment.service.FilterCriteriaActualMapperService;
import org.eugens21.hostaway.technical_assignment.service.FilterCriteriaExpectedMapperService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class SearchPageFilterTest extends AbstractTest {

    @Autowired
    FilterCriteriaExpectedMapperService mapperService;
    @Autowired
    FilterCriteriaActualMapperService actualResultsMapper;
    SearchPageFilterPopup filter;

    public static Stream<Pair<FilterCriteria, FilterCriteriaActualContent>> filterCriteria() {
        return Stream.of(
//                Pair.of(FilterCriteria.builder().price(Range.between("1231", "!2313")).build(), FilterCriteriaActualContent.builder().price(Range.between(BigDecimal.valueOf(1231), BigDecimal.valueOf(2313))).build()),
//                Pair.of(FilterCriteria.builder().price(Range.between("-7", "-8")).build(), FilterCriteriaActualContent.builder().price(Range.between(BigDecimal.valueOf(7), BigDecimal.valueOf(8))).build()),
                Pair.of(FilterCriteria.builder().price(Range.between("1-7.0a5b3", "b1a9s7d-8%.1")).build(), FilterCriteriaActualContent.builder().price(Range.between(BigDecimal.valueOf(17053), BigDecimal.valueOf(19781))).build()),
                Pair.of(FilterCriteria.builder().price(Range.between("561", "82")).build(), FilterCriteriaActualContent.builder().price(Range.between(BigDecimal.valueOf(8), BigDecimal.valueOf(721))).build())
        );
    }

    @BeforeEach
    public void goToFilter() {
        var criteria = randomDateGeneratorService.generateRandomSearchPropertiesCriteria();
        SearchPage searchPage = homePage.withCriteria(criteria).searchProperties();
//        FilterCriteria filterCriteria = randomDateGeneratorService.generateRandomFilterCriteria();
//        FilterCriteriaExpectedContent filterContent = mapperService.map(filterCriteria);
//        filterContent.setPrice(Range.between(BigDecimal.valueOf(19999), BigDecimal.valueOf(29999)));
        filter = searchPage.toolbar().filter();
    }

    @ParameterizedTest
    @MethodSource("filterCriteria")
    @DirtiesContext
    public void verifyPriceFromValue(Pair<FilterCriteria, FilterCriteriaActualContent> testData) {
        var expectedResult = mapperService.map(testData.getKey());
        FilterCriteriaActualContent actualResult = filter.byCriteria(expectedResult).get();
        softAssertions.assertThat(actualResult)
                .extracting(actualResultsMapper::map)
                .extracting(FilterCriteria::getPrice)
                .describedAs("Expecting to have the same price applied")
                .isEqualTo(testData.getValue().getPrice());
    }

}
