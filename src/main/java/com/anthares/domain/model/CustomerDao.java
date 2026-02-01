package com.anthares.domain.model;

import com.anthares.application.model.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Customer")
@Table(name = "customers")
public class CustomerDao {

    @Id
    private String id;

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

    protected CustomerDao() {
    }

    public CustomerDao(Customer customer) {
        this.id = customer.getId();
        this.companyName = customer.getCompanyName();
        this.generalManager = customer.getGeneralManager();
        this.ruc = customer.getRuc();
        this.dni = customer.getDni();
        this.sunatUser = customer.getSunatUser();
        this.sunatPassword = customer.getSunatPassword();
        this.phoneNumber = customer.getPhoneNumber();
        this.email = customer.getEmail();
        this.regime = customer.getRegime();
        this.rnpPassword = customer.getRnpPassword();
        this.afpUser = customer.getAfpUser();
        this.afpPassword = customer.getAfpPassword();
    }

    public Customer toDomain() {
        Customer customer = new Customer();
        customer.setId(this.id);
        customer.setCompanyName(this.companyName);
        customer.setGeneralManager(this.generalManager);
        customer.setRuc(this.ruc);
        customer.setDni(this.dni);
        customer.setSunatUser(this.sunatUser);
        customer.setSunatPassword(this.sunatPassword);
        customer.setPhoneNumber(this.phoneNumber);
        customer.setEmail(this.email);
        customer.setRegime(this.regime);
        customer.setRnpPassword(this.rnpPassword);
        customer.setAfpUser(this.afpUser);
        customer.setAfpPassword(this.afpPassword);
        return customer;
    }

}
