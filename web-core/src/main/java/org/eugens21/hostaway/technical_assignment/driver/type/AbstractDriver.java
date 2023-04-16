package org.eugens21.hostaway.technical_assignment.driver.type;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.driver.ConfigurableWebDriver;
import org.eugens21.hostaway.technical_assignment.driver.WebDriverErrorHandler;
import org.eugens21.hostaway.technical_assignment.properties.WebDriverProperties;
import org.eugens21.hostaway.technical_assignment.properties.driver.WebDriverTimeoutsProperties;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.logging.Level;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class AbstractDriver<DRIVER extends RemoteWebDriver, OPTIONS extends AbstractDriverOptions> implements ConfigurableWebDriver<DRIVER> {

    WebDriverProperties webDriverProperties;

    public AbstractDriver(WebDriverProperties webDriverProperties) {
        this.webDriverProperties = webDriverProperties;
    }

    protected abstract DRIVER getDriver();

    protected abstract WebDriverManager getDriverManager();

    protected abstract OPTIONS getOptions();

    protected DRIVER getConfiguredDriver() {
        getDriverManager().setup();
        DRIVER driver = getDriver();
        WebDriverTimeoutsProperties timeouts = webDriverProperties.getTimeouts();
        driver.manage().window().setSize(webDriverProperties.getWindowSize());
        driver.manage().timeouts().implicitlyWait(timeouts.getImplicit());
        driver.manage().timeouts().pageLoadTimeout(timeouts.getPageLoad());
        driver.manage().timeouts().scriptTimeout(timeouts.getScript());
        driver.setErrorHandler(new WebDriverErrorHandler());
        driver.setLogLevel(Level.OFF);
        return driver;
    }

    protected OPTIONS getCapabilities() {
        OPTIONS options = getOptions();
        WebDriverTimeoutsProperties timeouts = webDriverProperties.getTimeouts();
        options.setImplicitWaitTimeout(timeouts.getImplicit());
        options.setPageLoadTimeout(timeouts.getPageLoad());
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.setScriptTimeout(timeouts.getScript());
        return options;
    }


}
