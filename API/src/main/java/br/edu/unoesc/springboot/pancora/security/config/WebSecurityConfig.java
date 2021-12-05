package br.edu.unoesc.springboot.pancora.security.config;

import br.edu.unoesc.springboot.pancora.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Classe de configuração de segurança web<br>
 * Esta classe foi construída e adaptada com base no projeto login-registration-backend de amigoscode
 * @see <a href="https://github.com/amigoscode/login-registration-backend">login-registration-backend</a>
 */
@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final AppUserService appUserService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Configura permissões de solicitação de página em nível de recurso
     * @param http objeto de HttpSecurity
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/resources/**").permitAll()
                    .antMatchers("/registration/**")
                    .permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin()
                    .loginPage("/login")
                    .permitAll()
                    .failureUrl("/login")
                    .and()
                    .logout()
                    .logoutSuccessUrl("/index");
    }

    /**
     * Estabelece o mecanismo de autenticação de acordo com o provedor de autenticação configurado
     * @param auth objeto de AuthenticationManagerBuilder
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    /**
     * Configura solicitações de páginas cuja autenticação deve ser ignorada
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**");
    }

    /**
     * Configura o provedor de autenticação com o método de cripotografia e classe de serviços do usuário que estão sendo utilizadas
     * @return provedor configurado
     */
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUserService);
        return provider;
    }
}
