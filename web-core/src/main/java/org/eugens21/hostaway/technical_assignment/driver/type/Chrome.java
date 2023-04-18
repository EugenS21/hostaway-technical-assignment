package org.eugens21.hostaway.technical_assignment.driver.type;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.eugens21.hostaway.technical_assignment.properties.WebDriverProperties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class Chrome extends AbstractDriver<ChromeDriver, ChromeOptions> {

    WebDriverProperties properties;

    @Autowired
    public Chrome(WebDriverProperties properties) {
        super(properties);
        this.properties = properties;
        log.info("Configure chrome instance with properties {}", properties);
    }

    @Override
    public ChromeDriver get() {
        return getConfiguredDriver();
    }

    @Override
    protected WebDriverManager getDriverManager() {
        return WebDriverManager.chromedriver();
    }

    @Override
    protected ChromeOptions getOptions() {
        return new ChromeOptions().addArguments(properties.getCapabilities());
    }

    @Override
    protected ChromeDriver getDriver() {
        return new ChromeDriver(getCapabilities());
    }
}
