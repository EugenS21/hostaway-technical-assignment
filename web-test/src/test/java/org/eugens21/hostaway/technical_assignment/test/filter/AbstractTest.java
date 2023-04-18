package org.eugens21.hostaway.technical_assignment.test.filter;

import io.qameta.allure.Step;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.eugens21.hostaway.technical_assignment.WebTestsBaseClass;
import org.eugens21.hostaway.technical_assignment.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

@FieldDefaults(level = AccessLevel.PROTECTED)
@SpringBootTest(classes = WebTestsBaseClass.class)
@Slf4j
public abstract class AbstractTest extends AbstractTestNGSpringContextTests {

    @Autowired
    HomePage homePage;
    @Autowired
    WebDriver webDriver;
    @Value("${pages.mainUrl}")
    String mainUrl;

    @BeforeClass
    @Step("Navigating to main page")
    public void navigateToMainUrl() {
        webDriver.get(mainUrl);
    }

    @AfterSuite
    public void closeDriver() {
        log.info("Quitting driver");
        webDriver.quit();
    }

}
