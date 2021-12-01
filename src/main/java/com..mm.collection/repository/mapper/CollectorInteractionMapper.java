package com.mm.collection.repository.mapper;

import com.mm.collection.db.tables.records.CollectorInteractionRecord;
import com.mm.collection.model.CollectorInteractionModel;

public interface CollectorInteractionMapper {

  CollectorInteractionModel mapFromRecord(CollectorInteractionRecord collectorRec);

  CollectorInteractionRecord mapToRecord(CollectorInteractionModel user);
}
