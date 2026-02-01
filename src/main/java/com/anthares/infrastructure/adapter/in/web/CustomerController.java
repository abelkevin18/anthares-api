package com.anthares.infrastructure.adapter.in.web;

import com.anthares.application.dto.request.CustomerRequest;
import com.anthares.application.dto.response.CustomerResponse;
import com.anthares.application.port.in.RegisterCustomerUseCase;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getCustomers() {
        return ResponseEntity.ok(registerCustomerUseCase.getCustomers());
    }

}
