package com.anthares.application.port.out;

import com.anthares.domain.model.Customer;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerRepository {
    void save(Customer customer);
    List<Customer> findAll();

    Page<Customer> findAllByQuery(String query, Pageable pageable);
}
