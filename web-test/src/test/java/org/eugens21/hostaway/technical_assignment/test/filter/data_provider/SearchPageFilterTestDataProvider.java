package org.eugens21.hostaway.technical_assignment.test.filter.data_provider;

import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.tuple.Pair;
import org.eugens21.hostaway.technical_assignment.model.Amenities;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteria;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteriaActualContent;
import org.testng.annotations.DataProvider;

import java.math.BigDecimal;

public class SearchPageFilterTestDataProvider {

    @DataProvider
    //    FIXME add a test with big number and send back space - a bug there
    public Object[] actualExpectedPriceValues() {
        return new Object[]{
                Pair.of(FilterCriteria.builder().price(Range.between("1+2-3/1", "2!3*1=3")).build(), Range.between(BigDecimal.valueOf(1231), BigDecimal.valueOf(2313))),
                Pair.of(FilterCriteria.builder().price(Range.between("-7", "-8")).build(), Range.between(BigDecimal.valueOf(7), BigDecimal.valueOf(8))),
                Pair.of(FilterCriteria.builder().price(Range.between("1-7.0a5b3", "b1a9s7d-8%.1")).build(), Range.between(BigDecimal.valueOf(17053), BigDecimal.valueOf(19781))),
                Pair.of(FilterCriteria.builder().price(Range.between("561", "82")).build(), Range.between(BigDecimal.valueOf(561), BigDecimal.valueOf(566)))
        };
    }

    @DataProvider
    public Object[] positiveActualExpectedToggleValues() {
        return new Object[]{
                Pair.of(FilterCriteria.builder().beds(0).build(), FilterCriteriaActualContent.builder().beds(0).build()),
                Pair.of(FilterCriteria.builder().beds(2).build(), FilterCriteriaActualContent.builder().beds(2).build()),
                Pair.of(FilterCriteria.builder().beds(10).build(), FilterCriteriaActualContent.builder().beds(10).build()),
                Pair.of(FilterCriteria.builder().bedrooms(0).build(), FilterCriteriaActualContent.builder().bedrooms(0).build()),
                Pair.of(FilterCriteria.builder().bedrooms(3).build(), FilterCriteriaActualContent.builder().bedrooms(3).build()),
                Pair.of(FilterCriteria.builder().bedrooms(10).build(), FilterCriteriaActualContent.builder().bedrooms(10).build()),
                Pair.of(FilterCriteria.builder().bathrooms(0).build(), FilterCriteriaActualContent.builder().bathrooms(0).build()),
                Pair.of(FilterCriteria.builder().bathrooms(5).build(), FilterCriteriaActualContent.builder().bathrooms(5).build()),
                Pair.of(FilterCriteria.builder().bathrooms(10).build(), FilterCriteriaActualContent.builder().bathrooms(10).build())
        };
    }


    @DataProvider
    public Object[] negativeActualExpectedToggleValues() {
        return new Object[]{
                Pair.of(FilterCriteria.builder().beds(-14).build(), -14),
                Pair.of(FilterCriteria.builder().beds(20).build(), 20),
                Pair.of(FilterCriteria.builder().bedrooms(-1).build(), -1),
                Pair.of(FilterCriteria.builder().bedrooms(45).build(), 45),
                Pair.of(FilterCriteria.builder().bathrooms(-10).build(), -10),
                Pair.of(FilterCriteria.builder().bathrooms(20).build(), 20)
        };
    }

    @DataProvider
    public Object[] positiveActualExpectedAmenitiesValues() {
        return new Object[]{
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
        };
    }

    @DataProvider
    public Object[] criteriaToFilterBy() {
        return new Object[]{
                FilterCriteria.builder().bedrooms(2).bathrooms(1).build()
        };
    }

}
