package org.eugens21.hostaway.technical_assignment.properties.locators.common;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.properties.locators.AbstractElementProperty;
import org.openqa.selenium.By;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class DatePickerMonthProperties extends AbstractElementProperty {

    By value;
    String dateToPick;

}
