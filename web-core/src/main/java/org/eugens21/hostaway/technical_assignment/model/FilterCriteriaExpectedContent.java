package org.eugens21.hostaway.technical_assignment.model;

import lombok.*;
import org.apache.commons.lang3.Range;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class FilterCriteriaExpectedContent extends AbstractFilterContent {

    Range<?> price;

}
