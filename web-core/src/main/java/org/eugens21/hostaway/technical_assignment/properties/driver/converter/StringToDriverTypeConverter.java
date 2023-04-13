package org.eugens21.hostaway.technical_assignment.properties.driver.converter;

import io.vavr.control.Option;
import org.eugens21.hostaway.technical_assignment.enums.DriverTypeEnum;
import org.eugens21.hostaway.technical_assignment.exceptions.InvalidPropertyException;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
@ConfigurationPropertiesBinding
public class StringToDriverTypeConverter implements Converter<String, DriverTypeEnum> {

    @Override
    public DriverTypeEnum convert(String source) {
        return Option.of(source)
                .map(String::trim)
                .map(String::toUpperCase)
                .toTry()
                .map(DriverTypeEnum::valueOf)
                .getOrElseThrow(() -> new InvalidPropertyException(format("Property [%s] is not a valid driver type ", source)));
    }

}
