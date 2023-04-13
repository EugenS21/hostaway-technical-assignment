package org.eugens21.hostaway.technical_assignment.test.filter;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.WebCoreConfiguration;
import org.eugens21.hostaway.technical_assignment.driver.WebDriversFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(classes = WebCoreConfiguration.class)
public abstract class AbstractTest {

//	Please provide automation tests forhttps://kamil-demo.alpinizm.uz/ using Selenide (or Selenium), Allure, Java 11, JUnit or TestNG (without Cucumber) which will do the following:
//			1. Check Filters form: entry fields, checkboxes, minimum and maximum values, Amenities checkboxes, “Clear all” is functional, check buttons without clicking "Apply".
//	To reach the Filters form on https://kamil-demo.alpinizm.uz/ press the Search button, press the Filter button.
//			2. Check that the 'All listings' page (https://kamil-demo.alpinizm.uz/all-listings) has the same amount of listings as the 'All' label.
//			Please create only mentioned test cases and nothing more.
//			In the result an informative Allure report should be formed. Please submit the result on GitHub.
//			We expect to see the usage of AAA, POM, tests should be developed using method chaining (page object in fluent style).

    @Autowired
    WebDriver webDriver;
    @Value("${pages.mainUrl}")
    String mainUrl;

    @BeforeEach
    public void navigateToMainUrl() {
        webDriver.get(mainUrl);
    }


}
