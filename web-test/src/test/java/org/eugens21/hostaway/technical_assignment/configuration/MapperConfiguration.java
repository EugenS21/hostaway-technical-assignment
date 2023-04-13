package org.eugens21.hostaway.technical_assignment.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
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
        return modelMapper;
    }


}
