package org.zerock.restex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ResTexApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResTexApplication.class, args);
    }

}
