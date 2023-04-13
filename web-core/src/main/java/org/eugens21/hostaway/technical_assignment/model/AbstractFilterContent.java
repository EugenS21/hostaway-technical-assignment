package org.eugens21.hostaway.technical_assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractFilterContent {

    Integer beds;
    Integer bedrooms;
    Integer bathrooms;
    Boolean isBeachFront;
    Boolean isSwimmingPool;
    Boolean isFreeWiFi;
    Boolean isKitchen;
    Boolean isAirConditioning;
    Boolean isWashingMachine;
    Boolean isPetsAllowed;
    Boolean isHotTub;
    Boolean isStreetParking;
    Boolean isSuitableForChildren;

}
