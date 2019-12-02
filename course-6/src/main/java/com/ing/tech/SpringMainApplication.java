package com.ing.tech;

import com.ing.tech.model.Person;
import com.ing.tech.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMainApplication implements CommandLineRunner {
    private PersonRepository personRepository;

    public SpringMainApplication(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMainApplication.class, args);
    }

    @Override
    public void run (String... args) throws Exception{
        personRepository.save(new Person("Stefan","Contra"));
    }
}
