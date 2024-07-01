package com.app.ordenaly.model.dtos.ticket;

import jakarta.validation.constraints.NotBlank;

public class TicketCreateData {
  @NotBlank
  private int numberOfPeople;

  public int getNumberOfPeople() {
    return numberOfPeople;
  }

  public void setNumberOfPeople(int numberOfPeople) {
    this.numberOfPeople = numberOfPeople;
  }
}
