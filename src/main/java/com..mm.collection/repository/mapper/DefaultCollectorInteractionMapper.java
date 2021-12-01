package com.mm.collection.repository.mapper;

import com.mm.collection.db.tables.records.CollectorInteractionRecord;
import com.mm.collection.model.CollectorInteractionModel;

public class DefaultCollectorInteractionMapper implements CollectorInteractionMapper {

  @Override
  public CollectorInteractionModel mapFromRecord(CollectorInteractionRecord collectorRec) {
    return new CollectorInteractionModel(
        collectorRec.getId(),
        collectorRec.getCollectorCreditId(),
        collectorRec.getInteractionDate(),
        collectorRec.getInteractionType(),
        collectorRec.getInteractionStatus());
  }

  @Override
  public CollectorInteractionRecord mapToRecord(CollectorInteractionModel model) {
    return new CollectorInteractionRecord(
        model.getId(),
        model.getCollectorCreditId(),
        model.getInteractionDate(),
        model.getInteractionType(),
        model.getInteractionStatus());
  }
}
