package org.eugens21.hostaway.technical_assignment.elements.implemenetation;

import org.eugens21.hostaway.technical_assignment.elements.AbstractWebElement;
import org.eugens21.hostaway.technical_assignment.elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.math.BigDecimal;

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
        return new BigDecimal(getAttribute("value"));
    }
}
