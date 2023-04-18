package org.eugens21.hostaway.technical_assignment.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.enums.DriverTypeEnum;
import org.eugens21.hostaway.technical_assignment.properties.driver.WebDriverTimeoutsProperties;
import org.openqa.selenium.Dimension;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.eugens21.hostaway.technical_assignment.constant.PropertiesConstants.WEB_DRIVER_CONFIGURATION_ROOT_NODE;

@Data
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
@ConfigurationProperties(prefix = WEB_DRIVER_CONFIGURATION_ROOT_NODE)
@ToString
public class WebDriverProperties {

    DriverTypeEnum type;
    Dimension windowSize;
    @NestedConfigurationProperty
    WebDriverTimeoutsProperties timeouts;
    List<String> capabilities;

}
