package br.edu.unoesc.springboot.pancora.email;

public interface EmailSender {
    void send(String to, String email);
}
