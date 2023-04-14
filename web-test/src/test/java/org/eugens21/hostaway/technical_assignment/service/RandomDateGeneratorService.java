package org.eugens21.hostaway.technical_assignment.service;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.tuple.Pair;
import org.eugens21.hostaway.technical_assignment.model.Amenities;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteria;
import org.eugens21.hostaway.technical_assignment.model.SearchPropertiesCriteria;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
@RequiredArgsConstructor
public class RandomDateGeneratorService {

    Faker faker;

    private Integer randomDigit() {
        return faker.number().randomDigitNotZero() + 1;
    }

    public Pair<BigDecimal, BigDecimal> generatePriceInterval() {
        return Pair.of(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));
    }

    private Boolean getRandomBoolean() {
        return faker.bool().bool();
    }

    private Pair<LocalDate, LocalDate> generateDateInterval() {
        LocalDate today = LocalDate.now().plusMonths(faker.number().randomDigit());
        LocalDate endDate = today.plusDays(faker.number().numberBetween(1, 100));
        return Pair.of(today, endDate);
    }

    public SearchPropertiesCriteria generateRandomSearchPropertiesCriteria() {
        return SearchPropertiesCriteria.builder()
                .checkInAndOutDates(generateDateInterval())
                .build();
    }

    public Amenities generateRandomAmenities() {
        return Amenities.builder()
                .hasAirConditioning(getRandomBoolean())
                .hasBeachFront(getRandomBoolean())
                .hasFreeWiFi(getRandomBoolean())
                .hasHotTub(getRandomBoolean())
                .hasKitchen(getRandomBoolean())
                .hasPetsAllowed(getRandomBoolean())
                .hasStreetParking(getRandomBoolean())
                .hasSuitableForChildren(getRandomBoolean())
                .hasSwimmingPool(getRandomBoolean())
                .hasWashingMachine(getRandomBoolean())
                .build();
    }

    public FilterCriteria generateRandomFilterCriteria() {
        return FilterCriteria.builder()
                .beds(randomDigit())
                .bathrooms(randomDigit())
                .bedrooms(randomDigit())
                .amenities(generateRandomAmenities())
                .build();
    }

}
