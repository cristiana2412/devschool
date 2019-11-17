package com.ing.tech.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public DoSomething doSomething() {
        return new DoSomething();
    }
}
