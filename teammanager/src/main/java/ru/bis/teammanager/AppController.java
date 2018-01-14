package ru.bis.teammanager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bis.teammanager.model.Letter;
import ru.bis.teammanager.model.Person;
import ru.bis.teammanager.service.LetterService;
import ru.bis.teammanager.service.NotificationService;
import ru.bis.teammanager.service.PersonService;

import java.util.List;


@Controller
@RequestMapping(value = "/person")
public class AppController {

    @Autowired
    private PersonService personService;

    @Autowired
    private LetterService letterService;

    @RequestMapping({"/list"})
    public String personList(Model model) {
        List<Person> personList = personService.getAll();
        model.addAttribute("personList", personList);
        return "personList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable long id) {
        personService.delete(id);
        return "redirect:/person/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return "personAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(Person person) {
        personService.savePerson(person);
        return "redirect:/person/list";
    }

    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Long id, Model model) {
        Person person = personService.getOne(id);
        List<Letter> letterList = letterService.findByTo(person.getEmailAddress());
        model.addAttribute("personLetterList", letterList);
        model.addAttribute("personFullName", person.getFirstName() + " " + person.getLastName());
        return "personLetterList";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable Long id, Model model) {
        Person person = personService.getOne(id);
        model.addAttribute("person", person);
        return "personEdit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable Long id, Person personDetails) {
        personService.editPerson(id, personDetails);
        return "redirect:/person/list";
    }

    @RequestMapping(value = "/")
    public String main() {
        return "personList";
    }
}



