package com.ap0stole.hackathon.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.ap0stole.hackathon.dao.repositories")
@EntityScan("com.ap0stole.hackathon.dao.models")
@RequiredArgsConstructor
public class PersistenceConfig {

}
