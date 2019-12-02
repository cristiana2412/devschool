package com.ing.tech.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!dev")
public class ExampleImplementation2 implements Example {
}
