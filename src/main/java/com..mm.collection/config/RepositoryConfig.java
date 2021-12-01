package com.mm.collection.config;

import com.mm.collection.repository.CollectorCreditRepository;
import com.mm.collection.repository.CollectorInteractionRepository;
import com.mm.collection.repository.CollectorRepository;
import com.mm.collection.repository.DefaultCollectorCreditRepository;
import com.mm.collection.repository.DefaultCollectorInteractionRepository;
import com.mm.collection.repository.DefaultCollectorRepository;
import com.mm.collection.repository.mapper.DefaultCollectorCreditMapper;
import com.mm.collection.repository.mapper.DefaultCollectorInteractionMapper;
import com.mm.collection.repository.mapper.DefaultCollectorMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

  private final JooqConfig jooqConfig;

  public RepositoryConfig(JooqConfig jooqConfig) {
    this.jooqConfig = jooqConfig;
  }

  @Bean
  public CollectorRepository collectorRepository() {
    return new DefaultCollectorRepository(jooqConfig.dslContext(), new DefaultCollectorMapper());
  }

  @Bean
  public CollectorCreditRepository collectorCreditRepository() {
    return new DefaultCollectorCreditRepository(jooqConfig.dslContext(), new DefaultCollectorCreditMapper());
  }

  @Bean
  public CollectorInteractionRepository collectorInteractionRepository() {
    return new DefaultCollectorInteractionRepository(jooqConfig.dslContext(), new DefaultCollectorInteractionMapper());
  }
}
