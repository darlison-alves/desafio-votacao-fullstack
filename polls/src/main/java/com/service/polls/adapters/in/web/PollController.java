package com.service.polls.adapters.in.web;

import com.service.polls.application.dto.PollDTO;
import com.service.polls.domain.model.Poll;
import com.service.polls.ports.in.ICreatePollUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polls")
public class PollController {
    private final ICreatePollUseCase createPollUseCase;

    public PollController(ICreatePollUseCase createPollUseCase) {
        this.createPollUseCase = createPollUseCase;
    }

    @PostMapping
    public ResponseEntity<Poll> create(@RequestBody PollDTO pollDTO) {
        Poll poll = createPollUseCase.execute(pollDTO);
        return ResponseEntity.ok(poll);
    }
}
