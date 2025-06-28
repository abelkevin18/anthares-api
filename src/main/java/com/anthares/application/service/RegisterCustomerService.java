package com.anthares.application.service;

import com.anthares.application.dto.request.CustomerRequest;
import com.anthares.application.port.in.RegisterCustomerUseCase;
import com.anthares.application.port.out.CustomerRepository;
import com.anthares.common.util.IdGenerator;
import com.anthares.domain.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterCustomerService implements RegisterCustomerUseCase {

    private final CustomerRepository customerRepository;

    @Override
    public void registerCustomer(CustomerRequest customerRequest) {
        Customer customer = customerRequest.mapperToCustomer();
        customer.setId(IdGenerator.generateId());
        customerRepository.save(customer);
    }
}
