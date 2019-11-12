package com.ing.tech;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Account {
    @Getter
    private int id;
    private int pin;

    @Getter
    @Setter
    private double balance;

    public boolean checkPin(int pin) {
        return this.pin == pin;
    }

}
