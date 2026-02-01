package com.anthares.application.service.mapper;

import com.anthares.application.dto.request.CustomerRequest;
import com.anthares.domain.model.Customer;
import com.anthares.commons.util.IdGenerator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {IdGenerator.class})
public interface CustomerRequestToDomainMapper {

  @Mapping(target = "id", expression = "java(IdGenerator.generateId())")
  Customer fromRequest(CustomerRequest customerRequest);
}
