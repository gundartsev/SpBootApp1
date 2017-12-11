package org.dmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * @author Dmytro Gundartsev (dmytro.gundartsev@embedit.cz) on 11.12.17.
 */

@EnableWebFlux
@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "org.dmi.*")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
