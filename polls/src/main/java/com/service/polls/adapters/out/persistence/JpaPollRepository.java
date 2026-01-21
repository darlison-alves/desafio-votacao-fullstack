package com.service.polls.adapters.out.persistence;

import com.service.polls.adapters.out.persistence.entities.PollEntity;
import com.service.polls.domain.exceptions.NotFoundException;
import com.service.polls.domain.model.Poll;
import com.service.polls.ports.out.IPollRepository;
import org.springframework.stereotype.Repository;

@Repository
public class JpaPollRepository implements IPollRepository {

    private final SpringDataPollRepository repo;

    public JpaPollRepository(SpringDataPollRepository repo) {
        this.repo = repo;
    }

    @Override
    public Poll save(Poll poll) {
        var entity = this.repo.save(PollEntity.of(poll));
        poll.setId(entity.getId());
        return poll;
    }

    @Override
    public Poll findById(Long id) {
        return this.repo.findById(id).map(PollEntity::to).orElseThrow(() -> new NotFoundException("Pauta"));
    }
}
