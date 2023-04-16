package org.eugens21.hostaway.technical_assignment.elements.implemenetation;

import org.eugens21.hostaway.technical_assignment.elements.AbstractWebElement;
import org.eugens21.hostaway.technical_assignment.elements.Anchor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Link extends AbstractWebElement implements Anchor {

    public Link(By byProvidedStrategy, WebDriver webDriver) {
        super(byProvidedStrategy, webDriver);
    }

    @Override
    public void open() {
        getWebElement().click();
    }
}
