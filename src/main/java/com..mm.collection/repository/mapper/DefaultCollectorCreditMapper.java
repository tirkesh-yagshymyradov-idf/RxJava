package com.mm.collection.repository.mapper;

import com.mm.collection.db.tables.records.CollectorCreditRecord;
import com.mm.collection.model.CollectorCreditModel;

public class DefaultCollectorCreditMapper implements CollectorCreditMapper {

  @Override
  public CollectorCreditModel mapFromRecord(CollectorCreditRecord collectorRec) {
    return new CollectorCreditModel(
        collectorRec.getId(),
        collectorRec.getCreditId(),
        collectorRec.getCollectorId(),
        collectorRec.getCollectorCreditStatus(),
        collectorRec.getStatusDate()
    );
  }

  @Override
  public CollectorCreditRecord mapToRecord(CollectorCreditModel model) {
    return new CollectorCreditRecord(
        model.getId(),
        model.getCreditId(),
        model.getCollectorId(),
        model.getCollectorCreditStatus(),
        model.getStatusDate()
    );
  }
}
