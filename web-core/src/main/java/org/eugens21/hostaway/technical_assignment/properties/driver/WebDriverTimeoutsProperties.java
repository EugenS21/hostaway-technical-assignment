package org.eugens21.hostaway.technical_assignment.properties.driver;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.Duration;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class WebDriverTimeoutsProperties {

    Duration implicit;
    Duration pageLoad;
    Duration script;

}
