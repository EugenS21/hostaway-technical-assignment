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

    Range<?> price;
    Integer beds;
    Integer bedrooms;
    Integer bathrooms;
    Amenities amenities;

}
