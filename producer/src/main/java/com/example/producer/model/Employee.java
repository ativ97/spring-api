package com.example.producer.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Employee {
    private @Id @GeneratedValue long id;
    private String name;

    public Employee(){
    }

    public Employee(String name1){
        name=name1;
    }


}
