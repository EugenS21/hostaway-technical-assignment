package org.eugens21.hostaway.technical_assignment.elements.implemenetation;

import org.eugens21.hostaway.technical_assignment.elements.AbstractWebElement;
import org.eugens21.hostaway.technical_assignment.elements.IButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends AbstractWebElement implements IButton {

    public Button(By search, WebDriver webDriver) {
        super(search, webDriver);
    }

    @Override
    public void click() {
        getWebElement().click();
    }

}
