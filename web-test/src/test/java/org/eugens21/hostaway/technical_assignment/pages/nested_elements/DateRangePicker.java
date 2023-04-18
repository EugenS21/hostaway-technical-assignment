package org.eugens21.hostaway.technical_assignment.pages.nested_elements;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.elements.implemenetation.Button;
import org.eugens21.hostaway.technical_assignment.properties.locators.common.DatePickerProperties;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.YearMonth;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DateRangePicker {

    DateRangeMonthPicker currentMonth;
    DateRangeMonthPicker futureMonth;
    Button clearDates;
    Button previousMonth;
    Button nextMonth;

    public DateRangePicker(DatePickerProperties datePicker, WebDriver webDriver) {
        this.currentMonth = new DateRangeMonthPicker(datePicker.getCurrentMonth(), webDriver);
        this.futureMonth = new DateRangeMonthPicker(datePicker.getFutureMonth(), webDriver);
        this.clearDates = new Button(datePicker.getClearDates(), webDriver);
        this.previousMonth = new Button(datePicker.getPreviousMonth(), webDriver);
        this.nextMonth = new Button(datePicker.getNextMonth(), webDriver);
    }

    private void selectDate(LocalDate localDate, DateRangeMonthPicker dateRangePickerToSelectDateFrom) {
        YearMonth expectedYearMonth = YearMonth.from(localDate);
        while (!dateRangePickerToSelectDateFrom.getYearMonthValue().equals(expectedYearMonth)) {
            nextMonth.click();
            while (dateRangePickerToSelectDateFrom.getYearMonthValue().compareTo(expectedYearMonth) > 0) {
                previousMonth.click();
            }
        }
        dateRangePickerToSelectDateFrom.selectDate(localDate.getDayOfMonth());
    }

    public void clearDates() {
        clearDates.click();
    }

    public void pickStartDate(LocalDate localDate) {
        selectDate(localDate, currentMonth);
    }

    public void pickEndDate(LocalDate localDate) {
        selectDate(localDate, futureMonth);
    }

}
