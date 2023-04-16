package org.eugens21.hostaway.technical_assignment.driver;

import org.openqa.selenium.remote.RemoteWebDriver;

public interface ConfigurableWebDriver<T extends RemoteWebDriver> {

    T get();

}
