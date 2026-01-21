package com.service.polls.adapters.in.web;

import com.service.polls.adapters.out.persistence.entities.PollEntity;
import com.service.polls.application.dto.PollDTO;
import com.service.polls.domain.model.Poll;
import com.service.polls.ports.in.ICreatePollUseCase;
import com.service.polls.ports.in.IListPollsUseCase;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/polls")
public class PollController {
    private final ICreatePollUseCase createPollUseCase;
    private final IListPollsUseCase listPollsUseCase;
    public PollController(ICreatePollUseCase createPollUseCase, IListPollsUseCase listPollsUseCase) {
        this.createPollUseCase = createPollUseCase;
        this.listPollsUseCase = listPollsUseCase;
    }

    @PostMapping
    public ResponseEntity<Poll> create(@RequestBody PollDTO pollDTO) {
        Poll poll = createPollUseCase.execute(pollDTO);
        return ResponseEntity.ok(poll);
    }

    @GetMapping
    public Page<PollEntity> findAll( @RequestParam(defaultValue = "1") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        return listPollsUseCase.execute(page, size);
    }
}
