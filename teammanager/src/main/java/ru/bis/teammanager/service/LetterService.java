package ru.bis.teammanager.service;

import ru.bis.teammanager.model.Letter;
import ru.bis.teammanager.model.Person;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


public interface LetterService {
    Letter createLetter(String personEmailAddress, String subject, String message, Person person);
    List<Letter> findByTo(String to);
}
