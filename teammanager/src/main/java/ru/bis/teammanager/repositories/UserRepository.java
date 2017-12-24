package ru.bis.teammanager.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.bis.teammanager.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
}
