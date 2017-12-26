package ru.bis.teammanager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.bis.teammanager.model.Person;
import ru.bis.teammanager.service.PersonService;

import java.util.List;


@Controller
@RequestMapping(value = "/person")
//@RequestMapping(value = "/teammanager/person")
public class AppController {

    @Autowired
    private PersonService personService;

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

    @RequestMapping(value = "/")
    public String createPerson(Model model2) {
        Person person = new Person("Andrey", "Turubchuk");
        Person person2 = new Person("Andrey2", "Turubchuk2");
        personService.savePerson(person);
        personService.savePerson(person2);
        List<Person> personList = personService.getAll();
        model2.addAttribute("personList", personList);
        return "personList";
    }
}



