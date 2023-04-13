package org.eugens21.hostaway.technical_assignment.pages;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.configuration.AbstractPageDependencies;
import org.eugens21.hostaway.technical_assignment.model.SearchPropertiesCriteria;
import org.eugens21.hostaway.technical_assignment.nested_elements.search.SearchForm;
import org.eugens21.hostaway.technical_assignment.service.SearchPropertiesMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class HomePage extends AbstractPage {

    SearchForm searchForm;
    SearchPropertiesMapperService mapperService;

    @Autowired
    public HomePage(AbstractPageDependencies dependencies, SearchPropertiesMapperService mapperService) {
        super(dependencies);
        this.mapperService = mapperService;
        this.searchForm = new SearchForm(pageLocatorProperties, webDriver);
    }

    public HomePageRedirectOperations withCriteria(SearchPropertiesCriteria searchPropertiesCriteria) {
        searchForm.fill(mapperService.map(searchPropertiesCriteria));
        return new HomePageRedirectOperations();
    }

    public class HomePageRedirectOperations {

        public SearchPage searchProperties() {
            searchForm.search();
            return getPage(SearchPage.class);
        }

    }

}
