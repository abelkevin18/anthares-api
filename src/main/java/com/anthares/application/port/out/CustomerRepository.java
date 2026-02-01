package com.anthares.application.port.out;

import com.anthares.application.model.Customer;
import java.util.List;

public interface CustomerRepository {
    void save(Customer customer);
    List<Customer> findAll();
}
