package org.example.config;

import org.aspectj.lang.annotation.Before;
import org.example.aspacts.Helper;
import org.example.aspacts.Security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages={"org.example.services",
        "org.example.proxy",
        "org.example.repositories",
        "org.example.repositories"})
@EnableAspectJAutoProxy
public class ProjectConfiguration {

    @Bean
    public Helper aspect() {
        return  new Helper();
    }

    @Bean
    public Security secure() {
        return new Security();
    }
}
