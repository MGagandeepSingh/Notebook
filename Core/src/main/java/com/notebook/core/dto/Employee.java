package com.notebook.core.dto;

import lombok.Builder;

public record Employee(String firstName,
                       String lastName,
                       boolean isPermanent,
                       int salary,
                       String designation) {

    @SuppressWarnings("all")
    @Builder(toBuilder = true)
    public Employee {
    }
}
