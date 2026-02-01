package com.anthares.application.service;

import com.anthares.application.dto.request.CustomerRequest;
import com.anthares.application.dto.response.CustomerResponse;
import com.anthares.application.model.Customer;
import com.anthares.application.port.in.RegisterCustomerUseCase;
import com.anthares.application.port.out.CustomerRepository;
import com.anthares.commons.util.IdGenerator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterCustomerService implements RegisterCustomerUseCase {

    private final CustomerRepository customerRepository;

    @Override
    public void registerCustomer(CustomerRequest customerRequest) {
        customerRepository.save(buildCustomer(customerRequest));
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

    private Customer buildCustomer(CustomerRequest customerRequest) {//@@revisar
        Customer customer = new Customer();
        customer.setId(IdGenerator.generateId());
        customer.setCompanyName(customerRequest.getCompanyName());
        customer.setGeneralManager(customerRequest.getGeneralManager());
        customer.setRuc(customerRequest.getRuc());
        customer.setDni(customerRequest.getDni());
        customer.setSunatUser(customerRequest.getSunatUser());
        customer.setSunatPassword(customerRequest.getSunatPassword());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());
        customer.setEmail(customerRequest.getEmail());
        customer.setRegime(customerRequest.getRegime());
        customer.setRnpPassword(customerRequest.getRnpPassword());
        customer.setAfpUser(customerRequest.getAfpUser());
        customer.setAfpPassword(customerRequest.getAfpPassword());
        return customer;
    }
}
