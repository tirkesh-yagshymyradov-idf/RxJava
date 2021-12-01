package com.mm.collection.repository;

import com.mm.collection.model.CollectorCreditModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CollectorCreditRepository {

  Mono<CollectorCreditModel> getById(long id);

  Mono<Void> add(CollectorCreditModel collectorModel);

  Flux<CollectorCreditModel> getAll(long seek, long limit);
}
