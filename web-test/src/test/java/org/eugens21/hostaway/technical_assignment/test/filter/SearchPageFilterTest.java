package org.eugens21.hostaway.technical_assignment.test.filter;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.tuple.Pair;
import org.assertj.core.api.Assertions;
import org.eugens21.hostaway.technical_assignment.constant.ErrorMessageConstants;
import org.eugens21.hostaway.technical_assignment.exceptions.IllegalToggleValueException;
import org.eugens21.hostaway.technical_assignment.exceptions.InvalidNumberValueException;
import org.eugens21.hostaway.technical_assignment.model.Amenities;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteria;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteriaActualContent;
import org.eugens21.hostaway.technical_assignment.pages.nested_elements.search.popup.SearchPageFilterPopup;
import org.eugens21.hostaway.technical_assignment.service.FilterCriteriaActualMapperService;
import org.eugens21.hostaway.technical_assignment.service.FilterCriteriaExpectedMapperService;
import org.eugens21.hostaway.technical_assignment.service.RandomDateGeneratorService;
import org.eugens21.hostaway.technical_assignment.test.filter.data_provider.SearchPageFilterTestDataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.CompletionException;

@Epic("Search Page Verification Epic")
@Feature("Toolbar Filter Feature")
@Story("Search toolbar filter elements")
public class SearchPageFilterTest extends AbstractTest {

    @Autowired
    FilterCriteriaExpectedMapperService mapperService;
    @Autowired
    FilterCriteriaActualMapperService actualResultsMapper;
    @Autowired
    ApplicationContext applicationContext;
    SearchPageFilterPopup filter;

    @BeforeClass
    public void goToFilter() {
        var criteria = RandomDateGeneratorService.get().generateRandomSearchPropertiesCriteria();
        filter = homePage.withCriteria(criteria)
                .searchProperties()
                .toolbar()
                .filter();
    }

    @Description("As a user, I want to be able to use the toolbar price filter on the search page to quickly narrow down my search results. " +
            "This will allow me to find the properties that fit my budget." +
            "The system should allow a user to enter only valid values as the price, as this would result in irrelevant search results.")
    @Test(dataProviderClass = SearchPageFilterTestDataProvider.class, dataProvider = "actualExpectedPriceValues")
    public void verifyPriceValues(Pair<FilterCriteria, Range> testData) {
        var expectedResult = mapperService.map(testData.getKey());
        FilterCriteriaActualContent actualResult = filter.byCriteria(expectedResult).get();

        Assertions.assertThat(actualResult)
                .extracting(actualResultsMapper::map)
                .extracting(FilterCriteria::getPrice)
                .describedAs("Expecting to have valid price applied")
                .isEqualTo(testData.getValue());
    }

    @Test
    @Description("The system should not allow a user to enter 0 as the price, as this would result in irrelevant search results.")
    public void verifyPriceNullValues() {
        var expectedResult = mapperService.map(FilterCriteria.builder().price(Range.between("0", "0")).build());
        Assertions.assertThatThrownBy(() -> filter.byCriteria(expectedResult).get())
                .describedAs("Expecting to have empty values on trying to set 0 to price ranges inputs")
                .isInstanceOf(InvalidNumberValueException.class)
                .hasMessage("Can't parse numeric input empty value to a big decimal");
    }

    @Description("As a user, I want to be able to use the toolbar toggle filter on the search page to quickly narrow down my search " +
            "results by specifying the number of bedrooms and bathrooms that I desire.")
    @Test(dataProviderClass = SearchPageFilterTestDataProvider.class, dataProvider = "positiveActualExpectedToggleValues")
    public void verifyToggleValuesPositiveScenario(Pair<FilterCriteria, FilterCriteriaActualContent> testData) {
        var expectedResult = mapperService.map(testData.getKey());
        FilterCriteriaActualContent actualResult = filter.byCriteria(expectedResult).get();

        Assertions.assertThat(actualResult)
                .extracting(actualResultsMapper::map)
                .describedAs("Expecting to have valid toggle value applied")
                .usingRecursiveComparison()
                .comparingOnlyFields("beds", "bedrooms", "bathrooms")
                .isEqualTo(actualResultsMapper.map(testData.getValue()));
    }

    @Description("The system should not allow a user to enter values outside of a preset range.")
    @Test(dataProviderClass = SearchPageFilterTestDataProvider.class, dataProvider = "negativeActualExpectedToggleValues")
    public void verifyToggleValuesNegativeScenario(Pair<FilterCriteria, Integer> testData) {
        var expectedResult = mapperService.map(testData.getKey());

        Assertions.assertThatThrownBy(() -> filter.byCriteria(expectedResult).get())
                .describedAs("Expecting to throw an exception while trying to set values out of bounds")
                .hasCauseInstanceOf(IllegalToggleValueException.class)
                .isInstanceOf(CompletionException.class)
                .hasMessageContaining(String.format(ErrorMessageConstants.INVALID_TOGGLE_RANGE_VALUE, testData.getValue(), testData.getValue() < 0 ? 0 : 10));
    }

    @Description("As a user, I want to be able to use the toolbar checkbox filter on the search page " +
            "to quickly narrow down my search results. This will allow me to find the properties with amenities I'm looking for.")
    @Test(dataProviderClass = SearchPageFilterTestDataProvider.class, dataProvider = "positiveActualExpectedAmenitiesValues")
    public void verifyAmenitiesCheckboxes(Amenities testData) {
        var expectedResult = mapperService.map(FilterCriteria.builder().amenities(testData).build());
        FilterCriteriaActualContent actualResult = filter.byCriteria(expectedResult).get();

        Assertions.assertThat(actualResult)
                .extracting(actualResultsMapper::map)
                .extracting(FilterCriteria::getAmenities)
                .describedAs("Expecting to have valid toggle value applied")
                .usingRecursiveComparison()
                .ignoringFieldsOfTypes(Integer.class)
                .ignoringFields("price")
                .isEqualTo(testData);
    }

}
