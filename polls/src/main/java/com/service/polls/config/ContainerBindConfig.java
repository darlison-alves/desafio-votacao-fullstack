package com.service.polls.config;

import com.service.polls.application.usecases.CreatePollUseCase;
import com.service.polls.ports.in.ICreatePollUseCase;
import com.service.polls.ports.out.IPollRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContainerBindConfig {

    @Bean
    ICreatePollUseCase createPollUseCase(IPollRepository pollRepository) {
        return new CreatePollUseCase(pollRepository);
    }
}
