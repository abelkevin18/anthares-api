package com.anthares.infrastructure.adapter.in.web;

import com.anthares.application.dto.request.CustomerRequest;
import com.anthares.application.port.in.RegisterCustomerUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final RegisterCustomerUseCase registerCustomerUseCase;

    public CustomerController(RegisterCustomerUseCase registerCustomerUseCase) {
        this.registerCustomerUseCase = registerCustomerUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> registerCustomer(@RequestBody CustomerRequest request) {
        registerCustomerUseCase.registerCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
