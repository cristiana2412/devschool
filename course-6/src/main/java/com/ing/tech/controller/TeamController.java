package com.ing.tech.controller;

import com.ing.tech.model.Person;
import com.ing.tech.model.dto.PersonDTO;
import com.ing.tech.model.dto.TeamDTO;
import com.ing.tech.service.PersonService;
import com.ing.tech.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/teams")
public class TeamController {

    private TeamService teamService;
    private PersonService personService;

    public TeamController(TeamService teamService, PersonService personService) {
        this.teamService = teamService;
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity createTeam(@RequestBody TeamDTO team) {
        TeamDTO savedTeam = teamService.save(team);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedTeam);
    }

    @PutMapping
    public ResponseEntity addMember(@PathVariable Long teamId, @PathVariable Long personId) {
        PersonDTO person = personService.retrievePerson(personId);
        TeamDTO team = teamService.retrieveTeam(teamId);
        TeamDTO updatedTeam = teamService.addMember(team, person);

        return ResponseEntity.status(HttpStatus.CREATED).body(updatedTeam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMember(@PathVariable Long id) {
        teamService.delete(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity retrieveTeamMembers(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.retrieveTeam(id));
    }
}