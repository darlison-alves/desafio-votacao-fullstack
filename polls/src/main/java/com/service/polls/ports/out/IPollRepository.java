package com.service.polls.ports.out;

import com.service.polls.domain.model.Poll;

public interface IPollRepository {
    Poll save(Poll poll);
    Poll findById(Long id);
}
