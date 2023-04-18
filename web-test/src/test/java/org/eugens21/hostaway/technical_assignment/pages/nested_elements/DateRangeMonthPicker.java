package org.eugens21.hostaway.technical_assignment.pages.nested_elements;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.elements.implemenetation.Div;
import org.eugens21.hostaway.technical_assignment.properties.locators.common.DatePickerMonthProperties;
import org.openqa.selenium.WebDriver;

import java.time.YearMonth;
import java.util.function.Function;

import static java.lang.String.format;
import static java.time.YearMonth.parse;
import static org.eugens21.hostaway.technical_assignment.constant.DateTimeConstants.YEAR_MONTH_DATE_FORMATTER;
import static org.openqa.selenium.By.xpath;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class DateRangeMonthPicker {

    Div month;
    Function<Integer, Div> dateToPick;

    public DateRangeMonthPicker(DatePickerMonthProperties monthProperties, WebDriver webDriver) {
        this.month = new Div(monthProperties.getValue(), webDriver);
        this.dateToPick = (date) -> new Div(xpath(format(monthProperties.getDateToPick(), date)), webDriver);
    }

    public YearMonth getYearMonthValue() {
        return parse(month.getText(), YEAR_MONTH_DATE_FORMATTER);
    }

    public void selectDate(Integer date) {
        dateToPick.apply(date).select();
    }

}
