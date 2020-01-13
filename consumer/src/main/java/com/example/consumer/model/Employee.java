package com.example.consumer.model;

import lombok.Data;

@Data
public class Employee {
    private long id;
    private String name;

    public Employee(){}

    public Employee(long id1, String name1){
        id=id1;
        name=name1;
    }
}
