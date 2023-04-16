package org.eugens21.hostaway.technical_assignment.elements;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public abstract class AbstractWebElement {

    Supplier<WebElement> webElement;
    WebDriverWait webDriverWait;

    public AbstractWebElement(By byProvidedStrategy, WebDriver webDriver) {
        this.webElement = () -> webDriver.findElement(byProvidedStrategy);
        this.webDriverWait = new WebDriverWait(webDriver, Duration.of(10, ChronoUnit.SECONDS));
    }

    protected WebElement getWebElement() {
        log.debug("Using element {}", webElement.get().getLocation());
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement.get()));
//        actions.scrollToElement(webElement.get());
        return webElement.get();
    }

    protected String getText() {
        return getWebElement().getText();
    }

    protected String getAttribute(String attribute) {
        return getWebElement().getAttribute(attribute);
    }

    protected boolean isVisible() {
        return getWebElement().isDisplayed();
    }

    protected Boolean isAccessible() {
        return getWebElement().isEnabled();
    }

}
