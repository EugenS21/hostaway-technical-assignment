package org.eugens21.hostaway.technical_assignment;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(WebCoreConfiguration.class)
@ComponentScan
public class WebTestsBaseClass {
}
