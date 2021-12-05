package br.edu.unoesc.springboot.pancora.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Classe de serviços para envio de email<br>
 * Esta classe foi construída e adaptada com base no projeto login-registration-backend de amigoscode
 * @see <a href="https://github.com/amigoscode/login-registration-backend">login-registration-backend</a>
 */
@Service
@AllArgsConstructor
public class EmailService implements EmailSender {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private final JavaMailSender mailSender;

    /**
     * Sobreescrita do método send para envio de email
     * @param to endereço de email
     * @param email corpo do email
     */
    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirme seu email");
            helper.setFrom("pancora2021@gmail.com");
            mailSender.send(mimeMessage);
        }catch (MessagingException e) {
            LOGGER.error("falha ao enviar email", e);
            throw new IllegalStateException("falha ao enviar email");
        }
    }
}
