package org.zerock.spring1.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.zerock.spring1.di.entity.Exam;
import org.zerock.spring1.di.entity.NewlecExam;

@Configuration
@ComponentScan("org.zerock.spring1.di.ui")
public class NewlecDIConfig {

    @Bean
    public Exam exam() {
        return new NewlecExam();
    }

}
