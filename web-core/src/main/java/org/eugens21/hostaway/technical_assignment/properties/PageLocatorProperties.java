package org.eugens21.hostaway.technical_assignment.properties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.properties.locators.HomePageProperties;
import org.eugens21.hostaway.technical_assignment.properties.locators.ListingsPageProperties;
import org.eugens21.hostaway.technical_assignment.properties.locators.PageHeaderProperties;
import org.eugens21.hostaway.technical_assignment.properties.locators.SearchPageProperties;
import org.eugens21.hostaway.technical_assignment.properties.locators.common.CommonPageProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import static lombok.AccessLevel.PRIVATE;
import static org.eugens21.hostaway.technical_assignment.constant.PropertiesConstants.PAGE_LOCATOR_ROOT_NODE;

@Data
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@ConfigurationProperties(prefix = PAGE_LOCATOR_ROOT_NODE)
public class PageLocatorProperties {

    @NestedConfigurationProperty
    CommonPageProperties common;
    @NestedConfigurationProperty
    PageHeaderProperties header;
    @NestedConfigurationProperty
    HomePageProperties home;
    @NestedConfigurationProperty
    SearchPageProperties search;
    @NestedConfigurationProperty
    ListingsPageProperties listings;

}
