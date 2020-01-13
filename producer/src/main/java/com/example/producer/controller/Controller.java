package com.example.producer.controller;


import com.example.producer.model.Employee;
import com.example.producer.repository.EmployeeRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    private final EmployeeRepository repo;

    Controller(EmployeeRepository repos){
        repo=repos;
    }

    @GetMapping("/employees")
    List<Employee> all(){
        return repo.findAll();
    }

    @PostMapping("/employee")
    @HystrixCommand(fallbackMethod = "fallback")
    Employee save(@RequestBody Employee newEmp){
        throw new RuntimeException();
        //return repo.save(newEmp);
    }

    @GetMapping("/employees/{id}")
    Optional<Employee> getOne(@PathVariable long id){
        return repo.findById(id);
    }

    @DeleteMapping("/employees/{id}")
    void deleteOne(@PathVariable long id){
        repo.deleteById(id);
    }

    Employee fallback(@RequestBody Employee newEmp){
        return new Employee("name");
    }

}
