package com.anthares.infrastructure.adapter.out.persistence;

import com.anthares.application.port.out.CustomerRepository;
import com.anthares.domain.model.Customer;
import com.anthares.infrastructure.adapter.in.web.mapper.domain.CustomerDomainToResponseMapper;
import com.anthares.infrastructure.adapter.out.persistence.repository.JpaCustomerRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerPersistenceAdapter implements CustomerRepository {

    private final JpaCustomerRepository jpaCustomerRepository;
    private final CustomerDomainToResponseMapper customerDomainToResponseMapper;

    public CustomerPersistenceAdapter(JpaCustomerRepository jpaCustomerRepository,
                                      CustomerDomainToResponseMapper customerDomainToResponseMapper) {
        this.jpaCustomerRepository = jpaCustomerRepository;
      this.customerDomainToResponseMapper = customerDomainToResponseMapper;
    }

    @Override
    public void save(Customer customer) {
        jpaCustomerRepository.save(customerDomainToResponseMapper.toDao(customer));
    }

    @Override
    public List<Customer> findAll() {
        return jpaCustomerRepository.findAll()
                .stream()
                .map(customerDomainToResponseMapper::toDomain)
                .collect(Collectors.toList());
    }
}