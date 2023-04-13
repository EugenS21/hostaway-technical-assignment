package org.eugens21.hostaway.technical_assignment.service;

import org.apache.commons.lang3.tuple.Pair;
import org.eugens21.hostaway.technical_assignment.model.SearchFormContent;
import org.eugens21.hostaway.technical_assignment.model.SearchPropertiesCriteria;
import org.modelmapper.ExpressionMap;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.builder.ConfigurableConditionExpression;
import org.modelmapper.spi.DestinationSetter;
import org.modelmapper.spi.SourceGetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

@Service
public class SearchPropertiesMapperService extends AbstractMapperService<SearchPropertiesCriteria, SearchFormContent> {

    @Autowired
    public SearchPropertiesMapperService(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    protected PropertyMap<SearchPropertiesCriteria, SearchFormContent> getMappings() {
        return new PropertyMap<>() {
            @Override
            protected void configure() {
                Pair<LocalDate, LocalDate> checkInAndOutDates = source.getCheckInAndOutDates();
                map().setCheckInDate(checkInAndOutDates.getKey());
                map().setCheckOutDate(checkInAndOutDates.getValue());
            }
        };
    }

    @Override
    protected Class<SearchPropertiesCriteria> getSourceType() {
        return SearchPropertiesCriteria.class;
    }

    @Override
    protected Class<SearchFormContent> getDestinationType() {
        return SearchFormContent.class;
    }

}

