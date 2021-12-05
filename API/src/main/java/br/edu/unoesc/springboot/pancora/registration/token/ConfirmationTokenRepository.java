package br.edu.unoesc.springboot.pancora.registration.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Repositório da classe ConfirmationToken<br>
 * Este repositório foi construído com base no projeto login-registration-backend de amigoscode
 * @see <a href="https://github.com/amigoscode/login-registration-backend">login-registration-backend</a>
 */
@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

    /**
     *findByToken busca o token informado, dentro do banco de dados
     * @param token token a ser pesquisado
     */
    Optional<ConfirmationToken> findByToken(String token);

    /**
     * Atualiza a coluna confirmed_at na tabela confirmation_token na tabela confirmation_token com a data e hora atuais para o registro equivalente ao token do parâmetro
     * @param token token a ser pesquisado
     * @param confirmedAt data e hora de confirmação
     */
    @Transactional
    @Modifying
    @Query("UPDATE ConfirmationToken c " +
            "SET c.confirmedAt = ?2 " +
            "WHERE c.token = ?1")
    int updateConfirmedAt(String token,
                          LocalDateTime confirmedAt);

}
