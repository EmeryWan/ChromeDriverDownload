package pers.emery.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"pers.emery.*"})
public class ApplicationConfig {
}
