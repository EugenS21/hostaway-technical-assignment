package org.eugens21.hostaway.technical_assignment.elements.implemenetation;

import org.eugens21.hostaway.technical_assignment.elements.AbstractWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Image extends AbstractWebElement implements org.eugens21.hostaway.technical_assignment.elements.Image {

    public Image(By byProvidedStrategy, WebDriver searchContext) {
        super(byProvidedStrategy, searchContext);
    }

    @Override
    public String getSrc() {
        return getAttribute("src");
    }
}
