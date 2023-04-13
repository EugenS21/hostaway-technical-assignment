package org.eugens21.hostaway.technical_assignment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
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
