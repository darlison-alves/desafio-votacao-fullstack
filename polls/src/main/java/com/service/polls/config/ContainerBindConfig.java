package com.service.polls.config;

import com.service.polls.application.usecases.CreatePollUseCase;
import com.service.polls.application.usecases.ListPollUseCase;
import com.service.polls.ports.in.ICreatePollUseCase;
import com.service.polls.ports.in.IListPollsUseCase;
import com.service.polls.ports.out.IPollRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContainerBindConfig {

    @Bean
    ICreatePollUseCase createPollUseCase(IPollRepository pollRepository) {
        return new CreatePollUseCase(pollRepository);
    }

    @Bean
    IListPollsUseCase listPollsUseCase(IPollRepository pollRepository) {
        return new ListPollUseCase(pollRepository);
    }
}
