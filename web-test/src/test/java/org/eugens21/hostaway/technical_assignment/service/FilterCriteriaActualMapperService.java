package org.eugens21.hostaway.technical_assignment.service;

import org.eugens21.hostaway.technical_assignment.model.AbstractFilterContent;
import org.eugens21.hostaway.technical_assignment.model.Amenities;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteria;
import org.eugens21.hostaway.technical_assignment.model.FilterCriteriaActualContent;
import org.modelmapper.ExpressionMap;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilterCriteriaActualMapperService extends AbstractMapperService<FilterCriteriaActualContent, FilterCriteria> {

    @Autowired
    public FilterCriteriaActualMapperService(ModelMapper modelMapper) {
        super(modelMapper);
    }

    @Override
    protected ExpressionMap<FilterCriteriaActualContent, FilterCriteria> getMappings() {
        final Amenities amenities = Amenities.builder().build();
        return configurableConditionExpression -> {
            configurableConditionExpression.map(FilterCriteriaActualContent::getPrice, FilterCriteria::setPrice);
            configurableConditionExpression.map(FilterCriteriaActualContent::getBathrooms, FilterCriteria::setBathrooms);
            configurableConditionExpression.map(FilterCriteriaActualContent::getBedrooms, FilterCriteria::setBedrooms);
            configurableConditionExpression.map(FilterCriteriaActualContent::getBeds, FilterCriteria::setBeds);
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::getIsAirConditioning, (dest, value) -> dest.getAmenities().setHasAirConditioning(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::getIsBeachFront, (dest, value) -> dest.getAmenities().setHasBeachFront(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::getIsFreeWiFi, (dest, value) -> dest.getAmenities().setHasFreeWiFi(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::getIsKitchen, (dest, value) -> dest.getAmenities().setHasKitchen(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::getIsHotTub, (dest, value) -> dest.getAmenities().setHasHotTub(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::getIsPetsAllowed, (dest, value) -> dest.getAmenities().setHasPetsAllowed(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::getIsStreetParking, (dest, value) -> dest.getAmenities().setHasStreetParking(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::getIsSuitableForChildren, (dest, value) -> dest.getAmenities().setHasSuitableForChildren(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::getIsSwimmingPool, (dest, value) -> dest.getAmenities().setHasSwimmingPool(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::getIsWashingMachine, (dest, value) -> dest.getAmenities().setHasWashingMachine(value));
        };
    }

    @Override
    protected Class<FilterCriteriaActualContent> getSourceType() {
        return FilterCriteriaActualContent.class;
    }

    @Override
    protected Class<FilterCriteria> getDestinationType() {
        return FilterCriteria.class;
    }

}

