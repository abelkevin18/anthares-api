package com.anthares.application.port.in;

import com.anthares.application.dto.request.CustomerRequest;

public interface RegisterCustomerUseCase {
    void registerCustomer(CustomerRequest customer);
}
