package org.eugens21.hostaway.technical_assignment.elements;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.function.Supplier;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class AbstractWebElement {

    Actions actions;
    Supplier<WebElement> webElement;
    WebDriverWait webDriverWait;

    public AbstractWebElement(By byProvidedStrategy, WebDriver webDriver) {
        this.actions = new Actions(webDriver);
        this.webElement = () -> webDriver.findElement(byProvidedStrategy);
        this.webDriverWait = new WebDriverWait(webDriver, Duration.of(10, ChronoUnit.SECONDS));
    }

    protected WebElement getWebElement() {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement.get()));
//        actions.scrollToElement(webElement.get());
        return webElement.get();
    }

    public void scrollTo() {
        actions.scrollToElement(webElement.get());
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
