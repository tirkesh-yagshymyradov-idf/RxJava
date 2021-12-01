package com.mm.collection.repository;

import static com.mm.collection.db.tables.CollectorCredit.COLLECTOR_CREDIT;

import com.mm.collection.model.CollectorCreditModel;
import com.mm.collection.repository.mapper.CollectorCreditMapper;
import org.jooq.DSLContext;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class DefaultCollectorCreditRepository implements CollectorCreditRepository {

  private final DSLContext dslContext;
  private final CollectorCreditMapper collectorCreditMapper;

  public DefaultCollectorCreditRepository(DSLContext dslContext,
      CollectorCreditMapper collectorCreditMapper) {
    this.dslContext = dslContext;
    this.collectorCreditMapper = collectorCreditMapper;
  }

  @Override
  public Mono<CollectorCreditModel> getById(long id) {
    return Mono.fromCallable(() ->
        dslContext
            .selectFrom(COLLECTOR_CREDIT)
            .where(COLLECTOR_CREDIT.ID.eq(id))
            .fetchOne()
    ).map(collectorCreditMapper::mapFromRecord);
  }

  @Override
  public Mono<Void> add(CollectorCreditModel collectorModel) {
    return Mono.fromCallable(() ->
        dslContext
            .insertInto(COLLECTOR_CREDIT)
            .set(collectorCreditMapper.mapToRecord(collectorModel))
            .execute()
    ).then();
  }

  @Override
  public Flux<CollectorCreditModel> getAll(long seek, long limit) {
    return Flux.from(
        dslContext
            .selectFrom(COLLECTOR_CREDIT)
            .orderBy(COLLECTOR_CREDIT.ID)
            .seek(seek)
            .limit(limit)
    ).map(collectorCreditMapper::mapFromRecord);
  }
}
