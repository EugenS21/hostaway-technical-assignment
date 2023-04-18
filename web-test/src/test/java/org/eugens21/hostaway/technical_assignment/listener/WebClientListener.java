package org.eugens21.hostaway.technical_assignment.listener;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.List;

@Slf4j
public class WebClientListener implements WebDriverListener {

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        log.debug("Trying to find element by locator {}", locator);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        log.debug("Found element {} by locator {}", result, locator);
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        log.debug("Trying to find elements by locator {}", locator);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        log.debug("Found elements {} by locator {}", result, locator);
    }

    @Override
    public void beforeExecuteScript(WebDriver driver, String script, Object[] args) {
        log.debug("Executing js script {} with arguments {}", script, args);
    }

    @Override
    public void afterExecuteScript(WebDriver driver, String script, Object[] args, Object result) {
        log.debug("The result of js script execution {} with arguments {} is {}", script, args, result);
    }

    @Override
    public void beforeClick(WebElement element) {
        log.debug("Clicking on element {}", element);
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        log.debug("Sending {} to element {}", keysToSend, element);
    }

    @Override
    public void beforeClear(WebElement element) {
        log.debug("Clearing content of the element {}", element);
    }

    @Override
    public void beforeGetAttribute(WebElement element, String name) {
        log.debug("Getting attribute {} of the element {}", name, element);
    }

    @Override
    public void beforeGetText(WebElement element) {
        log.debug("Getting text of the element {}", element);
    }

}
