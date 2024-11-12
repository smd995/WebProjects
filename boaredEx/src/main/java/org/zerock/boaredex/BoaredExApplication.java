package org.zerock.boaredex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BoaredExApplication {

    public static void main(String[] args) {

        SpringApplication.run(BoaredExApplication.class, args);
    }

}
