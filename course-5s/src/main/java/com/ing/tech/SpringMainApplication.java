package com.ing.tech;

import com.ing.tech.configuration.ConfigProperties;
import com.ing.tech.configuration.DoSomething;
import com.ing.tech.profile.Example;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
public class SpringMainApplication implements CommandLineRunner {

    @Autowired
    private DoSomething doSomething;

    @Autowired
    private ConfigProperties configProperties;

    @Value("${threads}")
    private String numberOfThreads;

    @Autowired
    private List<Example> examples;

    @Override
    public void run(String... args) throws Exception {
        log.info(String.valueOf(examples.size()));
        doSomething.log();
        log.info(numberOfThreads);
        log.info(configProperties.getApi());
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringMainApplication.class, args);
    }
}
