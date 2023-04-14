package org.eugens21.hostaway.technical_assignment.properties.locators.search_page;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class SearchPageToolbarFilterPopupAmenitiesProperties {

    @NestedConfigurationProperty
    SearchPageToolbarFilterPopupAmenitiesCheckBoxProperties beachFront;
    SearchPageToolbarFilterPopupAmenitiesCheckBoxProperties swimmingPool;
    SearchPageToolbarFilterPopupAmenitiesCheckBoxProperties freeWiFi;
    SearchPageToolbarFilterPopupAmenitiesCheckBoxProperties kitchen;
    SearchPageToolbarFilterPopupAmenitiesCheckBoxProperties airConditioning;
    SearchPageToolbarFilterPopupAmenitiesCheckBoxProperties washingMachine;
    SearchPageToolbarFilterPopupAmenitiesCheckBoxProperties petsAllowed;
    SearchPageToolbarFilterPopupAmenitiesCheckBoxProperties hotTub;
    SearchPageToolbarFilterPopupAmenitiesCheckBoxProperties streetParking;
    SearchPageToolbarFilterPopupAmenitiesCheckBoxProperties suitableForChildren;

}
