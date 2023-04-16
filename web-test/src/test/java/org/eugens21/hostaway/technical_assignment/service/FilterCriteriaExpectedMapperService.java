package org.eugens21.hostaway.technical_assignment.service;

import org.eugens21.hostaway.technical_assignment.model.FilterCriteria;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteriaExpectedContent;
import org.modelmapper.ExpressionMap;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilterCriteriaExpectedMapperService extends AbstractMapperService<FilterCriteria, FilterCriteriaExpectedContent> {

    @Autowired
    public FilterCriteriaExpectedMapperService(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    protected ExpressionMap<FilterCriteria, FilterCriteriaExpectedContent> getMappings() {
        return configurableConditionExpression -> {
            configurableConditionExpression.map(FilterCriteria::getPrice, FilterCriteriaExpectedContent::setPrice);
            configurableConditionExpression.map(FilterCriteria::getBathrooms, FilterCriteriaExpectedContent::setBathrooms);
            configurableConditionExpression.map(FilterCriteria::getBedrooms, FilterCriteriaExpectedContent::setBedrooms);
            configurableConditionExpression.map(FilterCriteria::getBeds, FilterCriteriaExpectedContent::setBeds);
            configurableConditionExpression.map(src -> src.getAmenities().isAirConditioning(), FilterCriteriaExpectedContent::setAirConditioning);
            configurableConditionExpression.map(src -> src.getAmenities().isBeachFront(), FilterCriteriaExpectedContent::setBeachFront);
            configurableConditionExpression.map(src -> src.getAmenities().isFreeWiFi(), FilterCriteriaExpectedContent::setFreeWiFi);
            configurableConditionExpression.map(src -> src.getAmenities().isKitchen(), FilterCriteriaExpectedContent::setKitchen);
            configurableConditionExpression.map(src -> src.getAmenities().isHotTub(), FilterCriteriaExpectedContent::setHotTub);
            configurableConditionExpression.map(src -> src.getAmenities().isPetsAllowed(), FilterCriteriaExpectedContent::setPetsAllowed);
            configurableConditionExpression.map(src -> src.getAmenities().isStreetParking(), FilterCriteriaExpectedContent::setStreetParking);
            configurableConditionExpression.map(src -> src.getAmenities().isSuitableForChildren(), FilterCriteriaExpectedContent::setSuitableForChildren);
            configurableConditionExpression.map(src -> src.getAmenities().isSwimmingPool(), FilterCriteriaExpectedContent::setSwimmingPool);
            configurableConditionExpression.map(src -> src.getAmenities().isWashingMachine(), FilterCriteriaExpectedContent::setWashingMachine);
        };
    }

    @Override
    protected Class<FilterCriteria> getSourceType() {
        return FilterCriteria.class;
    }

    @Override
    protected Class<FilterCriteriaExpectedContent> getDestinationType() {
        return FilterCriteriaExpectedContent.class;
    }

}

