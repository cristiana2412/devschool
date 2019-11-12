package com.ing.tech;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@AllArgsConstructor
@Getter
public class Person {
    private int age;
    private Optional<Car> car;
} 