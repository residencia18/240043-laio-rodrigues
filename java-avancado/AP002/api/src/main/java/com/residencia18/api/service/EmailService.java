package com.residencia18.api.service;

import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
@Slf4j
public class EmailService {
    @Autowired
    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(String to, String subject, String body) throws MessagingException {
        log.info("Sending email to: {}", to);

        var message = javaMailSender.createMimeMessage();
        var helper = new MimeMessageHelper(message, true); //

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(body, true);

        javaMailSender.send(message);
        log.info("Email sent to: {}", to);
    }

}
