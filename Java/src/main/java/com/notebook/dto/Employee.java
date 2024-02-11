package com.notebook.dto;

public record Employee(String firstName,
                       String lastName,
                       boolean isPermanent,
                       int salary) {

    public Employee {
    }
}
