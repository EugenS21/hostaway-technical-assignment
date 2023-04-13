package org.eugens21.hostaway.technical_assignment;

import org.eugens21.hostaway.technical_assignment.driver.WebDriversFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(WebCoreConfiguration.class)
@ComponentScan
public class WebTestsBaseClass {

    @Bean
    public WebDriver getWebDriver(WebDriversFactory webDriversFactory) {
        return webDriversFactory.create().get();
    }

}
