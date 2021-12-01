package com.mm.collection.converter;

import com.mm.collection.model.CollectorActivityStatus;
import org.jooq.impl.EnumConverter;

public class CollectorActivityStatusConverter extends EnumConverter<String, CollectorActivityStatus> {

  public CollectorActivityStatusConverter() {
    super(String.class, CollectorActivityStatus.class);
  }
}
