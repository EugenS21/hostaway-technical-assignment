package org.eugens21.hostaway.technical_assignment.pages.nested_elements.search.popup;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.elements.implemenetation.NumberInput;
import org.eugens21.hostaway.technical_assignment.properties.locators.search_page.SearchPageToolbarFilterPopupSpecificationsInputRangeProperties;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Represents a numeric range defined by two number inputs: a "from" input and a "to" input.
 * Where from and to represents UI price values
 */
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class Range {

    NumberInput from;
    NumberInput to;

    public Range(SearchPageToolbarFilterPopupSpecificationsInputRangeProperties rangeProperties, WebDriver webDriver) {
        this.from = new NumberInput(rangeProperties.getFrom(), webDriver);
        this.to = new NumberInput(rangeProperties.getTo(), webDriver);
    }

    public RangeSetter set() {
        return new RangeSetter();
    }

    public RangeGetter get() {
        return new RangeGetter();
    }

    public class RangeSetter {

        public <T> void range(org.apache.commons.lang3.Range<T> range) {
            if (Objects.isNull(range))
                return;
            if (range.getMaximum() instanceof BigDecimal) {
                from.clear();
                from.input(((BigDecimal) range.getMinimum()));
                to.clear();
                to.input(((BigDecimal) range.getMaximum()));
            } else {
                to.clear();
                to.invalidInput(range.getMaximum().toString());
                from.clear();
                from.invalidInput(range.getMinimum().toString());
            }
        }

    }

    public class RangeGetter {

        public org.apache.commons.lang3.Range<BigDecimal> range() {
            return org.apache.commons.lang3.Range.between(from.value(), to.value());

        }

    }

}

