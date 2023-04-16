package org.eugens21.hostaway.technical_assignment.nested_elements;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.elements.implemenetation.Link;
import org.eugens21.hostaway.technical_assignment.properties.locators.PageHeaderProperties;
import org.openqa.selenium.WebDriver;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class PageHeader {

    Link allListings;

    public PageHeader(PageHeaderProperties pageHeaderProperties, WebDriver webDriver) {
        this.allListings = new Link(pageHeaderProperties.getAllListings(), webDriver);
    }

    public void allListings() {
        allListings.open();
    }

}
