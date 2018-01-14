package ru.bis.teammanager.service;

import ru.bis.teammanager.model.Person;

import java.util.List;


public interface PersonService {
   List<Person> getAll();
   Person getOne(long id);
   void savePerson(Person person);
   void editPerson(long id, Person person);
   void delete(long id);
   }

