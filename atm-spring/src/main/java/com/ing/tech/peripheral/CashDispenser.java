package com.ing.tech.peripheral;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
public class CashDispenser {
    @Value("${dispenser.amount}")
    private String amount;
}
