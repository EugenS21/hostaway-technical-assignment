package org.eugens21.hostaway.technical_assignment.model;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsExclude;

import java.util.List;

@Data
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SearchGridItemContent {

    @EqualsExclude
    String imageSrc;
    String name;
    Integer guests;
    Integer bedrooms;
    Integer bathrooms;
    MonetaryAmount price;
    List<String> amenities;

}
