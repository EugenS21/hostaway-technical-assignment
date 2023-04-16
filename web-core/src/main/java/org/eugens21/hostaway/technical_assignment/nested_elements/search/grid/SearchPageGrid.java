package org.eugens21.hostaway.technical_assignment.nested_elements.search.grid;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.elements.Grid;
import org.eugens21.hostaway.technical_assignment.model.SearchGridItemContent;
import org.eugens21.hostaway.technical_assignment.properties.locators.search_page.SearchPageGridProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class SearchPageGrid implements Grid<SearchGridItemContent> {

    Supplier<List<SearchPageGridItem>> items;

    public SearchPageGrid(SearchPageGridProperties gridProperties, WebDriver webDriver) {
        this.items = () -> doInitItemsList(gridProperties, webDriver);
    }

    private List<SearchPageGridItem> doInitItemsList(SearchPageGridProperties grid, WebDriver webDriver) {
        WebElement element = webDriver.findElement(By.xpath(grid.getSelf()));
        List<WebElement> elements = element.findElements(By.xpath(grid.getItem().getSelf()));
        return Stream.iterate(1, i -> i + 1)
                .limit(elements.size())
                .parallel()
                .peek(i -> new Actions(webDriver).scrollToElement(elements.get(i - 1)).perform())
                .map(i -> new SearchPageGridItem(i, grid.getItem(), webDriver))
                .collect(Collectors.toList());
    }

    @Override
    public List<SearchGridItemContent> items() {
        return items.get().stream()
                .map(SearchPageGridItem::getData)
                .collect(Collectors.toList());
    }

    @Override
    public void open(SearchGridItemContent item) {

    }

}