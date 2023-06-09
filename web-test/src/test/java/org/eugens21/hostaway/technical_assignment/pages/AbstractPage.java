package org.eugens21.hostaway.technical_assignment.pages;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.configuration.AbstractPageDependencies;
import org.eugens21.hostaway.technical_assignment.pages.nested_elements.PageHeader;
import org.eugens21.hostaway.technical_assignment.properties.PageLocatorProperties;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public abstract class AbstractPage {

    ApplicationContext applicationContext;
    PageHeader header;
    PageLocatorProperties pageLocatorProperties;
    WebDriver webDriver;

    protected AbstractPage(AbstractPageDependencies dependencies) {
        this.applicationContext = dependencies.getApplicationContext();
        this.pageLocatorProperties = dependencies.getPageLocatorProperties();
        this.webDriver = dependencies.getWebDriver();
        this.header = new PageHeader(pageLocatorProperties.getHeader(), webDriver);
    }

    protected <T> T getPage(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public String getCurrentPageUrl() {
        return webDriver.getCurrentUrl();
    }

}
