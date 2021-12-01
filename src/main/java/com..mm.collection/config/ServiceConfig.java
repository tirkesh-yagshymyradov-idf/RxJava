package com.mm.collection.config;

import com.mm.collection.controller.CollectorController;
import com.mm.collection.controller.CollectorCreditController;
import com.mm.collection.controller.CollectorInteractionController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

  private final RepositoryConfig repositoryConfig;

  public ServiceConfig(RepositoryConfig repositoryConfig) {
    this.repositoryConfig = repositoryConfig;
  }

  @Bean
  public CollectorController collectorController() {
    return new CollectorController(
        repositoryConfig.collectorRepository());
  }

  @Bean
  public CollectorInteractionController collectorInteractionController(){
    return new CollectorInteractionController(repositoryConfig.collectorInteractionRepository());
  }

  @Bean
  public CollectorCreditController collectorCreditController(){
    return new CollectorCreditController(repositoryConfig.collectorCreditRepository());
  }
}
