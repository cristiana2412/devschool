package com.ing.tech;

import com.ing.tech.model.Person;
import com.ing.tech.model.Team;
import com.ing.tech.repository.PersonRepository;
import com.ing.tech.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMainApplication implements CommandLineRunner {
    private PersonRepository personRepository;
    private TeamRepository teamRepository;

    public SpringMainApplication(PersonRepository personRepository, TeamRepository teamRepository){
        this.personRepository = personRepository;
        this.teamRepository = teamRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMainApplication.class, args);
    }

    @Override
    public void run (String... args) throws Exception{
        personRepository.save(new Person("Smith","John"));
        personRepository.save(new Person("Popescu","Andrei"));
        Team superHeroes = new Team("SuperHeroes");
        teamRepository.save(superHeroes);
        Person echipescu = new Person("Echipescu","Andrei");
        echipescu.setTeam(superHeroes);
        personRepository.save(echipescu);

//        System.out.println(teamRepository.findById(1L).get().getName());
    }
}
