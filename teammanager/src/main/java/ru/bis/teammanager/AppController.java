package ru.bis.teammanager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bis.teammanager.model.Letter;
import ru.bis.teammanager.model.Person;
import ru.bis.teammanager.repositories.PersonRepository;
import ru.bis.teammanager.service.LetterService;
import ru.bis.teammanager.service.NotificationService;
import ru.bis.teammanager.service.PersonService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/person")
//@RequestMapping(value = "/teammanager/person")
public class AppController {

    private final static String MESSAGE_HIRED = "You are hired";
    private final static String MESSAGE_SUBJECT = "Message";

    @Autowired
    private PersonService personService;

    @Autowired
    private LetterService letterService;


    @Autowired
    private NotificationService notificationService;

    @RequestMapping({"/list"})
    public String personList(Model model) {
        List<Person> personList = personService.getAll();
        model.addAttribute("personList", personList);
        return "personList";
    }

    @RequestMapping(value = "/delete/{personId}", method = RequestMethod.GET)
    public String delete(@PathVariable long personId) {
        personService.delete(personId);
        return "redirect:/person/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "personAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add2(Person person) {
        personService.savePerson(person);
        Letter letter = new Letter("sokoldemian1990@mail.ru", person.getEmailAddress(), MESSAGE_SUBJECT, MESSAGE_HIRED, person);
     //   letterService.saveLetter(letter);
        try {
            notificationService.sendNotification(person, letter);
        } catch (MailException e) {
            e.printStackTrace();
        }
        return "redirect:/person/list";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Long id, Model model5) {
        Person person = personService.getOne(id);
        List<Letter> letterList = letterService.findByTo(person.getEmailAddress());
        model5.addAttribute("personLetterList", letterList);
        model5.addAttribute("personFullName", person.getFirstName() + " " + person.getLastName());
        return "personLetterList";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, Model model4) {
        Person person = personService.getOne(id);
        model4.addAttribute("person", person);
        return "personEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(Person person) {
        personService.savePerson(person);
        return "redirect:/person/list";
    }

    @RequestMapping(value = "/")
    public String createPerson(Model model2) {
   //     Person person = new Person("Andrey", "Turubchuk", "antur1977@mail.ru");
   //     Person person2 = new Person("Andrey2", "Turubchuk2", "an2");
     //   personService.savePerson(person);
    //    personService.savePerson(person2);
     //   Letter letter = new Letter("antur1977@mail.ru", "antur1977@mail.ru", "Main Message", "This is s BIS", person);
/*        try {
            notificationService.sendNotification(person2, letter);
        } catch (MailException e) {
            e.printStackTrace();
        }*/
     //   List<Person> personList = personService.getAll();
     //   model2.addAttribute("personList", personList);
        return "personList";
    }

    @RequestMapping(value = "/createmessage")
    public String createMessage(Model model3) {
        Person person = new Person("Andrey", "Turubchuk", "antur1977@mail.ru");
        personService.savePerson(person);
        Letter letter2 = new Letter("antur1977@mail.ru", "antur1977@mail.ru", "Main Message", "This is s BIS", person);
        letterService.saveLetter(letter2);
        List<Letter> letterList2 = letterService.findByTo("antur1977@mail.ru");
        model3.addAttribute("personLetterList", letterList2);
       return "personLetterList";
    }



}



