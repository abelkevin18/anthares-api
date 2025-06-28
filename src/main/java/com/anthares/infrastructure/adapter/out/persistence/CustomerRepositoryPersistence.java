package com.anthares.infrastructure.adapter.out.persistence;

import com.anthares.application.port.out.CustomerRepository;
import com.anthares.domain.model.Customer;
import com.anthares.infrastructure.repository.jpa.JpaCustomerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryPersistence implements CustomerRepository {

    private final JpaCustomerRepository jpaCustomerRepository;

    public CustomerRepositoryPersistence(JpaCustomerRepository jpaCustomerRepository) {
        this.jpaCustomerRepository = jpaCustomerRepository;
    }

    @Override
    public void save(Customer customer) {
        jpaCustomerRepository.save(customer);
    }
}