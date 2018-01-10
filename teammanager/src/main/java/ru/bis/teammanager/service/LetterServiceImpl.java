package ru.bis.teammanager.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bis.teammanager.model.Letter;
import ru.bis.teammanager.model.Person;
import ru.bis.teammanager.repositories.LetterRepository;
import ru.bis.teammanager.repositories.PersonRepository;

import java.util.List;

@Transactional
@Service
public class LetterServiceImpl implements LetterService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private LetterRepository letterRepository;

    @Override
    public void saveLetter(Letter letter) {
        letterRepository.save(letter);
    }

    @Override
    public List<Letter> getLetterByPerson(Person person) {
        return null;
    }

    @Override
    public List<Letter> findByTo(String to) {
        return letterRepository.findByToOrderByTo(to);
    }


}
