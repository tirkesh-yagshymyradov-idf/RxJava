package com.mm.collection.config;

import com.mm.platform.jooq.config.DefaultJooqBuilder;
import com.mm.platform.jooq.config.JooqSettings;
import org.cfg4j.provider.ConfigurationProvider;
import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JooqConfig {

  private final ConfigurationProvider configProvider;

  public JooqConfig(ConfigurationProvider configProvider) {
    this.configProvider = configProvider;
  }

  @Bean
  public DSLContext dslContext() {
    final JooqSettings settings = configProvider.bind("onboarding.jooq", JooqSettings.class);
    return DefaultJooqBuilder.of(settings)
        .withDefaultProviders()
        .build();
  }
}
