package com.ulianaafonina.spring.spring_introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.ulianaafonina.spring.spring_introduction")
public class MyConfig {

    @Bean
    public Pet catBean () {
        return new Cat();
    }

}
