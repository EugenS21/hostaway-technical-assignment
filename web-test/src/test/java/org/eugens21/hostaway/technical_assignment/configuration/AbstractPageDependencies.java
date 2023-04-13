package org.eugens21.hostaway.technical_assignment.configuration;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.properties.PageLocatorProperties;
import org.modelmapper.ModelMapper;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Component
@Getter
@FieldDefaults(makeFinal = true, level = PRIVATE)
@RequiredArgsConstructor
public class AbstractPageDependencies {

    ApplicationContext applicationContext;
    PageLocatorProperties pageLocatorProperties;
    WebDriver webDriver;

}
