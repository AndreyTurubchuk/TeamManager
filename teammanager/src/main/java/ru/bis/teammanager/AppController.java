package ru.bis.teammanager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bis.teammanager.model.User;
import ru.bis.teammanager.service.UserService;

import java.util.List;


@RestController
@RequestMapping(value = "/teammanager/rest/users")
public class AppController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/save")
    public void saveUser() {
        User user = new User("Andrey", "Turubchuk");
        User user2 = new User("Andrey2", "Turubchuk2");
        userService.saveUser(user);
        userService.saveUser(user2);
    }






}



