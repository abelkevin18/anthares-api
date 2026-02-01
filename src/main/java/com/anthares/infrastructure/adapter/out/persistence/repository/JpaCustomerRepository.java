package com.anthares.infrastructure.adapter.out.persistence.repository;

import com.anthares.infrastructure.adapter.out.persistence.entity.CustomerJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JpaCustomerRepository extends JpaRepository<CustomerJpaEntity, String>, JpaSpecificationExecutor<CustomerJpaEntity> {
}
