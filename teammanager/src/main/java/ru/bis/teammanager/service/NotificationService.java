package ru.bis.teammanager.service;

import ru.bis.teammanager.model.Letter;
import ru.bis.teammanager.model.Person;

public interface NotificationService {
    void sendNotification(Person person, Letter letter);
}
