package org.eugens21.hostaway.technical_assignment.driver;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.driver.type.Chrome;
import org.eugens21.hostaway.technical_assignment.driver.type.Edge;
import org.eugens21.hostaway.technical_assignment.driver.type.Firefox;
import org.eugens21.hostaway.technical_assignment.enums.DriverTypeEnum;
import org.eugens21.hostaway.technical_assignment.properties.WebDriverProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static io.vavr.API.*;
import static org.eugens21.hostaway.technical_assignment.enums.DriverTypeEnum.*;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class WebDriversFactory {

    WebDriverProperties driverProperties;

    public ConfigurableWebDriver create() {
        DriverTypeEnum type = driverProperties.getType();
        return Match(type).of(
                Case($(FIREFOX), new Firefox(driverProperties)),
                Case($(EDGE), new Edge(driverProperties)),
                Case($(), new Chrome(driverProperties))
        );
    }

}
