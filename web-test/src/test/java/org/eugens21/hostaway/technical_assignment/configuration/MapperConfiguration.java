package org.eugens21.hostaway.technical_assignment.configuration;

import org.eugens21.hostaway.technical_assignment.model.SearchFormContent;
import org.eugens21.hostaway.technical_assignment.model.SearchPropertiesCriteria;
import org.eugens21.hostaway.technical_assignment.pages.SearchPage;
import org.eugens21.hostaway.technical_assignment.properties.locators.home_page.SearchFormProperties;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;
import static org.modelmapper.convention.MatchingStrategies.STRICT;

@Component
public class MapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        var configuration = modelMapper.getConfiguration();
        configuration.setAmbiguityIgnored(true);
        configuration.setFieldAccessLevel(PRIVATE);
        configuration.setFieldMatchingEnabled(true);
        configuration.setMatchingStrategy(STRICT);
        configuration.setSkipNullEnabled(true);
        configuration.setMethodAccessLevel(PRIVATE);
        return modelMapper;
    }


}
