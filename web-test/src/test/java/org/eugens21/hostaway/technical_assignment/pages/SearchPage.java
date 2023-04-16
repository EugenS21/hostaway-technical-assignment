package org.eugens21.hostaway.technical_assignment.pages;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.configuration.AbstractPageDependencies;
import org.eugens21.hostaway.technical_assignment.nested_elements.search.SearchPageToolbar;
import org.eugens21.hostaway.technical_assignment.nested_elements.search.grid.SearchPageGrid;
import org.eugens21.hostaway.technical_assignment.nested_elements.search.pagination.SearchPagePagination;
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

    public SearchPageToolbar toolbar() {
        return filterToolbar;
    }

    public SearchPageGrid grid() {
        return searchPageGrid;
    }

    public SearchPagePagination pagination() {
        return searchPagePagination;
    }

}
