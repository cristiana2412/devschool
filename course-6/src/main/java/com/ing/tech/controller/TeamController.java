package com.ing.tech.controller;

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
        TeamDTO savedTeam = teamService.createTeam(team);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedTeam);
    }

    @PutMapping("/{teamId}/{personId}")
    public ResponseEntity addMember(@PathVariable Long teamId, @PathVariable Long personId) {
        TeamDTO updatedTeam = teamService.addMember(teamId, personId);

        return ResponseEntity.status(HttpStatus.OK).body(updatedTeam);
    }

    @DeleteMapping("/{teamId}/{personId}")
    public ResponseEntity removeMember(@PathVariable Long teamId, @PathVariable Long personId) {
        TeamDTO updatedTeam = teamService.removeMember(teamId, personId);

        return ResponseEntity.status(HttpStatus.OK).body(updatedTeam);
    }

    @GetMapping("/{id}")
    public ResponseEntity retrieveTeamMembers(@PathVariable Long id) {
        return ResponseEntity.ok(teamService.retrieveTeam(id));
    }
}