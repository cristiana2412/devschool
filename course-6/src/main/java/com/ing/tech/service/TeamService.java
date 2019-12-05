package com.ing.tech.service;

import com.ing.tech.model.Person;
import com.ing.tech.model.Team;
import com.ing.tech.model.dto.TeamDTO;
import com.ing.tech.repository.PersonRepository;
import com.ing.tech.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service @Transactional
public class TeamService {

    private final TeamRepository teamRepository;
    private final PersonRepository personRepository;

    public TeamDTO retrieveTeam(Long id) {
        Team team = teamRepository.findById(id).orElse(null);
        if (team == null) return null;

        List<Person> members = personRepository.findByTeamId(team.getId());
        if (members == null) return null;

        return new TeamDTO(team.getName(), members);
    }

    public TeamDTO createTeam(TeamDTO team) {
        Team savedTeam = teamRepository.save(new Team(team.getName()));

        return new TeamDTO(savedTeam.getName());
    }

    public TeamDTO addMember(Long teamId, Long memberId) {
        Team team = teamRepository.findById(teamId).orElse(null);
        if (team == null) return null;

        Person member = personRepository.findById(memberId).orElse(null);
        if (member == null) return null;

        List<Person> allMembers = personRepository.findByTeamId(teamId);

        member.setTeam(team);
        personRepository.save(member);

        return new TeamDTO(team.getName(), allMembers);
    }

    public TeamDTO removeMember(Long teamId, Long memberId) {
        Team team = teamRepository.findById(teamId).orElse(null);
        if (team == null) return null;

        Person member = personRepository.findById(memberId).orElse(null);
        if (member == null) return null;

        member.setTeam(null);

        teamRepository.save(team);
        personRepository.save(member);

        return new TeamDTO(team.getName(), personRepository.findByTeamId(teamId));
    }

}
