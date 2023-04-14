package org.eugens21.hostaway.technical_assignment.elements.implemenetation;

import org.eugens21.hostaway.technical_assignment.elements.AbstractWebElement;
import org.eugens21.hostaway.technical_assignment.elements.ISpan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Span extends AbstractWebElement implements ISpan {

    public Span(By byProvidedStrategy, WebDriver webDriver) {
        super(byProvidedStrategy, webDriver);
    }

    @Override
    public String getValue() {
        return getText();
    }

}
