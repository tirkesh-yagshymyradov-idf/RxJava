package com.mm.collection.repository.mapper;

import com.mm.collection.db.tables.records.CollectorRecord;
import com.mm.collection.model.CollectorModel;

public interface CollectorMapper {

  CollectorModel mapFromRecord(CollectorRecord collectorRec);

  CollectorRecord mapToRecord(CollectorModel user);

}
