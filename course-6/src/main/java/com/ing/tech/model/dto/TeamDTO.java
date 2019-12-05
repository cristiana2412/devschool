package com.ing.tech.model.dto;

import com.ing.tech.model.Person;
import lombok.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Transactional(propagation = Propagation.REQUIRED)
public class TeamDTO {
    private String name;
    private List<Person> members;

    public TeamDTO(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }
}
