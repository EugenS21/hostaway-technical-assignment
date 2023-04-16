package org.eugens21.hostaway.technical_assignment.properties.locators.search_page;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.properties.locators.AbstractElementProperty;
import org.openqa.selenium.By;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.function.Function;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class SearchPageGridItemProperties extends AbstractElementProperty {

    Function<Integer, By> image;
    Function<Integer, By> name;
    Function<Integer, By> guests;
    Function<Integer, By> bedroom;
    Function<Integer, By> bath;
    Function<Integer, By> price;
    @NestedConfigurationProperty
    SearchPageGridItemAmenitiesProperties amenities;

}
