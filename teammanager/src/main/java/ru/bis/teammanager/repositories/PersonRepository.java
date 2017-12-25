package ru.bis.teammanager.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.bis.teammanager.model.Person;


public interface PersonRepository extends JpaRepository<Person, Long> {
}
