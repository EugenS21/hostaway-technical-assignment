package org.eugens21.hostaway.technical_assignment.driver.type;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.eugens21.hostaway.technical_assignment.driver.ConfigurableWebDriver;
import org.eugens21.hostaway.technical_assignment.properties.WebDriverProperties;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class Chrome implements ConfigurableWebDriver {

    @Getter
    WebDriverManager webDriverManager;
    @Getter
    ChromeOptions driverOptions;

    @Autowired
    public Chrome(WebDriverProperties properties) {
        log.info("Configure chrome instance with capabilities {}", properties.getCapabilities());
        this.driverOptions = new ChromeOptions().addArguments(properties.getCapabilities())
                .addArguments("timeouts", "{implicit:30000}");
        this.webDriverManager = WebDriverManager.chromedriver();
    }

    @Override
    public WebDriver get() {
        webDriverManager.setup();
        log.info("Configure chrome instance with timeouts {}", 10);
        ChromeDriver chromeDriver = new ChromeDriver(driverOptions);
        chromeDriver.manage().window().setSize(new Dimension(1920, 1200));
        chromeDriver.manage().timeouts().implicitlyWait(Duration.of(10, SECONDS));
        chromeDriver.manage().timeouts().pageLoadTimeout(Duration.of(10, SECONDS));
        chromeDriver.manage().timeouts().setScriptTimeout(Duration.of(10, SECONDS));
        return chromeDriver;
    }

}
