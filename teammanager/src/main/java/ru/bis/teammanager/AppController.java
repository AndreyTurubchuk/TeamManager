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

    @RequestMapping({"", "/", "/hello"})
    public String hello2(Model model2, @RequestParam(value = "name", required = false, defaultValue = "Andrey") String name) {
        Person person = new Person("Andrey", "Turubchuk");
        Person person2 = new Person("Andrey2", "Turubchuk2");
        personService.savePerson(person);
        personService.savePerson(person2);
        List<Person> personList = personService.getAll();
        model2.addAttribute("personList", personList);
        //return "personList";
        return "footer2";
    }



    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showUsers(Model model) {
        List<Person> personList = personService.getAll();
        model.addAttribute("personList", personList);
        return "personList";
    }

    @GetMapping("/save")
    public void saveUser() {
        Person person = new Person("Andrey", "Turubchuk");
        Person person2 = new Person("Andrey2", "Turubchuk2");
        personService.savePerson(person);
        personService.savePerson(person2);
    }


}



