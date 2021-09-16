package com.example.forfunnies;

import com.example.forfunnies.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ForFunniesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForFunniesApplication.class, args);
    }
}
