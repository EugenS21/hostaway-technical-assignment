package org.eugens21.hostaway.technical_assignment.service;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
@RequiredArgsConstructor
public class RandomDateGeneratorService {

    Faker faker;

    public Pair<LocalDate, LocalDate> generateDateInterval() {
        LocalDate today = LocalDate.now().plusMonths(faker.number().randomDigit());
        LocalDate endDate = today.plusDays(faker.number().numberBetween(1, 100));
        return Pair.of(today, endDate);
    }

}
