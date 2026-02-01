package com.anthares.infrastructure.adapter.in.web.mapper.dto;

import com.anthares.application.dto.response.CustomerResponse;
import com.anthares.domain.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerDomainResponseMapper {
  CustomerResponse toResponse(Customer customer);
}
