package com.anthares.application.service;

import com.anthares.application.dto.request.CustomerRequest;
import com.anthares.application.dto.response.CustomerResponse;
import com.anthares.application.port.in.RegisterCustomerUseCase;
import com.anthares.application.port.out.CustomerRepository;
import com.anthares.application.service.mapper.CustomerRequestToDomainMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterCustomerService implements RegisterCustomerUseCase {

    private final CustomerRepository customerRepository;
    private final CustomerRequestToDomainMapper customerRequestToDomainMapper;

    @Override
    public void registerCustomer(CustomerRequest customerRequest) {
        customerRepository.save(customerRequestToDomainMapper.fromRequest(customerRequest));
    }

    @Override
    public List<CustomerResponse> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> {
                    CustomerResponse customerResponse = new CustomerResponse();
                    customerResponse.setId(customer.getId());
                    customerResponse.setCompanyName(customer.getCompanyName());
                    customerResponse.setGeneralManager(customer.getGeneralManager());
                    customerResponse.setRuc(customer.getRuc());
                    customerResponse.setDni(customer.getDni());
                    customerResponse.setSunatUser(customer.getSunatUser());
                    customerResponse.setSunatPassword(customer.getSunatPassword());
                    customerResponse.setPhoneNumber(customer.getPhoneNumber());
                    customerResponse.setEmail(customer.getEmail());
                    customerResponse.setRegime(customer.getRegime());
                    return customerResponse;
                })
                .collect(Collectors.toList());
    }
}
