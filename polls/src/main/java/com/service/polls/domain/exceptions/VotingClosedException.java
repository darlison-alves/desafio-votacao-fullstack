package com.service.polls.domain.exceptions;

import org.springframework.http.HttpStatus;

public class VotingClosedException extends BusinessException {
    public VotingClosedException() {
        super(HttpStatus.BAD_REQUEST, "Votação encerrada");
    }
}
