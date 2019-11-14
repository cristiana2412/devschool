package com.ing.tech.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "google")
@Getter @Setter
@PropertySource("classpath:google.properties")
public class ConfigProperties {
    private String api;
    private String key;
}
