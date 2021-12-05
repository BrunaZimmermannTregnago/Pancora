package br.edu.unoesc.springboot.pancora.appuser;

import br.edu.unoesc.springboot.pancora.registration.token.ConfirmationToken;
import br.edu.unoesc.springboot.pancora.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Classe de serviços da classe AppUser<br>
 * Esta classe foi construída com base no projeto login-registration-backend de amigoscode
 * @see <a href="https://github.com/amigoscode/login-registration-backend">login-registration-backend</a>
 */
@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    /**
     * Carrega o usuário através do seu email
     * @param email email do usuário
     * @return usuário cadastrado com o email passado no parâmetro
     * @throws UsernameNotFoundException caso nenhum usuário possua este endereço de email
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Usuário com email não encontrado."));
    }

    /**
     * Cadastra um novo usuário
     * @param appUser usuário a ser cadastrado
     * @return token gerado para a confirmação do usuário
     */
    public String signUpUser(AppUser appUser) {
        boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();

        /**
         * Verifica se o endereço de email já está sendo utilizado por algum usuário
         * @throw exceção informando que este email está indisponível caso o if retorne true
         */
        if (userExists) {
            throw new IllegalStateException("este email já está em uso");
        }

        /**
         * Codifica a senha do usuário utilizando o método de criptografia hash BCrypt
         */
        String encodedPassword = bCryptPasswordEncoder.encode(appUser.getPassword());

        /**
         * Atribui a senha criptografada ao usuário
         */
        appUser.setPassword(encodedPassword);

        /**
         * salva o novo usuário no banco de dados
         */
        appUserRepository.save(appUser);

        /**
         * Gera um token aleatório
         */
        String token = UUID.randomUUID().toString();

        /**
         * Cria um novo objeto da classe ConfirmationToken com o token recém gerado, data e hora atuais, data e hora atuais mais 15 minutos(tempo de expiração do token) e o usuário recém criado
         * @link br.edu.unoesc.springboot.pancora.registration.token.ConfirmationToken
         */
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );

        /**
         * Salva o objeto confirmationToken no banco de dados
         */
        confirmationTokenService.saveConfirmationToken(confirmationToken);

        return token;
    }

    /**
     * Habilita o acesso ao usuário
     * @param email email do usuário
     * @return atualização da coluna enabled da tabela app_user para TRUE no registro que contém o email passado como parâmetro
     * @link br.edu.unoesc.springboot.pancora.appuser.AppUserRepository
     */
    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}