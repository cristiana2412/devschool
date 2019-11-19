package com.ing.tech.service;

import com.ing.tech.model.Person;
import com.ing.tech.model.dto.PersonDTO;
import com.ing.tech.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDTO retrievePerson(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);

        return optionalPerson
                .map(person ->
                        new PersonDTO(person.getFirstName(), person.getLastName()))
                .orElse(null);
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

        List<PersonDTO> persons = new ArrayList<>();
        while (personsIterator.hasNext()) {
            Person currentPerson = personsIterator.next();
            persons.add(new PersonDTO(
                    currentPerson.getFirstName(),
                    currentPerson.getLastName()));
        }

        return persons;
    }
}
