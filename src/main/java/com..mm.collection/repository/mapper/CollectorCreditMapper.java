package com.mm.collection.repository.mapper;

import com.mm.collection.db.tables.records.CollectorCreditRecord;
import com.mm.collection.model.CollectorCreditModel;

public interface CollectorCreditMapper {

  CollectorCreditModel mapFromRecord(CollectorCreditRecord collectorRec);

  CollectorCreditRecord mapToRecord(CollectorCreditModel user);
}
