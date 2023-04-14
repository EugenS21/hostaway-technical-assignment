package org.eugens21.hostaway.technical_assignment.elements.implemenetation;

import org.eugens21.hostaway.technical_assignment.elements.AbstractWebElement;
import org.eugens21.hostaway.technical_assignment.elements.IHeader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends AbstractWebElement implements IHeader {

    public Header(By byProvidedStrategy, WebDriver webDriver) {
        super(byProvidedStrategy, webDriver);
    }

    @Override
    public String getValue() {
        return getText();
    }

    @Override
    public void click() {
        getWebElement().click();
    }

}
