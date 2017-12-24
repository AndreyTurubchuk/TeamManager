package ru.bis.teammanager.service;

import ru.bis.teammanager.model.User;

import java.util.List;

public interface UserService {
   List<User> getAll();
   void saveUser(User user);
   }
