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
            configurableConditionExpression.map(src -> src.getAmenities().getHasAirConditioning(), FilterCriteriaExpectedContent::setIsAirConditioning);
            configurableConditionExpression.map(src -> src.getAmenities().getHasBeachFront(), FilterCriteriaExpectedContent::setIsBeachFront);
            configurableConditionExpression.map(src -> src.getAmenities().getHasFreeWiFi(), FilterCriteriaExpectedContent::setIsFreeWiFi);
            configurableConditionExpression.map(src -> src.getAmenities().getHasKitchen(), FilterCriteriaExpectedContent::setIsKitchen);
            configurableConditionExpression.map(src -> src.getAmenities().getHasHotTub(), FilterCriteriaExpectedContent::setIsHotTub);
            configurableConditionExpression.map(src -> src.getAmenities().getHasPetsAllowed(), FilterCriteriaExpectedContent::setIsPetsAllowed);
            configurableConditionExpression.map(src -> src.getAmenities().getHasStreetParking(), FilterCriteriaExpectedContent::setIsStreetParking);
            configurableConditionExpression.map(src -> src.getAmenities().getHasSuitableForChildren(), FilterCriteriaExpectedContent::setIsSuitableForChildren);
            configurableConditionExpression.map(src -> src.getAmenities().getHasSwimmingPool(), FilterCriteriaExpectedContent::setIsSwimmingPool);
            configurableConditionExpression.map(src -> src.getAmenities().getHasWashingMachine(), FilterCriteriaExpectedContent::setIsWashingMachine);
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

