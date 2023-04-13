package org.eugens21.hostaway.technical_assignment.nested_elements;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.elements.implemenetation.Button;
import org.eugens21.hostaway.technical_assignment.elements.implemenetation.Div;
import org.eugens21.hostaway.technical_assignment.properties.locators.common.DatePickerProperties;
import org.eugens21.hostaway.technical_assignment.service.DateRangePickerService;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DateRangePicker {

    DateRangePickerService dateRangePickerService = null;
    Div currentMonth;
    Div futureMonth;
    Button clearDates;
    Button previousMonth;
    Button nextMonth;

    public DateRangePicker(DatePickerProperties datePicker, WebDriver webDriver) {
        this.currentMonth = new Div(datePicker.getCurrentMonth().getValue(), webDriver);
        this.futureMonth = new Div(datePicker.getFutureMonth().getValue(), webDriver);
        this.clearDates = new Button(datePicker.getClearDates(), webDriver);
        this.previousMonth = new Button(datePicker.getPreviousMonth(), webDriver);
        this.nextMonth = new Button(datePicker.getNextMonth(), webDriver);
    }

    public void clearDates() {
        clearDates.click();
    }

    public void pickDate(LocalDate localDate) {

        dateRangePickerService.pickDate(localDate);
    }



}
