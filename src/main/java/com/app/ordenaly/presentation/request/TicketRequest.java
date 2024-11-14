package com.app.ordenaly.presentation.request;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public class TicketRequest implements Serializable {
  @NotBlank
  private int numberOfPeople;

  public int getNumberOfPeople() {
    return numberOfPeople;
  }

  public void setNumberOfPeople(int numberOfPeople) {
    this.numberOfPeople = numberOfPeople;
  }
}
