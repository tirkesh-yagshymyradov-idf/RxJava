package com.mm.collection;

import com.mm.base.MMAppBuilder;
import com.mm.base.config.DefaultSpringAppConfig;
import com.mm.base.config.ObjectMapperWebFluxConfigurer;
import com.mm.collection.config.JacksonConfig;
import com.mm.collection.config.JooqConfig;
import com.mm.collection.config.MetricsConfig;
import com.mm.collection.config.RepositoryConfig;
import com.mm.collection.config.ServiceConfig;

public class CollectionApp {

  public static void main(String[] args) {
    new MMAppBuilder()
        .sources(
            DefaultSpringAppConfig.class,
            ObjectMapperWebFluxConfigurer.class,
            ServiceConfig.class,
            JacksonConfig.class,
            RepositoryConfig.class,
            MetricsConfig.class,
            JooqConfig.class
        )
        .run(8888, "lab", "collection");
  }
}
