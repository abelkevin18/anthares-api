package com.anthares.infrastructure.adapter.in.web;

import com.anthares.application.dto.request.CustomerRequest;
import com.anthares.application.dto.response.CustomerResponse;
import com.anthares.application.port.in.RegisterCustomerUseCase;
import com.anthares.commons.response.ApiResponse;
import com.anthares.commons.response.PaginatedData;
import com.anthares.commons.response.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {
    private final RegisterCustomerUseCase registerCustomerUseCase;

    public CustomerController(RegisterCustomerUseCase registerCustomerUseCase) {
        this.registerCustomerUseCase = registerCustomerUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> registerCustomer(@RequestBody CustomerRequest customerRequest) {
        registerCustomerUseCase.registerCustomer(customerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/search")
    public ResponseEntity<ApiResponse<PaginatedData<CustomerResponse>>> searchCustomers(
            @RequestParam(name = "q", required = false) String q,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CustomerResponse> resultPage = registerCustomerUseCase.searchCustomersPaginated(q, pageable);

        PaginatedData<CustomerResponse> data = new PaginatedData<>(
                resultPage.getContent(),
                new Pagination(
                        resultPage.getNumber(),
                        resultPage.getSize(),
                        resultPage.getTotalElements(),
                        resultPage.getTotalPages(),
                        resultPage.isFirst(),
                        resultPage.isLast(),
                        resultPage.getNumberOfElements(),
                        resultPage.isEmpty()
                )
        );

        ApiResponse<PaginatedData<CustomerResponse>> response = ApiResponse.success(200, "Customers retrieved", data);
        return ResponseEntity.ok(response);
    }
}
