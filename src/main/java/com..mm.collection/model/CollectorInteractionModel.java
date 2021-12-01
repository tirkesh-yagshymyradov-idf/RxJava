package com.mm.collection.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class CollectorInteractionModel {

  private final Long id;
  private final Long collectorCreditId;
  private final LocalDateTime interactionDate;
  private final CollectorInteractionType interactionType;
  private final CollectorInteractionStatus interactionStatus;

  @JsonCreator
  public CollectorInteractionModel(
      @JsonProperty("id") Long id,
      @JsonProperty("collectorCreditId") Long collectorCreditId,
      @JsonProperty("interactionDate") LocalDateTime interactionDate,
      @JsonProperty("interactionType") CollectorInteractionType interactionType,
      @JsonProperty("interactionStatus") CollectorInteractionStatus interactionStatus) {
    this.id = id;
    this.collectorCreditId = collectorCreditId;
    this.interactionDate = interactionDate;
    this.interactionType = interactionType;
    this.interactionStatus = interactionStatus;
  }

  public Long getId() {
    return id;
  }

  public Long getCollectorCreditId() {
    return collectorCreditId;
  }

  public LocalDateTime getInteractionDate() {
    return interactionDate;
  }

  public CollectorInteractionType getInteractionType() {
    return interactionType;
  }

  public CollectorInteractionStatus getInteractionStatus() {
    return interactionStatus;
  }
}
