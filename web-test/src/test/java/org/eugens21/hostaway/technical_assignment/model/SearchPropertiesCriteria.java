package org.eugens21.hostaway.technical_assignment.model;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.Range;
import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
public class SearchPropertiesCriteria {

    String location;
    Pair<LocalDate, LocalDate> checkInAndOutDates;
    Long guests;
    Boolean hasAirConditioning;
    Boolean hasBreakfastIncluded;
    Boolean has24HourCheckIn;
    Boolean hasBalcony;
    Boolean hasBeachEssentials;

}
