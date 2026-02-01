package com.anthares.infrastructure.adapter.in.web.mapper.domain;

import com.anthares.domain.model.Customer;
import com.anthares.infrastructure.adapter.out.persistence.entity.CustomerJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerDomainToResponseMapper {

  Customer toDomain(CustomerJpaEntity dao);

  CustomerJpaEntity toDao(Customer customer);
}
