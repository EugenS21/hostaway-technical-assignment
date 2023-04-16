package org.eugens21.hostaway.technical_assignment.test.filter;

import org.eugens21.hostaway.technical_assignment.model.Amenities;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteria;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteriaActualContent;
import org.eugens21.hostaway.technical_assignment.nested_elements.search.popup.SearchPageFilterPopup;
import org.eugens21.hostaway.technical_assignment.pages.SearchPage;
import org.eugens21.hostaway.technical_assignment.service.FilterCriteriaActualMapperService;
import org.eugens21.hostaway.technical_assignment.service.FilterCriteriaExpectedMapperService;
import org.eugens21.hostaway.technical_assignment.service.RandomDateGeneratorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;

import java.util.stream.Stream;

public class SearchPageFilterAmenitiesTest extends AbstractTest {

    @Autowired
    FilterCriteriaExpectedMapperService mapperService;
    @Autowired
    FilterCriteriaActualMapperService actualResultsMapper;
    SearchPageFilterPopup filter;

    public static Stream<Amenities> positiveActualExpectedAmenitiesValues() {
        return Stream.of(
                Amenities.builder()
                        .isAirConditioning(true)
                        .isFreeWiFi(true)
                        .isKitchen(true)
                        .isStreetParking(true)
                        .isSwimmingPool(true)
                        .isBeachFront(true)
                        .isHotTub(true)
                        .isPetsAllowed(true)
                        .isSuitableForChildren(true)
                        .isWashingMachine(true)
                        .build(),
                Amenities.builder()
                        .isAirConditioning(true)
                        .isFreeWiFi(true)
                        .isKitchen(true)
                        .isStreetParking(true)
                        .isSwimmingPool(true)
                        .build(),
                Amenities.builder()
                        .isBeachFront(true)
                        .isHotTub(true)
                        .isPetsAllowed(true)
                        .isSuitableForChildren(true)
                        .isWashingMachine(true)
                        .build(),
                Amenities.builder().build()
        );
    }

    @BeforeEach
    public void goToFilter() {
        var criteria = RandomDateGeneratorService.get().generateRandomSearchPropertiesCriteria();
        SearchPage searchPage = homePage.withCriteria(criteria).searchProperties();
        filter = searchPage.toolbar().filter();
    }

    @ParameterizedTest
    @MethodSource("positiveActualExpectedAmenitiesValues")
    @DirtiesContext
    public void verifyCheckboxes(Amenities testData) {
        var expectedResult = mapperService.map(FilterCriteria.builder().amenities(testData).build());
        FilterCriteriaActualContent actualResult = filter.byCriteria(expectedResult).get();
        softAssertions.assertThat(actualResult)
                .extracting(actualResultsMapper::map)
                .extracting(FilterCriteria::getAmenities)
                .describedAs("Expecting to have valid toggle value applied")
                .usingRecursiveComparison()
                .ignoringFieldsOfTypes(Integer.class)
                .ignoringFields("price")
                .isEqualTo(testData);
    }

}
