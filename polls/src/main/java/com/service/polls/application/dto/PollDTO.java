package com.service.polls.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PollDTO {
    String title;
    long durationMinutes;
}
