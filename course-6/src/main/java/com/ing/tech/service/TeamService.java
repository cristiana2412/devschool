package com.ing.tech.service;

import com.ing.tech.model.Person;
import com.ing.tech.model.Team;
import com.ing.tech.model.dto.PersonDTO;
import com.ing.tech.model.dto.TeamDTO;
import com.ing.tech.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public TeamDTO retrieveTeam(Long id) {
        Optional<Team> optionalTeam = teamRepository.findById(id);

        return optionalTeam
                .map(team ->
                        new TeamDTO(team.getName(), team.getMembers()))
                .orElse(null);
    }

    public TeamDTO save(TeamDTO team) {
        Team savedTeam = teamRepository.save(new Team(team.getName(), team.getMembers()));

        return new TeamDTO(savedTeam.getName(), savedTeam.getMembers());
    }

    public TeamDTO addMember(TeamDTO team, PersonDTO member) {
        team.addTeamMember(new Person(member.getFirstName(), member.getLastName()));
        Team updatedTeam =
                teamRepository.save(new Team(team.getName(), team.getMembers()));

        return new TeamDTO(updatedTeam.getName(), updatedTeam.getMembers());
    }

    public void delete(Long id) {
        teamRepository.deleteById(id);
    }

    public List<TeamDTO> retrieveAll() {
        Iterator<Team> teamsIterator = teamRepository.findAll().iterator();

        List<TeamDTO> teams = new ArrayList<>();
        while (teamsIterator.hasNext()) {
            Team currentTeam = teamsIterator.next();
            teams.add(new TeamDTO(
                    currentTeam.getName(),
                    currentTeam.getMembers()));
        }

        return teams;
    }
}
