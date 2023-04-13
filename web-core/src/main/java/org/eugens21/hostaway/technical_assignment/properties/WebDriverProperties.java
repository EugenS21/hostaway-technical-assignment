package org.eugens21.hostaway.technical_assignment.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.enums.DriverTypeEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.eugens21.hostaway.technical_assignment.constant.PropertiesConstants.WEB_DRIVER_CONFIGURATION_ROOT_NODE;

@Data
@FieldDefaults(level = PRIVATE)
@NoArgsConstructor
@ConfigurationProperties(prefix = WEB_DRIVER_CONFIGURATION_ROOT_NODE)
public class WebDriverProperties {

    DriverTypeEnum type;
    List<String> capabilities;

}
