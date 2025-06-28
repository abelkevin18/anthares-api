package com.anthares.application.dto.request;

import com.anthares.domain.model.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomerRequest {
    private String companyName;
    private String generalManager;
    private String ruc;
    private String dni;
    private String sunatUser;
    private String sunatPassword;
    private String phoneNumber;
    private String email;
    private String regime;
    private String rnpPassword;
    private String afpUser;
    private String afpPassword;

    public Customer mapperToCustomer() {
        Customer customer = new Customer();
        customer.setCompanyName(companyName);
        customer.setGeneralManager(generalManager);
        customer.setRuc(ruc);
        customer.setDni(dni);
        customer.setSunatUser(sunatUser);
        customer.setSunatPassword(sunatPassword);
        customer.setPhoneNumber(phoneNumber);
        customer.setEmail(email);
        customer.setRegime(regime);
        customer.setRnpPassword(rnpPassword);
        customer.setAfpUser(afpUser);
        customer.setAfpPassword(afpPassword);
        return customer;
    }
}
