package com.epam.producing.testProject.exceptions.addressExceptions;

public class AddressNotFoundException extends RuntimeException {

    public AddressNotFoundException(Long id) {
        super("Could not found address " + id);
    }
}
