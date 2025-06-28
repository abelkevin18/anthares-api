package com.anthares.infrastructure.repository.jpa;

import com.anthares.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCustomerRepository extends JpaRepository<Customer, String> {
}