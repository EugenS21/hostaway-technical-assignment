package org.eugens21.hostaway.technical_assignment.elements;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class AbstractWebElement {

    Supplier<WebElement> webElement;

    public AbstractWebElement(By byProvidedStrategy, WebDriver webDriver) {
        this.webElement = () -> webDriver.findElement(byProvidedStrategy);
    }

    protected WebElement getWebElement() {
        return webElement.get();
    }

    public String getText() {
        return getWebElement().getText();
    }

    public boolean isVisible() {
        return getWebElement().isDisplayed();
    }

    public Boolean isAccessible() {
        return getWebElement().isEnabled();
    }

}
