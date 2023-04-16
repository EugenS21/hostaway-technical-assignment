package org.eugens21.hostaway.technical_assignment.model;

import lombok.*;

import java.util.List;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AllListingsGridItemContent {

    String name;
    Integer guests;
    Integer bedrooms;
    Integer bathrooms;
    List<String> amenities;

}
