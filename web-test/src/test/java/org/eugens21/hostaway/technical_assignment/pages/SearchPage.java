package org.eugens21.hostaway.technical_assignment.pages;

import io.qameta.allure.Step;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.configuration.AbstractPageDependencies;
import org.eugens21.hostaway.technical_assignment.pages.nested_elements.search.SearchPageToolbar;
import org.eugens21.hostaway.technical_assignment.pages.nested_elements.search.grid.SearchPageGrid;
import org.eugens21.hostaway.technical_assignment.pages.nested_elements.search.pagination.SearchPagePagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SearchPage extends AbstractPage {

    SearchPageToolbar filterToolbar;
    SearchPageGrid searchPageGrid;
    SearchPagePagination searchPagePagination;

    @Autowired
    public SearchPage(AbstractPageDependencies dependencies) {
        super(dependencies);
        this.filterToolbar = new SearchPageToolbar(pageLocatorProperties.getSearch().getToolbar(), webDriver);
        this.searchPageGrid = new SearchPageGrid(pageLocatorProperties.getSearch().getGrid(), webDriver);
        this.searchPagePagination = new SearchPagePagination(pageLocatorProperties.getSearch().getPagination(), webDriver);
    }

    public String getExpectedUrl() {
        return pageLocatorProperties.getSearch().getUrl();
    }

    @Step("On search page toolbar")
    public SearchPageToolbar toolbar() {
        return filterToolbar;
    }

    @Step("On search page grid")
    public SearchPageGrid grid() {
        return searchPageGrid;
    }

    @Step("On search page pagination")
    public SearchPagePagination pagination() {
        return searchPagePagination;
    }

}
