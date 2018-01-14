package ru.bis.teammanager.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bis.teammanager.model.Letter;
import ru.bis.teammanager.model.Person;
import ru.bis.teammanager.repositories.LetterRepository;
import ru.bis.teammanager.service.LetterService;

import java.util.List;

@Transactional
@Service
public class LetterServiceImpl implements LetterService {

    @Autowired
    private LetterRepository letterRepository;

    @Override
    public Letter createLetter(String personEmailAddress, String subject, String message, Person person) {
        Letter letter = new Letter(personEmailAddress, subject, message, person);
        letterRepository.save(letter);
        return letter;
    }

    @Override
    public List<Letter> findByTo(String to) {
        return letterRepository.findByToOrderByTo(to);
    }


}
