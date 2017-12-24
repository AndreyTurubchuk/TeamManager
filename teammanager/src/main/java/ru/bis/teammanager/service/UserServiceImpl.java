package ru.bis.teammanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bis.teammanager.model.User;
import ru.bis.teammanager.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final static String STATUS_OK = "OK";
    private final static String STATUS_ERROR = "ERROR";

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


}



