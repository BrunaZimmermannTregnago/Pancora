package br.edu.unoesc.springboot.pancora.appuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Repositório da classe AppUser<br>
 * Esta interface foi construída com base no projeto login-registration-backend de amigoscode
 * @see <a href="https://github.com/amigoscode/login-registration-backend">login-registration-backend</a>
 */
@Repository
@Transactional
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    /**
     *findByEmail busca o usuário cadastrado com base no email passado como parâmetro
     * @param email email a ser pesquisado
     * @return usuário com email correspondente ao parâmetro
     */
    Optional<AppUser> findByEmail(String email);

    /**
     * enableAppUser atualiza a coluna enabled na tabela app_user para TRUE onde o email do registro corresponder ao email do parâmetro
     * @param email email do usuário
     */
    @Transactional
    @Modifying
    @Query("UPDATE AppUser a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableAppUser(String email);

    @Query(value = "select au from AppUser au")
    List<AppUser> buscar();
}
