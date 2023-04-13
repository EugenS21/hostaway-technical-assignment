package org.eugens21.hostaway.technical_assignment.service;

import org.eugens21.hostaway.technical_assignment.model.SearchFormContent;
import org.eugens21.hostaway.technical_assignment.model.SearchPropertiesCriteria;
import org.modelmapper.ExpressionMap;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SearchPropertiesMapperService extends AbstractMapperService<SearchPropertiesCriteria, SearchFormContent> {

    @Autowired
    public SearchPropertiesMapperService(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    protected ExpressionMap<SearchPropertiesCriteria, SearchFormContent> getMappings() {
        return configurableConditionExpression -> {
            configurableConditionExpression.map(source -> source.getCheckInAndOutDates().getKey(), (v, e) -> v.setCheckInDate((LocalDate) e));
            configurableConditionExpression.map(source -> source.getCheckInAndOutDates().getValue(), (v, e) -> v.setCheckOutDate((LocalDate) e));
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

