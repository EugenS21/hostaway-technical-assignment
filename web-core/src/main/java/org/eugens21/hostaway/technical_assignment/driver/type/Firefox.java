package org.eugens21.hostaway.technical_assignment.driver.type;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.eugens21.hostaway.technical_assignment.properties.WebDriverProperties;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Autowired;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class Firefox extends AbstractDriver<FirefoxDriver, FirefoxOptions> {

    WebDriverProperties properties;

    @Autowired
    public Firefox(WebDriverProperties properties) {
        super(properties);
        this.properties = properties;
        log.info("Configure firefox instance with capabilities {}", properties.getCapabilities());
    }

    @Override
    public FirefoxDriver get() {
        return getConfiguredDriver();
    }

    @Override
    protected WebDriverManager getDriverManager() {
        return WebDriverManager.chromedriver();
    }

    @Override
    protected FirefoxOptions getOptions() {
        return new FirefoxOptions().addArguments(properties.getCapabilities());
    }

    @Override
    protected FirefoxDriver getDriver() {
        return new FirefoxDriver(getCapabilities());
    }
}
