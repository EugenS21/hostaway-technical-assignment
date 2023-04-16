package org.eugens21.hostaway.technical_assignment.pages.nested_elements.search.grid;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.elements.implemenetation.Header;
import org.eugens21.hostaway.technical_assignment.elements.implemenetation.Span;
import org.eugens21.hostaway.technical_assignment.model.AllListingsGridItemContent;
import org.eugens21.hostaway.technical_assignment.properties.locators.all_listings.AllListingsPageGridItemAmenitiesProperties;
import org.eugens21.hostaway.technical_assignment.properties.locators.all_listings.AllListingsPageGridItemProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.eugens21.hostaway.technical_assignment.transformer.StringTransformers.getIntegerFromString;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
class AllListingsPageGridItem {

    Header name;
    Span guests;
    Span bedroom;
    Span bath;
    List<Span> amenities;

    public AllListingsPageGridItem(Integer atIndex, AllListingsPageGridItemProperties item, WebDriver webDriver) {
        this.name = new Header(item.getName().apply(atIndex), webDriver);
        this.guests = new Span(item.getGuests().apply(atIndex), webDriver);
        this.bedroom = new Span(item.getBedroom().apply(atIndex), webDriver);
        this.bath = new Span(item.getBath().apply(atIndex), webDriver);
        this.amenities = doInitAmenities(atIndex, item.getAmenities(), webDriver);
    }

    private List<Span> doInitAmenities(Integer atIndex, AllListingsPageGridItemAmenitiesProperties amenities, WebDriver webDriver) {
        String xpath = String.format(amenities.getSelf(), atIndex);
        List<WebElement> elements = webDriver.findElements(By.xpath(xpath));
        return Stream.iterate(1, i -> i + 1)
                .limit(elements.size())
                .map(i -> new Span(By.xpath(String.format(xpath.concat(String.format("[%d]", i)))), webDriver))
                .collect(Collectors.toList());
    }

    private List<String> getAmenities() {
        return amenities.stream()
                .map(Span::getValue)
                .collect(Collectors.toList());
    }

    public void open() {
        name.click();
    }

    public AllListingsGridItemContent getData() {
        return AllListingsGridItemContent.builder()
                .name(name.getValue())
                .bathrooms(getIntegerFromString.apply(bath.getValue()))
                .bedrooms(getIntegerFromString.apply(bedroom.getValue()))
                .guests(getIntegerFromString.apply(guests.getValue()))
                .amenities(getAmenities())
                .build();
    }

}
