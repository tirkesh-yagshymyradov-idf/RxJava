package com.mm.collection.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CollectorModel {

  private final Long id;
  private final String firstName;
  private final String lastName;
  private final CollectorActivityStatus activityStatus;

  @JsonCreator
  public CollectorModel(
      @JsonProperty("id") Long id,
      @JsonProperty("fistName") String firstName,
      @JsonProperty("lastName") String lastName,
      @JsonProperty("activityStatus") CollectorActivityStatus activityStatus) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.activityStatus = activityStatus;
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public CollectorActivityStatus getActivityStatus() {
    return activityStatus;
  }
}
