package org.eugens21.hostaway.technical_assignment.elements.implemenetation;

import org.eugens21.hostaway.technical_assignment.elements.AbstractWebElement;
import org.eugens21.hostaway.technical_assignment.elements.CheckBox;
import org.eugens21.hostaway.technical_assignment.properties.locators.search_page.SearchPageToolbarFilterPopupAmenitiesCheckBoxProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

import static java.util.Objects.nonNull;

public class InputCheckBox extends AbstractWebElement implements CheckBox {

    Supplier<WebElement> value;

    public InputCheckBox(SearchPageToolbarFilterPopupAmenitiesCheckBoxProperties byProvidedStrategy, WebDriver webDriver) {
        super(byProvidedStrategy.getCheckbox(), webDriver);
        this.value = () -> webDriver.findElement(byProvidedStrategy.getValue());
    }

    @Override
    public Boolean isChecked() {
        return value.get().getAttribute("checked") != null;
    }

    @Override
    public void changeState(Boolean stateToChange) {
        if (nonNull(stateToChange) && !isChecked().equals(stateToChange)) {
            getWebElement().click();
        }
    }

}
