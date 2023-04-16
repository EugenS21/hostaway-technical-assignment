package org.eugens21.hostaway.technical_assignment.properties.locators;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.properties.locators.all_listings.AllListingsPageGridProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ListingsPageProperties extends AbstractPageProperties {

    @NestedConfigurationProperty
    AllListingsPageGridProperties grid;

}
