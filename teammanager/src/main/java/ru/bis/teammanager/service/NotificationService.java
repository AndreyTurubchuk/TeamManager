package ru.bis.teammanager.service;

import org.springframework.mail.MailException;
import ru.bis.teammanager.model.Letter;
import ru.bis.teammanager.model.Person;

public interface NotificationService {
    void sendNotification(Person person, Letter letter);
}
