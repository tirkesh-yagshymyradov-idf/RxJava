package com.mm.collection.repository;

import com.mm.collection.model.CollectorModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CollectorRepository {

  Mono<CollectorModel> getById(long id);

  Mono<Void> add(CollectorModel collectorModel);

  Flux<CollectorModel> getAll(long seek, long limit);
}
