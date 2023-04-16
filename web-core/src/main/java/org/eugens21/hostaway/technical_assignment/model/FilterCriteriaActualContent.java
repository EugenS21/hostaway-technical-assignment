package org.eugens21.hostaway.technical_assignment.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.Range;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class FilterCriteriaActualContent extends AbstractFilterContent {

    Range<BigDecimal> price;

}
