package com.mm.collection.repository;

import static com.mm.collection.db.Tables.COLLECTOR_INTERACTION;

import com.mm.collection.model.CollectorInteractionModel;
import com.mm.collection.repository.mapper.CollectorInteractionMapper;
import org.jooq.DSLContext;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class DefaultCollectorInteractionRepository implements CollectorInteractionRepository {

  private final DSLContext context;
  private final CollectorInteractionMapper mapper;

  public DefaultCollectorInteractionRepository(DSLContext context,
      CollectorInteractionMapper mapper) {
    this.context = context;
    this.mapper = mapper;
  }

  @Override
  public Mono<CollectorInteractionModel> getById(long id) {
    return Mono.fromCallable(() ->
        context
            .selectFrom(COLLECTOR_INTERACTION)
            .where(COLLECTOR_INTERACTION.ID.eq(id))
            .fetchOne()
    ).map(mapper::mapFromRecord);
  }

  @Override
  public Mono<Void> add(CollectorInteractionModel collectorModel) {
    return Mono.fromCallable(() ->
        context
            .insertInto(COLLECTOR_INTERACTION)
            .set(mapper.mapToRecord(collectorModel))
            .execute()
    ).then();
  }

  @Override
  public Flux<CollectorInteractionModel> getAll(long seek, long limit) {
    return Flux.from(
        context
            .selectFrom(COLLECTOR_INTERACTION)
            .orderBy(COLLECTOR_INTERACTION.ID)
            .seek(seek)
            .limit(limit)
    ).map(mapper::mapFromRecord);
  }
}
