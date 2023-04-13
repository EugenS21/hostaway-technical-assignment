package org.eugens21.hostaway.technical_assignment.pages;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.configuration.AbstractPageDependencies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SearchPage extends AbstractPage {

    @Autowired
    public SearchPage(AbstractPageDependencies dependencies) {
        super(dependencies);
    }

    public String getExpectedUrl() {
        return pageLocatorProperties.getSearch().getUrl();
    }

}
