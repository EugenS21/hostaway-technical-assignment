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
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::isAirConditioning, (dest, value) -> dest.getAmenities().setAirConditioning(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::isBeachFront, (dest, value) -> dest.getAmenities().setBeachFront(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::isFreeWiFi, (dest, value) -> dest.getAmenities().setFreeWiFi(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::isKitchen, (dest, value) -> dest.getAmenities().setKitchen(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::isHotTub, (dest, value) -> dest.getAmenities().setHotTub(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::isPetsAllowed, (dest, value) -> dest.getAmenities().setPetsAllowed(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::isStreetParking, (dest, value) -> dest.getAmenities().setStreetParking(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::isSuitableForChildren, (dest, value) -> dest.getAmenities().setSuitableForChildren(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::isSwimmingPool, (dest, value) -> dest.getAmenities().setSwimmingPool(value));
            configurableConditionExpression.<Boolean>map(AbstractFilterContent::isWashingMachine, (dest, value) -> dest.getAmenities().setWashingMachine(value));
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

