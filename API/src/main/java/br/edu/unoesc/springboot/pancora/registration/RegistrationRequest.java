package br.edu.unoesc.springboot.pancora.registration;

import lombok.*;

/**
 * Classe DTO para a classe Appuser<br>
 * Esta classe foi construída com base no projeto login-registration-backend de amigoscode
 * @see <a href="https://github.com/amigoscode/login-registration-backend">login-registration-backend</a>
 */
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
