package org.eugens21.hostaway.technical_assignment.nested_elements;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.elements.implemenetation.Button;
import org.eugens21.hostaway.technical_assignment.model.SearchFormContent;
import org.eugens21.hostaway.technical_assignment.properties.PageLocatorProperties;
import org.openqa.selenium.WebDriver;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SearchForm {

    Button search;
    Button checkIn;
    Button checkOut;
    DateRangePicker dateRangePicker;

    public SearchForm(PageLocatorProperties pageLocatorProperties, WebDriver webDriver) {
        search = new Button(pageLocatorProperties.getHome().getSearchForm().getDetails().getSearch(), webDriver);
        checkIn = new Button(pageLocatorProperties.getHome().getSearchForm().getDetails().getCheckIn(), webDriver);
        checkOut = new Button(pageLocatorProperties.getHome().getSearchForm().getDetails().getCheckOut(), webDriver);
        dateRangePicker = new DateRangePicker(pageLocatorProperties.getCommon().getDatePicker(), webDriver);
    }

    public void fill(SearchFormContent searchFormContent) {
        checkIn.click();
        dateRangePicker.pickStartDate(searchFormContent.getCheckInDate());
        dateRangePicker.pickEndDate(searchFormContent.getCheckOutDate());
    }

    public void search() {
        search.click();
    }

}
