package org.eugens21.hostaway.technical_assignment.test.filter;

import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.tuple.Pair;
import org.eugens21.hostaway.technical_assignment.constant.ErrorMessageConstants;
import org.eugens21.hostaway.technical_assignment.exceptions.IllegalToggleValueException;
import org.eugens21.hostaway.technical_assignment.exceptions.InvalidNumberValueException;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteria;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteriaActualContent;
import org.eugens21.hostaway.technical_assignment.nested_elements.search.SearchPageFilterPopup;
import org.eugens21.hostaway.technical_assignment.pages.SearchPage;
import org.eugens21.hostaway.technical_assignment.service.FilterCriteriaActualMapperService;
import org.eugens21.hostaway.technical_assignment.service.FilterCriteriaExpectedMapperService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import java.math.BigDecimal;
import java.util.concurrent.CompletionException;
import java.util.stream.Stream;

public class SearchPageFilterTest extends AbstractTest {

    @Autowired
    FilterCriteriaExpectedMapperService mapperService;
    @Autowired
    FilterCriteriaActualMapperService actualResultsMapper;
    SearchPageFilterPopup filter;

    //    FIXME add a test with big number and send back space - a bug there
    public static Stream<Pair<FilterCriteria, Range>> actualExpectedPriceValues() {
        return Stream.of(
                Pair.of(FilterCriteria.builder().price(Range.between("1231", "2!3*13")).build(), Range.between(BigDecimal.valueOf(1231), BigDecimal.valueOf(2313))),
                Pair.of(FilterCriteria.builder().price(Range.between("-7", "-8")).build(), Range.between(BigDecimal.valueOf(7), BigDecimal.valueOf(8))),
                Pair.of(FilterCriteria.builder().price(Range.between("1-7.0a5b3", "b1a9s7d-8%.1")).build(), Range.between(BigDecimal.valueOf(17053), BigDecimal.valueOf(19781))),
////               FIXME: May be a bug then the value is minimum value is replaced with higher value - 5 in case high value is more than less one
                Pair.of(FilterCriteria.builder().price(Range.between("561", "82")).build(), Range.between(BigDecimal.valueOf(77), BigDecimal.valueOf(82))),
////               FIXME: When entering large values - the system is ignoring the price ranges
                Pair.of(FilterCriteria.builder().price(Range.between("-10000000000000000000000", "6")).build(), Range.between(new BigDecimal(1), new BigDecimal(6)))
        );
    }

    public static Stream<Pair<FilterCriteria, FilterCriteriaActualContent>> positiveActualExpectedToggleValues() {
        return Stream.of(
                Pair.of(FilterCriteria.builder().beds(0).build(), FilterCriteriaActualContent.builder().beds(0).build()),
                Pair.of(FilterCriteria.builder().beds(2).build(), FilterCriteriaActualContent.builder().beds(2).build()),
                Pair.of(FilterCriteria.builder().beds(10).build(), FilterCriteriaActualContent.builder().beds(10).build()),
                Pair.of(FilterCriteria.builder().bedrooms(0).build(), FilterCriteriaActualContent.builder().bedrooms(0).build()),
                Pair.of(FilterCriteria.builder().bedrooms(3).build(), FilterCriteriaActualContent.builder().bedrooms(3).build()),
                Pair.of(FilterCriteria.builder().bedrooms(10).build(), FilterCriteriaActualContent.builder().bedrooms(10).build()),
                Pair.of(FilterCriteria.builder().bathrooms(0).build(), FilterCriteriaActualContent.builder().bathrooms(0).build()),
                Pair.of(FilterCriteria.builder().bathrooms(5).build(), FilterCriteriaActualContent.builder().bathrooms(5).build()),
                Pair.of(FilterCriteria.builder().bathrooms(10).build(), FilterCriteriaActualContent.builder().bathrooms(10).build())
        );
    }

    public static Stream<Pair<FilterCriteria, Integer>> negativeActualExpectedToggleValues() {
        return Stream.of(
                Pair.of(FilterCriteria.builder().beds(-14).build(), -14),
                Pair.of(FilterCriteria.builder().beds(20).build(), 20),
                Pair.of(FilterCriteria.builder().bedrooms(-1).build(), -1),
                Pair.of(FilterCriteria.builder().bedrooms(45).build(), 45),
                Pair.of(FilterCriteria.builder().bathrooms(-10).build(), -10),
                Pair.of(FilterCriteria.builder().bathrooms(20).build(), 20)
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
    @MethodSource("actualExpectedPriceValues")
    @DirtiesContext
    public void verifyPriceValues(Pair<FilterCriteria, Range> testData) {
        var expectedResult = mapperService.map(testData.getKey());
        FilterCriteriaActualContent actualResult = filter.byCriteria(expectedResult).get();
        softAssertions.assertThat(actualResult)
                .extracting(actualResultsMapper::map)
                .extracting(FilterCriteria::getPrice)
                .describedAs("Expecting to have valid price applied")
                .isEqualTo(testData.getValue());
    }

    @Test
    @DirtiesContext
    public void verifyPriceNullValues() {
        var expectedResult = mapperService.map(FilterCriteria.builder().price(Range.between("0", "0")).build());
        softAssertions.assertThatThrownBy(() -> filter.byCriteria(expectedResult).get())
                .describedAs("Expecting to have empty values on trying to set 0 to price tanges inputs")
                .isInstanceOf(InvalidNumberValueException.class)
                .hasMessage("Can't parse numeric input empty value to a big decimal");
    }

    @ParameterizedTest
    @MethodSource("positiveActualExpectedToggleValues")
    @DirtiesContext
    public void verifyToggleValuesPositiveScenario(Pair<FilterCriteria, FilterCriteriaActualContent> testData) {
        var expectedResult = mapperService.map(testData.getKey());
        FilterCriteriaActualContent actualResult = filter.byCriteria(expectedResult).get();
        softAssertions.assertThat(actualResult)
                .extracting(actualResultsMapper::map)
                .describedAs("Expecting to have valid toggle value applied")
                .usingRecursiveComparison()
                .comparingOnlyFields("beds", "bedrooms", "bathrooms")
                .isEqualTo(actualResultsMapper.map(testData.getValue()));
    }

    @ParameterizedTest
    @MethodSource("negativeActualExpectedToggleValues")
    @DirtiesContext
    public void verifyToggleValuesNegativeScenario(Pair<FilterCriteria, Integer> testData) {
        var expectedResult = mapperService.map(testData.getKey());
        softAssertions.assertThatThrownBy(() -> filter.byCriteria(expectedResult).get())
                .describedAs("Expecting to throw an exception while trying to set values out of bounds")
                .hasCauseInstanceOf(IllegalToggleValueException.class)
                .isInstanceOf(CompletionException.class)
                .hasMessageContaining(String.format(ErrorMessageConstants.INVALID_TOGGLE_RANGE_VALUE, testData.getValue(), testData.getValue() < 0 ? 0 : 10));
    }


}
