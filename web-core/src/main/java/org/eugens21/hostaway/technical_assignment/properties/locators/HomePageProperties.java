package org.eugens21.hostaway.technical_assignment.properties.locators;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.properties.locators.home_page.SearchFormProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class HomePageProperties extends AbstractPageProperties {

    @NestedConfigurationProperty
    SearchFormProperties searchForm;

}
