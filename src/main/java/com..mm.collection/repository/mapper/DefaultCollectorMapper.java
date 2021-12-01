package com.mm.collection.repository.mapper;

import com.mm.collection.db.tables.records.CollectorRecord;
import com.mm.collection.model.CollectorModel;

public class DefaultCollectorMapper implements CollectorMapper {

  @Override
  public CollectorModel mapFromRecord(CollectorRecord collectorRec) {
    return new CollectorModel(
        collectorRec.getId(),
        collectorRec.getFirstName(),
        collectorRec.getLastName(),
        collectorRec.getActivityStatus());
  }

  @Override
  public CollectorRecord mapToRecord(CollectorModel collectorModel) {
    return new CollectorRecord(
        collectorModel.getId(),
        collectorModel.getFirstName(),
        collectorModel.getLastName(),
        collectorModel.getActivityStatus()
    );
  }
}
