package org.eugens21.hostaway.technical_assignment.pages;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.configuration.AbstractPageDependencies;
import org.eugens21.hostaway.technical_assignment.properties.PageLocatorProperties;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
@RequiredArgsConstructor
public abstract class AbstractPage {

    ApplicationContext applicationContext;
    PageLocatorProperties pageLocatorProperties;
    WebDriver webDriver;

    protected AbstractPage(AbstractPageDependencies dependencies) {
        this.applicationContext = dependencies.getApplicationContext();
        this.pageLocatorProperties = dependencies.getPageLocatorProperties();
        this.webDriver = dependencies.getWebDriver();
    }

    protected <T> T getPage(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

}
