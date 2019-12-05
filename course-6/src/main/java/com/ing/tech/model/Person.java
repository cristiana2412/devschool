package com.ing.tech.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Getter @Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToOne
    private Team team;

    public Person (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person (String firstName, String lastName, Team team){
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
    }


}
