package org.eugens21.hostaway.technical_assignment.properties.locators.converter;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.eugens21.hostaway.technical_assignment.properties.service.LocatorsResolverService;
import org.openqa.selenium.By;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@ConfigurationPropertiesBinding
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StringToFunctionByTypeConverter implements Converter<String, Function<Integer, By>> {

    LocatorsResolverService locatorsResolverService;

    public StringToFunctionByTypeConverter() {
        this.locatorsResolverService = new LocatorsResolverService();
    }

    @Override
    public Function<Integer, By> convert(String source) {
        return (index) -> locatorsResolverService.resolve(String.format(source, index));
    }
}
