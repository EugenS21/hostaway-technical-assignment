package org.eugens21.hostaway.technical_assignment.properties.locators.common;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class CommonPageProperties {

    @NestedConfigurationProperty
    DatePickerProperties datePicker;


}
