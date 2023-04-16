package org.eugens21.hostaway.technical_assignment.nested_elements.search.popup;

import io.qameta.allure.Step;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.elements.implemenetation.BoldText;
import org.eugens21.hostaway.technical_assignment.elements.implemenetation.Button;
import org.eugens21.hostaway.technical_assignment.elements.implemenetation.InputCheckBox;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteriaActualContent;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteriaExpectedContent;
import org.eugens21.hostaway.technical_assignment.properties.locators.search_page.SearchPageToolbarFilterPopupProperties;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.CompletableFuture;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SearchPageFilterPopup {

    Range price;
    Toggle beds;
    Toggle bedRooms;
    Toggle bathRooms;
    InputCheckBox beachFront;
    InputCheckBox swimmingPool;
    InputCheckBox freeWiFi;
    InputCheckBox kitchen;
    InputCheckBox airConditioning;
    InputCheckBox washingMachine;
    InputCheckBox petsAllowed;
    InputCheckBox hotTub;
    InputCheckBox streetParking;
    InputCheckBox suitableForChildren;
    BoldText clearAll;
    Button apply;

    public SearchPageFilterPopup(SearchPageToolbarFilterPopupProperties popup, WebDriver webDriver) {
        this.beachFront = new InputCheckBox(popup.getAmenities().getBeachFront(), webDriver);
        this.swimmingPool = new InputCheckBox(popup.getAmenities().getSwimmingPool(), webDriver);
        this.freeWiFi = new InputCheckBox(popup.getAmenities().getFreeWiFi(), webDriver);
        this.kitchen = new InputCheckBox(popup.getAmenities().getKitchen(), webDriver);
        this.airConditioning = new InputCheckBox(popup.getAmenities().getAirConditioning(), webDriver);
        this.washingMachine = new InputCheckBox(popup.getAmenities().getWashingMachine(), webDriver);
        this.petsAllowed = new InputCheckBox(popup.getAmenities().getPetsAllowed(), webDriver);
        this.hotTub = new InputCheckBox(popup.getAmenities().getHotTub(), webDriver);
        this.streetParking = new InputCheckBox(popup.getAmenities().getStreetParking(), webDriver);
        this.suitableForChildren = new InputCheckBox(popup.getAmenities().getSuitableForChildren(), webDriver);
        this.price = new Range(popup.getSpecifications().getPrice(), webDriver);
        this.beds = new Toggle(popup.getSpecifications().getBeds(), webDriver);
        this.bedRooms = new Toggle(popup.getSpecifications().getBedrooms(), webDriver);
        this.bathRooms = new Toggle(popup.getSpecifications().getBathrooms(), webDriver);
        this.clearAll = new BoldText(popup.getCommands().getClearAll(), webDriver);
        this.apply = new Button(popup.getCommands().getApply(), webDriver);
    }

    @Step("Filling the pop-up with criteria")
    public SearchPageFilterPopup byCriteria(FilterCriteriaExpectedContent content) {
        doInParallel(content).join();
        return this;
    }

    @Step("Reading pop-up content")
    public FilterCriteriaActualContent get() {
        return FilterCriteriaActualContent.builder()
                .price(price.get().range())
                .beds(beds.getValue())
                .bedrooms(bedRooms.getValue())
                .bathrooms(bathRooms.getValue())
                .isAirConditioning(airConditioning.isChecked())
                .isBeachFront(beachFront.isChecked())
                .isFreeWiFi(freeWiFi.isChecked())
                .isHotTub(hotTub.isChecked())
                .isKitchen(kitchen.isChecked())
                .isPetsAllowed(petsAllowed.isChecked())
                .isStreetParking(streetParking.isChecked())
                .isSuitableForChildren(suitableForChildren.isChecked())
                .isSwimmingPool(swimmingPool.isChecked())
                .isWashingMachine(washingMachine.isChecked())
                .build();
    }

    @Step("Clicking on 'Clear All' button")
    public void clearAll() {
        clearAll.select();
    }

    @Step("Clicking on 'Apply' button")
    public void apply() {
        apply.click();
    }

    private CompletableFuture<Void> doInParallel(FilterCriteriaExpectedContent content) {
        CompletableFuture<Void> bedsFuture = CompletableFuture.runAsync(() -> {
            beds.setValue(content.getBeds());
        });
        CompletableFuture<Void> bathRoomsFuture = CompletableFuture.runAsync(() -> {
            bathRooms.setValue(content.getBathrooms());
        });
        CompletableFuture<Void> bedRoomsFuture = CompletableFuture.runAsync(() -> {
            bedRooms.setValue(content.getBedrooms());
        });
        CompletableFuture<Void> amenitiesFuture = CompletableFuture.runAsync(() -> {
            price.set().range(content.getPrice());
            beachFront.changeState(content.isBeachFront());
            swimmingPool.changeState(content.isSwimmingPool());
            freeWiFi.changeState(content.isFreeWiFi());
            kitchen.changeState(content.isKitchen());
            airConditioning.changeState(content.isAirConditioning());
            washingMachine.changeState(content.isWashingMachine());
            petsAllowed.changeState(content.isPetsAllowed());
            hotTub.changeState(content.isHotTub());
            streetParking.changeState(content.isStreetParking());
            suitableForChildren.changeState(content.isSuitableForChildren());
        });
        return CompletableFuture.allOf(bedsFuture, bathRoomsFuture, bedRoomsFuture, amenitiesFuture);
    }

}
