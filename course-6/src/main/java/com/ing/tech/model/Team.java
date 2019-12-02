package com.ing.tech.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
public class Team {
    private Long id;
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private Set<Person> members = new HashSet<>();

    public Team (String name, Set<Person> members){
        this.name = name;
        this.members = members;
    }

    public void addTeamMember(Person member){
        members.add(member);
    }
}
