package org.eugens21.hostaway.technical_assignment.driver.type;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.eugens21.hostaway.technical_assignment.properties.WebDriverProperties;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.springframework.beans.factory.annotation.Autowired;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class Edge extends AbstractDriver<EdgeDriver, EdgeOptions> {

    WebDriverProperties properties;

    @Autowired
    public Edge(WebDriverProperties properties) {
        super(properties);
        this.properties = properties;
        log.info("Configure edge instance with capabilities {}", properties.getCapabilities());
    }

    @Override
    public EdgeDriver get() {
        return getConfiguredDriver();
    }

    @Override
    protected WebDriverManager getDriverManager() {
        return WebDriverManager.chromedriver();
    }

    @Override
    protected EdgeOptions getOptions() {
        return new EdgeOptions().addArguments(properties.getCapabilities());
    }

    @Override
    protected EdgeDriver getDriver() {
        return new EdgeDriver(getCapabilities());
    }
}
