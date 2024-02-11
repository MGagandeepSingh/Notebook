package com.notebook.dto;

import lombok.Builder;

public record Employee(String firstName,
                       String lastName,
                       boolean isPermanent,
                       int salary) {

    @SuppressWarnings("all")
    @Builder(toBuilder = true)
    public Employee {
    }
}
