package org.eugens21.hostaway.technical_assignment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Amenities {

    Boolean hasBeachFront;
    Boolean hasSwimmingPool;
    Boolean hasFreeWiFi;
    Boolean hasKitchen;
    Boolean hasAirConditioning;
    Boolean hasWashingMachine;
    Boolean hasPetsAllowed;
    Boolean hasHotTub;
    Boolean hasStreetParking;
    Boolean hasSuitableForChildren;

}
