package br.edu.unoesc.springboot.pancora.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe responsável por verificar se o email recebido é válido<br>
 * Esta classe foi construída e complementada com base no projeto login-registration-backend de amigoscode
 * @see <a href="https://github.com/amigoscode/login-registration-backend">login-registration-backend</a>
 */
@Service
public class EmailValidator implements Predicate<String> {

    /**
     *Sobreescrita do método test
     * @param email email a ser verificado
     * @return {@code true} se o email for válido,
     * caso contrário, {@code false}
     */
    @Override
    public boolean test(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }
}
