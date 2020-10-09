package com.self.jupiter.bean;

public class Employee {
    private String name;
    private Long id;

    
    public Employee(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

}
