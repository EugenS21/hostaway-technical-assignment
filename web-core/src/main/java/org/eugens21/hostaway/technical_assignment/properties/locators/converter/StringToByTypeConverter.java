package org.eugens21.hostaway.technical_assignment.properties.locators.converter;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.properties.service.LocatorsResolverService;
import org.openqa.selenium.By;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StringToByTypeConverter implements Converter<String, By> {

    LocatorsResolverService locatorsResolverService;

    public StringToByTypeConverter() {
        this.locatorsResolverService = new LocatorsResolverService();
    }

    @Override
    public By convert(String source) {
        return locatorsResolverService.resolve(source);
    }

}
