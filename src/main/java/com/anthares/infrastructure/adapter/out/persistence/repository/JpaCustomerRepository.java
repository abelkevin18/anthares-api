package com.anthares.infrastructure.adapter.out.persistence.repository;

import com.anthares.infrastructure.adapter.out.persistence.entity.CustomerJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCustomerRepository extends JpaRepository<CustomerJpaEntity, String> {
}