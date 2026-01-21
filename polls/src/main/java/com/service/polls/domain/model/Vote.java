package com.service.polls.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vote {
    private Long pollId;
    private String document;
    private String answer;
}
