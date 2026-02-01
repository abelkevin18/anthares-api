package com.anthares.infrastructure.adapter.out.persistence;

import com.anthares.application.port.out.CustomerRepository;
import com.anthares.domain.model.Customer;
import com.anthares.infrastructure.adapter.in.web.mapper.domain.CustomerDomainToResponseMapper;
import com.anthares.infrastructure.adapter.out.persistence.entity.CustomerJpaEntity;
import com.anthares.infrastructure.adapter.out.persistence.repository.JpaCustomerRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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

    @Override
    public Page<Customer> findAllByQuery(String query, Pageable pageable) {
        if (query == null || query.isBlank()) {
            Page<CustomerJpaEntity> page = jpaCustomerRepository.findAll(pageable);
            List<Customer> content = page.getContent()
                    .stream()
                    .map(customerDomainToResponseMapper::toDomain)
                    .collect(Collectors.toList());
            return new PageImpl<>(content, pageable, page.getTotalElements());
        }

        String q = query.trim().toLowerCase();
        Specification<CustomerJpaEntity> spec = (root, cq, cb) -> cb.or(
                cb.like(cb.lower(root.get("companyName")), "%" + q + "%"),
                cb.like(cb.lower(root.get("generalManager")), "%" + q + "%"),
                cb.like(cb.lower(root.get("ruc")), "%" + q + "%")
        );

        Page<CustomerJpaEntity> page = jpaCustomerRepository.findAll(spec, pageable);
        List<Customer> content = page.getContent()
                .stream()
                .map(customerDomainToResponseMapper::toDomain)
                .collect(Collectors.toList());
        return new PageImpl<>(content, pageable, page.getTotalElements());
    }
}