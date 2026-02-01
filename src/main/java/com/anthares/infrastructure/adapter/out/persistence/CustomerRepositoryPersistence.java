package com.anthares.infrastructure.adapter.out.persistence;

import com.anthares.application.model.Customer;
import com.anthares.application.port.out.CustomerRepository;
import com.anthares.domain.model.CustomerDao;
import com.anthares.infrastructure.repository.jpa.JpaCustomerRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryPersistence implements CustomerRepository {

    private final JpaCustomerRepository jpaCustomerRepository;

    public CustomerRepositoryPersistence(JpaCustomerRepository jpaCustomerRepository) {
        this.jpaCustomerRepository = jpaCustomerRepository;
    }

    @Override
    public void save(Customer customer) {
        CustomerDao customerDao = new CustomerDao(customer);
        jpaCustomerRepository.save(customerDao);
    }

    @Override
    public List<Customer> findAll() {
        return jpaCustomerRepository.findAll()
                .stream()
                .map(CustomerDao::toDomain)
                .collect(Collectors.toList());
    }
}