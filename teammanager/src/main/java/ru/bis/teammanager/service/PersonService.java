package ru.bis.teammanager.service;

import ru.bis.teammanager.model.Person;

import java.util.List;

public interface PersonService {
   List<Person> getAll();
   void saveUser(Person person);
   }
