package com.mm.collection.converter;

import com.mm.collection.model.CollectorInteractionStatus;
import org.jooq.impl.EnumConverter;

public class CollectorInteractionStatusConverter extends EnumConverter<String, CollectorInteractionStatus> {

  public CollectorInteractionStatusConverter() {
    super(String.class, CollectorInteractionStatus.class);
  }
}
