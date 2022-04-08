package com.example.postofficeapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientResponse {
    @NotNull(message = "clientId cannot be empty")
    private String clientID;
    @NotNull(message = "Name cannot be empty")
    private String name;
    @NotNull(message = "Surname cannot be empty")
    private String surname;
    @NotNull(message = "Email cannot be empty")
    private String email;
}
