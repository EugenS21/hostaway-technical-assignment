package org.eugens21.hostaway.technical_assignment;

import org.eugens21.hostaway.technical_assignment.properties.CustomYamlProcessor;
import org.eugens21.hostaway.technical_assignment.properties.PageLocatorProperties;
import org.eugens21.hostaway.technical_assignment.properties.WebDriverProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@ComponentScan
@Configuration
@EnableConfigurationProperties({WebDriverProperties.class, PageLocatorProperties.class})
@PropertySources({
        @PropertySource(value = "classpath:driver-configurations.yml", factory = CustomYamlProcessor.class),
        @PropertySource(value = "classpath:page-element-locators.yml", factory = CustomYamlProcessor.class)
})
public class WebCoreConfiguration {
}
