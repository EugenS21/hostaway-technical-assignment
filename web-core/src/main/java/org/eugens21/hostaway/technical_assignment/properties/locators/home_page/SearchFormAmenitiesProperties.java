package org.eugens21.hostaway.technical_assignment.properties.locators.home_page;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.openqa.selenium.By;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class SearchFormAmenitiesProperties {

    By airConditioning;
    By breakfast;
    By checkInOneDayAhead;
    By balcony;
    By beachEssentials;

}
