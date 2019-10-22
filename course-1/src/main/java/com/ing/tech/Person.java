package com.ing.tech;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Person {
    private String lastname;
    private String firstname;
    private int age;
    private String job;
}
