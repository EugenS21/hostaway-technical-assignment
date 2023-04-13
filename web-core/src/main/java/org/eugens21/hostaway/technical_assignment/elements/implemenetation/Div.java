package org.eugens21.hostaway.technical_assignment.elements.implemenetation;

import org.eugens21.hostaway.technical_assignment.elements.AbstractWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Div extends AbstractWebElement implements org.eugens21.hostaway.technical_assignment.elements.Div {

    public Div(By search, WebDriver webDriver) {
        super(search, webDriver);
    }

    @Override
    public void select() {
        getWebElement().click();
    }

}
