package com.anthares.infrastructure.repository.jpa;

import com.anthares.infrastructure.database.entity.CustomerDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCustomerRepository extends JpaRepository<CustomerDao, String> {
}