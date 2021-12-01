package com.mm.collection.repository;

import com.mm.collection.model.CollectorInteractionModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CollectorInteractionRepository {

  Mono<CollectorInteractionModel> getById(long id);

  Mono<Void> add(CollectorInteractionModel collectorModel);

  Flux<CollectorInteractionModel> getAll(long seek, long limit);
}
