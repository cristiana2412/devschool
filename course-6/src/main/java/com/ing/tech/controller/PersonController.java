package com.ing.tech.controller;

import com.ing.tech.model.dto.PersonDTO;
import com.ing.tech.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/persons")
public class PersonController {

    private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity retrievePerson(@PathVariable Long id) {
        return ResponseEntity.ok(personService.retrievePerson(id));
    }

    @PostMapping
    public ResponseEntity savePerson(@RequestBody PersonDTO person) {
        PersonDTO savedPerson = personService.save(person);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedPerson);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable Long id) {
        personService.delete(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getAllPersons() {
        return ResponseEntity.ok(personService.retrieveAll());
    }



}
