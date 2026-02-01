package com.anthares.infrastructure.adapter.out.persistence;

import com.anthares.application.port.out.CustomerRepository;
import com.anthares.domain.model.Customer;
import com.anthares.infrastructure.adapter.out.persistence.mapper.domain.CustomerDaoDomainMapper;
import com.anthares.infrastructure.repository.jpa.JpaCustomerRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryPersistence implements CustomerRepository {

    private final JpaCustomerRepository jpaCustomerRepository;
    private final CustomerDaoDomainMapper customerDaoDomainMapper;

    public CustomerRepositoryPersistence(JpaCustomerRepository jpaCustomerRepository,
                                         CustomerDaoDomainMapper customerDaoDomainMapper) {
        this.jpaCustomerRepository = jpaCustomerRepository;
      this.customerDaoDomainMapper = customerDaoDomainMapper;
    }

    @Override
    public void save(Customer customer) {
        jpaCustomerRepository.save(customerDaoDomainMapper.toDao(customer));
    }

    @Override
    public List<Customer> findAll() {
        return jpaCustomerRepository.findAll()
                .stream()
                .map(customerDaoDomainMapper::toDomain)
                .collect(Collectors.toList());
    }
}