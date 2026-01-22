package com.service.polls.application.dto;

import com.service.polls.application.annotations.EnumValidator;
import com.service.polls.application.enums.AnswerEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteDTO {

    @NotNull
    private Long pollId;

    @NotEmpty
    private String document;

    @NotNull
    @EnumValidator(enumClass = AnswerEnum.class)
    private AnswerEnum answer;
}
