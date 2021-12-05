package br.edu.unoesc.springboot.pancora.appuser;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

/**
 * Classe da entidade de nome homônimo que será criada no banco de dados<br>
 * Esta classe foi construída com base no projeto login-registration-backend de amigoscode
 * @see <a href="https://github.com/amigoscode/login-registration-backend">login-registration-backend</a>
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class AppUser implements UserDetails {

    @SequenceGenerator(
            name = "appuser_sequence",
            sequenceName = "appuser_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy =  GenerationType.SEQUENCE,
            generator = "appuser_sequence"
    )
    private Long id;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked = false;
    private Boolean enabled = false;

    /**
     * Construtor parcial para a classe AppUser
     * @param username nome do usuário
     * @param email email
     * @param password senha
     * @param appUserRole tipo de usuário com permissões no sistema, descrito na enumeração {@link br.edu.unoesc.springboot.pancora.appuser.AppUserRole}
     */
    public AppUser(String username, String email, String password, AppUserRole appUserRole) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
    }

    /**
     * Sobreescrita do método getAuthorities() definido na interface UserDetails
     * @return autorizações atribuídas ao usuário
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    /**
     * Sobreescrita do método getter getPassword()
     * @return senha do usuário
     */
    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * Sobreescrita do método getter getUsername
     * @return email do usuário
     * Desse modo, na classe AppUserService, o usuário será procurado por email, através do método loadUserByUsername, herdado da interface UserDetailsService {@link br.edu.unoesc.springboot.pancora.appuser.AppUserService}
     */
    @Override
    public String getUsername() {
        return this.email;
    }

    /**
     * Sobreescrita do método isAccountNonExpired()
     * @return se a conta não está expirada
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Sobreescrita do método isAccountNonLocked()
     * @return se a conta está ou não bloqueada
     */
    @Override
    public boolean isAccountNonLocked() {
        return !this.locked;
    }

    /**
     * Sobreescrita do método isCredentialsNonExpired()
     * @return se as credenciais do usuário não estão expiradas
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Sobreescrita do método isEnabled()
     * @return se a conta está habilitada
     */
    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
