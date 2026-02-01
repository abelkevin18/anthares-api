package com.anthares.application.port.in;

import com.anthares.application.dto.request.CustomerRequest;
import com.anthares.application.dto.response.CustomerResponse;
import java.util.List;

public interface RegisterCustomerUseCase {
    void registerCustomer(CustomerRequest customerRequest);
    List<CustomerResponse> getCustomers();
}
