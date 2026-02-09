package com.anthares.application.port.in;

import com.anthares.application.dto.request.CustomerRequest;
import com.anthares.application.dto.response.CustomerResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RegisterCustomerUseCase {
    void registerCustomer(CustomerRequest customerRequest);
    Page<CustomerResponse> searchCustomersPaginated(String query, Pageable pageable);
}
