package com.ing.tech;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public class Car {
   private Optional<Insurance> insurance;

}