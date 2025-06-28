package com.anthares.application.port.out;

import com.anthares.domain.model.Customer;

public interface CustomerRepository {
    void save(Customer customer);
}
