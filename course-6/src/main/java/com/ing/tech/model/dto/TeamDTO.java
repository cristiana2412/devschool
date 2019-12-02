package com.ing.tech.model.dto;

import com.ing.tech.model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeamDTO {
    String name;
    private Set<Person> members = new HashSet<>();

    public void addTeamMember(Person member){
        members.add(member);
    }
}
