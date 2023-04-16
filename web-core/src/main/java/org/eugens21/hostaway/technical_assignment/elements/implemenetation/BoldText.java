package org.eugens21.hostaway.technical_assignment.elements.implemenetation;

import lombok.extern.slf4j.Slf4j;
import org.eugens21.hostaway.technical_assignment.elements.AbstractWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Slf4j
public class BoldText extends AbstractWebElement implements org.eugens21.hostaway.technical_assignment.elements.Div {

    public BoldText(By search, WebDriver webDriver) {
        super(search, webDriver);
    }

    @Override
    public void select() {
        log.debug("Clicking on the element");
        getWebElement().click();
    }

}
