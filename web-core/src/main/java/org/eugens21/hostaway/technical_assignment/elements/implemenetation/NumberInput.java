package org.eugens21.hostaway.technical_assignment.elements.implemenetation;

import org.eugens21.hostaway.technical_assignment.elements.AbstractWebElement;
import org.eugens21.hostaway.technical_assignment.elements.Input;
import org.eugens21.hostaway.technical_assignment.exceptions.InvalidNumberValueException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;
import java.util.Objects;

public class NumberInput extends AbstractWebElement implements Input<BigDecimal> {

    public NumberInput(By byProvidedStrategy, WebDriver webDriver) {
        super(byProvidedStrategy, webDriver);
    }

    @Override
    public void input(BigDecimal value) {
        getWebElement().sendKeys(value.toString());
    }

    @Override
    public void invalidInput(String value) {
        getWebElement().sendKeys(value);
    }

    @Override
    public BigDecimal value() {
        getWebElement().click();
        String value = getAttribute("value");
        if (Objects.isNull(value) || value.isEmpty()) {
            throw new InvalidNumberValueException("Can't parse numeric input empty value to a big decimal");
        }
        return new BigDecimal(value);
    }
}
