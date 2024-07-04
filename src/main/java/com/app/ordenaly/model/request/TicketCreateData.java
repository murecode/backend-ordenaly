package com.app.ordenaly.model.request;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class TicketCreateData implements Serializable {
  @NotBlank
  private int numberOfPeople;

  public int getNumberOfPeople() {
    return numberOfPeople;
  }

  public void setNumberOfPeople(int numberOfPeople) {
    this.numberOfPeople = numberOfPeople;
  }
}
