package org.eugens21.hostaway.technical_assignment;

import org.eugens21.hostaway.technical_assignment.driver.WebDriversFactory;
import org.eugens21.hostaway.technical_assignment.properties.CustomYamlProcessor;
import org.eugens21.hostaway.technical_assignment.properties.PageLocatorProperties;
import org.eugens21.hostaway.technical_assignment.properties.WebDriverProperties;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

@ComponentScan
@Configuration
@EnableConfigurationProperties({WebDriverProperties.class, PageLocatorProperties.class})
@PropertySources({
        @PropertySource(value = "classpath:driver-configurations.yml", factory = CustomYamlProcessor.class),
        @PropertySource(value = "classpath:page-element-locators.yml", factory = CustomYamlProcessor.class)
})
public class WebCoreConfiguration {

    @Bean
    public WebDriver getWebDriver(WebDriversFactory webDriversFactory) {
        return webDriversFactory.create().get();
    }

}
