package com.anthares.application.mapper;

import com.anthares.application.dto.request.CustomerRequest;
import com.anthares.domain.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    Customer toCustomer(CustomerRequest customerRequest);
}