package com.service.polls.adapters.in.web;

import com.service.polls.adapters.out.persistence.entities.PollEntity;
import com.service.polls.application.dto.PollDTO;
import com.service.polls.application.dto.VoteDTO;
import com.service.polls.application.dto.VotedDTO;
import com.service.polls.domain.model.Poll;
import com.service.polls.ports.in.ICreatePollUseCase;
import com.service.polls.ports.in.IListPollsUseCase;
import com.service.polls.ports.in.IVoteUseCase;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/polls")
public class PollController {

    private final ICreatePollUseCase createPollUseCase;
    private final IListPollsUseCase listPollsUseCase;
    private final IVoteUseCase voteUseCase;

    public PollController(ICreatePollUseCase createPollUseCase, IListPollsUseCase listPollsUseCase, IVoteUseCase voteUseCase) {
        this.createPollUseCase = createPollUseCase;
        this.listPollsUseCase = listPollsUseCase;
        this.voteUseCase = voteUseCase;
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

    @PostMapping("/vote")
    public ResponseEntity<VotedDTO> vote(@RequestBody @Valid VoteDTO voteDTO) {
        voteUseCase.execute(voteDTO);
        return ResponseEntity.ok(VotedDTO.builder().message("voto realizado com sucesso!").build());
    }
}
