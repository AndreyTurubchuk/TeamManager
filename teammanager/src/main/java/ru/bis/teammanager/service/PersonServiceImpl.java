package ru.bis.teammanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bis.teammanager.model.Person;
import ru.bis.teammanager.repositories.PersonRepository;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final static String STATUS_OK = "OK";
    private final static String STATUS_ERROR = "ERROR";

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void saveAndFlushPerson(Person person) {
        personRepository.saveAndFlush(person);
    }

    @Override
    public void flushPerson() {
        personRepository.flush();
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public void delete(long id) {
        personRepository.delete(id);
    }

    @Override
    public Person getOne(long id) {
        return personRepository.getOne(id);
    }
}



