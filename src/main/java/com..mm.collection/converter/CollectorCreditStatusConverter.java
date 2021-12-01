package com.mm.collection.converter;

import com.mm.collection.model.CollectorCreditStatus;
import org.jooq.impl.EnumConverter;

public class CollectorCreditStatusConverter extends EnumConverter<String, CollectorCreditStatus> {

  public CollectorCreditStatusConverter() {
    super(String.class, CollectorCreditStatus.class);
  }
}
