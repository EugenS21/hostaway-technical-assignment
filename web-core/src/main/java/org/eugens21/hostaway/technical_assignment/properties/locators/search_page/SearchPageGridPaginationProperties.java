package org.eugens21.hostaway.technical_assignment.properties.locators.search_page;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.properties.locators.AbstractElementProperty;
import org.openqa.selenium.By;

import java.util.function.Function;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class SearchPageGridPaginationProperties extends AbstractElementProperty {

    By next;
    By previous;
    Function<Integer, By> page;
    By pages;

}
