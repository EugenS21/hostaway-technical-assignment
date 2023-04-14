package org.eugens21.hostaway.technical_assignment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.Range;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class FilterCriteria {

    @Builder.Default
    Range<?> price = Range.between(500, 1000);
    Integer beds = 0;
    Integer bedrooms = 0;
    Integer bathrooms = 0;
    Amenities amenities;

}
