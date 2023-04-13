package org.eugens21.hostaway.technical_assignment.model;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class SearchFormContent {

    String location;
    LocalDate checkInDate;
    LocalDate checkOutDate;
    Long guests;
    Boolean hasAirConditioning;
    Boolean hasBreakfastIncluded;
    Boolean has24HourCheckIn;
    Boolean hasBalcony;
    Boolean hasBeachEssentials;

}
