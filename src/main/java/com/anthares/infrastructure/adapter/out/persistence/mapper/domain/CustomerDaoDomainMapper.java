package com.anthares.infrastructure.adapter.out.persistence.mapper.domain;

import com.anthares.domain.model.Customer;
import com.anthares.infrastructure.database.entity.CustomerDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IdMapper.class})
public interface CustomerDaoDomainMapper {

  Customer toDomain(CustomerDao dao);

  @Mapping(target = "id", source = "id", qualifiedByName = "generateId")
  CustomerDao toDao(Customer customer);
}
