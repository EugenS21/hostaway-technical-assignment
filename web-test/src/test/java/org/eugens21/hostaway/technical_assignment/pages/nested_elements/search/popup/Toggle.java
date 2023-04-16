package org.eugens21.hostaway.technical_assignment.pages.nested_elements.search.popup;

import org.eugens21.hostaway.technical_assignment.elements.implemenetation.Button;
import org.eugens21.hostaway.technical_assignment.elements.implemenetation.Span;
import org.eugens21.hostaway.technical_assignment.exceptions.IllegalToggleValueException;
import org.eugens21.hostaway.technical_assignment.properties.locators.search_page.SearchPageToolbarFilterPopupSpecificationsToggleProperties;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

import static java.lang.String.format;
import static org.eugens21.hostaway.technical_assignment.constant.ErrorMessageConstants.INVALID_TOGGLE_RANGE_VALUE;

public class Toggle {

    Button increase;
    Button decrease;
    Span value;

    public Toggle(SearchPageToolbarFilterPopupSpecificationsToggleProperties toggleProperties, WebDriver webDriver) {
        this.increase = new Button(toggleProperties.getAdd(), webDriver);
        this.decrease = new Button(toggleProperties.getSubtract(), webDriver);
        this.value = new Span(toggleProperties.getValue(), webDriver);
    }

    public Integer getValue() {
        return Integer.parseInt(value.getValue());
    }

    public void setValue(Integer valueToSet) {
        if (Objects.isNull(valueToSet))
            return;
        while (!valueToSet.equals(getValue())) {
            while (getValue().compareTo(valueToSet) > 0) {
                if (!decrease.isEnabled()) {
                    throw new IllegalToggleValueException(format(INVALID_TOGGLE_RANGE_VALUE, valueToSet, getValue()));
                }
                decrease.click();
            }
            if (!increase.isEnabled()) {
                throw new IllegalToggleValueException(format(INVALID_TOGGLE_RANGE_VALUE, valueToSet, getValue()));
            }
            increase.click();
        }
    }

}
