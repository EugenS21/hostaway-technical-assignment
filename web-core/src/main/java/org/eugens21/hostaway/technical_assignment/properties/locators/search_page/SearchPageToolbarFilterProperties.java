package org.eugens21.hostaway.technical_assignment.properties.locators.search_page;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.By;
import org.springframework.boot.context.properties.NestedConfigurationProperty;


@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class SearchPageToolbarFilterProperties {

    By button;
    @NestedConfigurationProperty
    SearchPageToolbarFilterPopupProperties popup;

}
