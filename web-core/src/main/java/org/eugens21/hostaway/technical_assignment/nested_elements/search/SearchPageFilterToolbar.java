package org.eugens21.hostaway.technical_assignment.nested_elements.search;

import org.eugens21.hostaway.technical_assignment.elements.implemenetation.Button;
import org.eugens21.hostaway.technical_assignment.properties.locators.search_page.SearchPageToolbarProperties;
import org.openqa.selenium.WebDriver;

public class SearchPageFilterToolbar {

    Button filter;
    SearchPageFilterPopup searchPageFilterPopup;

    public SearchPageFilterToolbar(SearchPageToolbarProperties filterToolbarProperties, WebDriver webDriver) {
        this.filter = new Button(filterToolbarProperties.getFilter().getButton(), webDriver);
        this.searchPageFilterPopup = new SearchPageFilterPopup(filterToolbarProperties.getFilter().getPopup(), webDriver);
    }

    public SearchPageFilterPopup filter() {
        filter.click();
        return searchPageFilterPopup;
    }

}