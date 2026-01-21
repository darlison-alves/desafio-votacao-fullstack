package com.service.polls.domain.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String value) {
        super(String.format("Não encontrado: %s", value));
    }
}
