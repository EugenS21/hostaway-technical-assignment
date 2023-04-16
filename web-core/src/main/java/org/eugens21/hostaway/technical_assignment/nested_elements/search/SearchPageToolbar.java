package org.eugens21.hostaway.technical_assignment.nested_elements.search;

import io.qameta.allure.Step;
import org.eugens21.hostaway.technical_assignment.elements.implemenetation.Button;
import org.eugens21.hostaway.technical_assignment.nested_elements.search.popup.SearchPageFilterPopup;
import org.eugens21.hostaway.technical_assignment.properties.locators.search_page.SearchPageToolbarProperties;
import org.openqa.selenium.WebDriver;

public class SearchPageToolbar {

    Button filter;
    SearchPageFilterPopup searchPageFilterPopup;

    public SearchPageToolbar(SearchPageToolbarProperties filterToolbarProperties, WebDriver webDriver) {
        this.filter = new Button(filterToolbarProperties.getFilter().getButton(), webDriver);
        this.searchPageFilterPopup = new SearchPageFilterPopup(filterToolbarProperties.getFilter().getPopup(), webDriver);
    }

    @Step("Click filter button from the toolbar")
    public SearchPageFilterPopup filter() {
        filter.click();
        return searchPageFilterPopup;
    }

}