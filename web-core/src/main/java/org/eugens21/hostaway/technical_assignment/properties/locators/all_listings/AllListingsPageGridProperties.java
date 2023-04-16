package org.eugens21.hostaway.technical_assignment.properties.locators.all_listings;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.properties.locators.AbstractElementProperty;
import org.openqa.selenium.By;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class AllListingsPageGridProperties extends AbstractElementProperty {

    @NestedConfigurationProperty
    AllListingsPageGridItemProperties item;
    By properties;

}
