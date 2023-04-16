package org.eugens21.hostaway.technical_assignment.pages.nested_elements.search.grid;

import io.qameta.allure.Step;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.elements.Grid;
import org.eugens21.hostaway.technical_assignment.elements.implemenetation.Span;
import org.eugens21.hostaway.technical_assignment.model.AllListingsGridItemContent;
import org.eugens21.hostaway.technical_assignment.properties.locators.all_listings.AllListingsPageGridProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.eugens21.hostaway.technical_assignment.transformer.StringTransformers.getIntegerFromString;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AllListingsPageGrid implements Grid<AllListingsGridItemContent> {

    Span properties;
    Supplier<List<AllListingsPageGridItem>> items;

    public AllListingsPageGrid(AllListingsPageGridProperties gridProperties, WebDriver webDriver) {
        this.items = () -> doInitItemsList(gridProperties, webDriver);
        this.properties = new Span(gridProperties.getProperties(), webDriver);
    }

    @SneakyThrows
    private List<AllListingsPageGridItem> doInitItemsList(AllListingsPageGridProperties grid, WebDriver webDriver) {
        Actions actions = new Actions(webDriver);
        WebElement element = webDriver.findElement(By.xpath(grid.getSelf()));
        Supplier<List<WebElement>> findElements = () -> element.findElements(By.xpath(grid.getItem().getSelf()));
        final List<WebElement> elements = new ArrayList<>();
        int retries = 0;
        while (elements.size() != findElements.get().size() || retries++ < 500) {
            elements.clear();
            ((JavascriptExecutor) webDriver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            elements.addAll(findElements.get());
            if (elements.size() != findElements.get().size()) {
                retries = 0;
            }
        }

        return Stream.iterate(1, i -> i + 1)
                .limit(elements.size())
                .peek(i -> actions.moveToElement(elements.get(i - 1)).perform())
                .map(i -> new AllListingsPageGridItem(i, grid.getItem(), webDriver))
                .collect(Collectors.toList());
    }

    public Integer getAll() {
        return getIntegerFromString.apply(properties.getValue());
    }

    @Step("Read all the available properties")
    @Override
    public List<AllListingsGridItemContent> items() {
        return items.get().stream()
                .map(AllListingsPageGridItem::getData)
                .collect(Collectors.toList());
    }

    @Step("Open property {0}")
    @Override
    public void open(AllListingsGridItemContent item) {
        items.get().stream()
                .filter(el -> el.getData().equals(item))
                .findFirst()
                .ifPresent(AllListingsPageGridItem::open);
    }

}