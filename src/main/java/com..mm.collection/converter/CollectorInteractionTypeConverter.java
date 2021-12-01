package com.mm.collection.converter;

import com.mm.collection.model.CollectorInteractionType;
import org.jooq.impl.EnumConverter;

public class CollectorInteractionTypeConverter extends EnumConverter<String, CollectorInteractionType> {

  public CollectorInteractionTypeConverter() {
    super(String.class, CollectorInteractionType.class);
  }
}
