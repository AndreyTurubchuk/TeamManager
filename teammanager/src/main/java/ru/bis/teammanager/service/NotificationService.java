package ru.bis.teammanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ru.bis.teammanager.model.Letter;
import ru.bis.teammanager.model.Person;


@Service
public class NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }

    public void sendNotification(Person person, Letter letter) throws MailException{

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(person.getEmailAddress());
        mailMessage.setFrom("antur1977@mail.ru");
        mailMessage.setTo(letter.getTo());
        mailMessage.setSubject(letter.getSubject());
        mailMessage.setText(letter.getText());

        /*mailMessage.setFrom("antur1977@mail.ru");
        mailMessage.setTo("antur1977@mail.ru");
        mailMessage.setSubject("Main Message");
        mailMessage.setText("This is s BIS");*/
        javaMailSender.send(mailMessage);

    }


}
