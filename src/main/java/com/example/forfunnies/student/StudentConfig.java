package com.example.forfunnies.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {

           Student vicke = new Student(
                    "Vicke",
                    "vicke.trossing@mail.com",
                    LocalDate.of(1993, 7, 13)
            );

           Student marcus =  new Student(
                    "Marcus",
                    "marcus.greekgod@mail.com",
                    LocalDate.of(1995, 5, 4)
            );

            repository.saveAll(
                    List.of(vicke, marcus)
            );
        };
    }
}
