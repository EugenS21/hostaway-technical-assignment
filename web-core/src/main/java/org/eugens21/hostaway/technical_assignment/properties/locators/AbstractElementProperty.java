package org.eugens21.hostaway.technical_assignment.properties.locators;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public abstract class AbstractElementProperty {

    String self;

}
