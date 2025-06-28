package com.anthares.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

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

}
