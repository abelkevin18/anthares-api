package com.anthares.application.service;

import com.anthares.application.dto.request.CustomerRequest;
import com.anthares.application.dto.response.CustomerResponse;
import com.anthares.application.port.in.RegisterCustomerUseCase;
import com.anthares.application.port.out.CustomerRepository;
import com.anthares.application.service.mapper.CustomerRequestToDomainMapper;
import com.anthares.domain.model.Customer;
import com.anthares.infrastructure.adapter.in.web.mapper.dto.CustomerDomainResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterCustomerService implements RegisterCustomerUseCase {

    private final CustomerRepository customerRepository;
    private final CustomerRequestToDomainMapper customerRequestToDomainMapper;
    private final CustomerDomainResponseMapper customerDomainResponseMapper;

    @Override
    public void registerCustomer(CustomerRequest customerRequest) {
        customerRepository.save(customerRequestToDomainMapper.fromRequest(customerRequest));
    }

    @Override
    public Page<CustomerResponse> searchCustomersPaginated(String query, Pageable pageable) {
        Page<Customer> page = customerRepository.findAllByQuery(query, pageable);
        return page.map(customerDomainResponseMapper::toResponse);
    }
}
