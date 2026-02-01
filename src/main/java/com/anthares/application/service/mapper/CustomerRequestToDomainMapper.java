package com.anthares.application.service.mapper;

import com.anthares.application.dto.request.CustomerRequest;
import com.anthares.domain.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerRequestToDomainMapper {
  Customer fromRequest(CustomerRequest customerRequest);
}
