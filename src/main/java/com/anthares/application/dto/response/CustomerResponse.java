package com.anthares.application.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerResponse {
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
