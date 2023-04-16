package org.eugens21.hostaway.technical_assignment.pages;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.configuration.AbstractPageDependencies;
import org.eugens21.hostaway.technical_assignment.nested_elements.search.grid.AllListingsPageGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AllListingsPage extends AbstractPage {

    AllListingsPageGrid allListingsPageGrid;

    @Autowired
    public AllListingsPage(AbstractPageDependencies dependencies) {
        super(dependencies);
        this.allListingsPageGrid = new AllListingsPageGrid(pageLocatorProperties.getListings().getGrid(), webDriver);
    }

    public AllListingsPage open() {
        header.allListings();
        return this;
    }

    public AllListingsPageGrid grid() {
        return allListingsPageGrid;
    }

}
