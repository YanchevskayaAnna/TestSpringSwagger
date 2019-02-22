package com.epam.producing.testProject.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super("Could not found employee " + id);
    }
}
