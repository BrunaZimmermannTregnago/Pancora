package br.edu.unoesc.springboot.pancora.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class RegistrationRequest {

    private final String username;
    private final String email;
    private final String password;

}
