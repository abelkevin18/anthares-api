package com.anthares.infrastructure.adapter.in.web.mapper.domain;

import com.anthares.domain.model.Customer;
import com.anthares.infrastructure.adapter.out.persistence.entity.CustomerJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IdMapper.class})
public interface CustomerDomainToResponseMapper {

  Customer toDomain(CustomerJpaEntity dao);

  @Mapping(target = "id", source = "id", qualifiedByName = "generateId")
  CustomerJpaEntity toDao(Customer customer);
}
