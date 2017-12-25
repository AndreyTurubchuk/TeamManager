package ru.bis.teammanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "ru.bis.teammanager")
public class TeammanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeammanagerApplication.class, args);
	}
}
