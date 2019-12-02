package com.ing.tech.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @JoinColumn
    @ManyToOne
    private Team team;

    public Person (String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
