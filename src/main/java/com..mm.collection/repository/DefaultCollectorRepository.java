package com.mm.collection.repository;

import static com.mm.collection.db.Tables.COLLECTOR;

import com.mm.collection.model.CollectorModel;
import com.mm.collection.repository.mapper.CollectorMapper;
import org.jooq.DSLContext;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class DefaultCollectorRepository implements CollectorRepository {

  private final DSLContext dslContext;
  private final CollectorMapper collectorMapper;

  public DefaultCollectorRepository(DSLContext dslContext, CollectorMapper collectorMapper) {
    this.dslContext = dslContext;
    this.collectorMapper = collectorMapper;
  }

  @Override
  public Mono<CollectorModel> getById(long id) {
    return Mono.fromCallable(() ->
        dslContext
            .selectFrom(COLLECTOR)
            .where(COLLECTOR.ID.eq(id))
            .fetchOne()
    ).map(collectorMapper::mapFromRecord);
  }

  @Override
  public Mono<Void> add(CollectorModel collectorModel) {
    return Mono.fromCallable(() ->
        dslContext
            .insertInto(COLLECTOR)
            .set(collectorMapper.mapToRecord(collectorModel))
            .execute()
    ).then();
  }

  @Override
  public Flux<CollectorModel> getAll(long seek, long limit) {
    return Flux.from(
        dslContext
            .selectFrom(COLLECTOR)
            .orderBy(COLLECTOR.ID)
            .seek(seek)
            .limit(limit)
    ).map(collectorMapper::mapFromRecord);
  }
}
