package org.eugens21.hostaway.technical_assignment.properties.locators;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.properties.locators.search_page.SearchPageGridPaginationProperties;
import org.eugens21.hostaway.technical_assignment.properties.locators.search_page.SearchPageGridProperties;
import org.eugens21.hostaway.technical_assignment.properties.locators.search_page.SearchPageToolbarProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class SearchPageProperties extends AbstractPageProperties {

    @NestedConfigurationProperty
    SearchPageToolbarProperties toolbar;
    @NestedConfigurationProperty
    SearchPageGridProperties grid;
    @NestedConfigurationProperty
    SearchPageGridPaginationProperties pagination;

}
