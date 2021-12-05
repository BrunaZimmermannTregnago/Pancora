package br.edu.unoesc.springboot.pancora.email;

/**
 * Interface com método para envio de email<br>
 * Esta interface foi construída com base no projeto login-registration-backend de amigoscode
 * @see <a href="https://github.com/amigoscode/login-registration-backend">login-registration-backend</a>
 */
public interface EmailSender {
    void send(String to, String email);
}
