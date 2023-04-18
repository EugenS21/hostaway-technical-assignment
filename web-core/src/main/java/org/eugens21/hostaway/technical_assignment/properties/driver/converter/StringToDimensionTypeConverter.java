package org.eugens21.hostaway.technical_assignment.properties.driver.converter;

import org.openqa.selenium.Dimension;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class StringToDimensionTypeConverter implements Converter<String, Dimension> {

    @Override
    public Dimension convert(String source) {
        String[] dimensions = source.split("x");
        int x = Integer.parseInt(dimensions[0].trim());
        int y = Integer.parseInt(dimensions[1].trim());
        return new Dimension(x, y);
    }

}
