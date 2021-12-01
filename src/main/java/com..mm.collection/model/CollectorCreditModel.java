package com.mm.collection.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class CollectorCreditModel {

  private final Long id;
  private final Long creditId;
  private final Long collectorId;
  private final CollectorCreditStatus collectorCreditStatus;
  private final LocalDateTime statusDate;

  @JsonCreator
  public CollectorCreditModel(
      @JsonProperty("id") Long id,
      @JsonProperty("creditId") Long creditId,
      @JsonProperty("collectorId") Long collectorId,
      @JsonProperty("collectorCreditStatus") CollectorCreditStatus collectorCreditStatus,
      @JsonProperty("statusDate") LocalDateTime statusDate) {
    this.id = id;
    this.creditId = creditId;
    this.collectorId = collectorId;
    this.collectorCreditStatus = collectorCreditStatus;
    this.statusDate = statusDate;
  }

  public Long getId() {
    return id;
  }

  public Long getCreditId() {
    return creditId;
  }

  public Long getCollectorId() {
    return collectorId;
  }

  public CollectorCreditStatus getCollectorCreditStatus() {
    return collectorCreditStatus;
  }

  public LocalDateTime getStatusDate() {
    return statusDate;
  }
}
