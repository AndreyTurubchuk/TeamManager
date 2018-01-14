//сервис отправки писем

package ru.bis.teammanager.service.impl;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bis.teammanager.model.Letter;
import ru.bis.teammanager.model.Person;
import ru.bis.teammanager.service.NotificationService;
import ru.bis.teammanager.service.PersonService;

@Transactional
@Service
public class NotificationServiceImpl implements NotificationService {

    private JavaMailSender javaMailSender;
    private PersonService personService;

    public NotificationServiceImpl(JavaMailSender javaMailSender, PersonService personService) {
        this.javaMailSender = javaMailSender;
        this.personService = personService;
    }

    public void sendNotification(Person person, Letter letter) throws MailException {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(person.getEmailAddress());
        mailMessage.setFrom("sokoldemian@mail.ru");
        mailMessage.setTo(letter.getTo());
        mailMessage.setSubject(letter.getSubject());
        mailMessage.setText(letter.getText());
        javaMailSender.send(mailMessage);
    }
}


