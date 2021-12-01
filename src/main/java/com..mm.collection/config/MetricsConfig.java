package com.mm.collection.config;

import com.mm.micrometer.MetricsBuilder;
import com.mm.micrometer.spring.MetricsController;
import com.mm.model.AppProperties;
import io.micrometer.prometheus.PrometheusMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfig {

  @Bean
  public MetricsController metricsController() {
    return new MetricsController(prometheusMeterRegistry());
  }

  @Bean
  public PrometheusMeterRegistry prometheusMeterRegistry() {
    return new MetricsBuilder()
        .applicationName(System.getProperty(AppProperties.COMPONENT_NAME_PROPERTY))
        .build();
  }
}
