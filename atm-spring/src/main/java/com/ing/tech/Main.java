package com.ing.tech;

import com.ing.tech.controller.ATM;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Main implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        ATM atm = new ATM();
        atm.run();
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
