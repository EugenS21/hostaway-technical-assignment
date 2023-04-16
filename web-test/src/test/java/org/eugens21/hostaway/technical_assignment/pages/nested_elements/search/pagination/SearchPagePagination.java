package org.eugens21.hostaway.technical_assignment.pages.nested_elements.search.pagination;

import io.qameta.allure.Step;
import org.eugens21.hostaway.technical_assignment.elements.implemenetation.Button;
import org.eugens21.hostaway.technical_assignment.exceptions.IllegalPageNumberException;
import org.eugens21.hostaway.technical_assignment.properties.locators.search_page.SearchPageGridPaginationProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SearchPagePagination {

    Button previous;
    Button next;
    Function<Integer, Button> page;
    Supplier<List<Integer>> pages;

    public SearchPagePagination(SearchPageGridPaginationProperties paginationProperties, WebDriver webDriver) {
        this.previous = new Button(paginationProperties.getPrevious(), webDriver);
        this.next = new Button(paginationProperties.getNext(), webDriver);
        this.page = (number) -> new Button(paginationProperties.getPage().apply(number), webDriver);
        this.pages = () -> webDriver.findElements(paginationProperties.getPages()).stream()
                .map(WebElement::getText)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public List<Integer> getPages() {
        return pages.get();
    }

    @Step("Go to next page")
    public void nextPage() {
        next.click();
    }

    @Step("Go to previous page")
    public void previousPage() {
        previous.click();
    }

    @Step("Open page number {0}")
    public void openPage(Integer pageNumber) {
        if (getPages().contains(pageNumber))
            throw new IllegalPageNumberException(String.format("Illegal page number provided %s", pageNumber));
        page.apply(pageNumber).click();
    }

}
