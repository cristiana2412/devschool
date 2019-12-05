package com.ing.tech.service;

import com.ing.tech.model.Person;
import com.ing.tech.model.dto.PersonDTO;
import com.ing.tech.repository.PersonRepository;
import com.ing.tech.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service @Transactional @RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public PersonDTO retrievePerson(Long id) {
        Person person = personRepository.findById(id).orElse(null);
        String teamName;
        if (person.getTeam() == null){
            teamName = "";
        } else {
            teamName = person.getTeam().getName();
        }

        return new PersonDTO(person.getFirstName(), person.getLastName(), teamName);
    }

    public PersonDTO save(PersonDTO person) {
        Person savedPerson = personRepository.save(new Person(person.getFirstName(), person.getLastName()));

        return new PersonDTO(savedPerson.getFirstName(), savedPerson.getLastName());
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    public List<PersonDTO> retrieveAll() {
        Iterator<Person> personsIterator = personRepository.findAll().iterator();
        String teamName;
        List<PersonDTO> persons = new ArrayList<>();
        while (personsIterator.hasNext()) {
            Person currentPerson = personsIterator.next();
            if (currentPerson.getTeam() == null){
                teamName = "";
            } else {
                teamName = currentPerson.getTeam().getName();
            }
            persons.add(new PersonDTO(
                    currentPerson.getFirstName(),
                    currentPerson.getLastName(),
                    teamName));
        }

        return persons;
    }
}