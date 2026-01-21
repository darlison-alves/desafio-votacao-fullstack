package com.service.polls.adapters.out.persistence.entities;

import com.service.polls.domain.model.Poll;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
@Entity
@Table(name = "polls")
public class PollEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Instant startsAt;
    private Instant endsAt;

    public static PollEntity of(Poll poll) {

        return PollEntity.builder()
                .id(poll.getId())
                .title(poll.getTitle())
                .startsAt(poll.getStartsAt())
                .endsAt(poll.getEndsAt())
                .build();
    }

    public Poll to() {
        return Poll.builder()
                .id(this.id)
                .title(this.title)
                .startsAt(this.startsAt)
                .endsAt(this.endsAt)
                .build();
    }
}
