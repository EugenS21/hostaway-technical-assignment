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
