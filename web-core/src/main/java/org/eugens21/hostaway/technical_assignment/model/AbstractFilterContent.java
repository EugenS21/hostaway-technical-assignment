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
    boolean isBeachFront;
    boolean isSwimmingPool;
    boolean isFreeWiFi;
    boolean isKitchen;
    boolean isAirConditioning;
    boolean isWashingMachine;
    boolean isPetsAllowed;
    boolean isHotTub;
    boolean isStreetParking;
    boolean isSuitableForChildren;

}
