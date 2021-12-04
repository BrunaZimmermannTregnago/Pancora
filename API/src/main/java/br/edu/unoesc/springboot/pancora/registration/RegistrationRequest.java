package br.edu.unoesc.springboot.pancora.registration;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RegistrationRequest {

    private String username;
    private String email;
    private String password;

}
