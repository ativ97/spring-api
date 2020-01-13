package com.example.producer.repository;


import com.example.producer.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class Loader {

    @Bean
    CommandLineRunner init(EmployeeRepository employeeRepository){
    return args -> {
        employeeRepository.save(new Employee("Ativ"));
    };
    }

}
