package org.eugens21.hostaway.technical_assignment.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.modelmapper.ExpressionMap;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;

import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PROTECTED)
public abstract class AbstractMapperService<S, D> {

    ModelMapper modelMapper;

    private void configureMapper() {
        TypeMap<S, D> typeMap = modelMapper.createTypeMap(getSourceType(), getDestinationType());
        typeMap.addMappings(getMappings());
    }

    protected AbstractMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    protected abstract PropertyMap<S, D> getMappings();

    protected abstract Class<S> getSourceType();

    protected abstract Class<D> getDestinationType();

    public D map(S source) {
        configureMapper();
        return modelMapper.map(source, getDestinationType());
    }

}
