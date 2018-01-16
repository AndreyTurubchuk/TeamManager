package ru.bis.teammanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bis.teammanager.model.Letter;
import ru.bis.teammanager.model.Person;
import ru.bis.teammanager.repositories.LetterRepository;
import ru.bis.teammanager.repositories.PersonRepository;
import ru.bis.teammanager.service.LetterService;
import ru.bis.teammanager.service.NotificationService;
import ru.bis.teammanager.service.PersonService;

import java.util.List;

//@Transactional
@Service
public class PersonServiceImpl implements PersonService {
    private final static String MESSAGE_HIRED = "You are hired";
    private final static String MESSAGE_EDIT = "You are edit";
    private final static String MESSAGE_FIRED = "You are fired";
    private final static String MESSAGE_SUBJECT = "Message";

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private LetterService letterService;

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
        Letter letter = letterService.createLetter(person, MESSAGE_SUBJECT, MESSAGE_HIRED);
        notificationService.sendNotification(person, letter);
    }


    @Override
    public void editPerson(long id, Person personDetails) {
        Person person = personRepository.getOne(id);
        person.setFirstName(personDetails.getFirstName());
        person.setLastName(personDetails.getLastName());
        person.setEmailAddress(personDetails.getEmailAddress());
        personRepository.save(person);
        Letter letter = letterService.createLetter(person, MESSAGE_SUBJECT, MESSAGE_EDIT);
        notificationService.sendNotification(person, letter);
    }

    @Override
    public void delete(long id) {
        Person person = personRepository.getOne(id);
        Letter letter = letterService.createLetter(person, MESSAGE_SUBJECT, MESSAGE_FIRED);
        personRepository.delete(id);
        notificationService.sendNotification(person, letter);

    }


    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }


    @Override
    public Person getOne(long id) {
        return personRepository.getOne(id);
    }
}



