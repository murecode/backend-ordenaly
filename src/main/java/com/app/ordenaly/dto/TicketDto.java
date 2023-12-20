package com.app.ordenaly.dto;

public class TicketDto {
  private int ticketId;
  private String created_at;
  private int related_order;

  public TicketDto(int ticketId, String created_at, int related_order) {
    this.ticketId = ticketId;
    this.created_at = created_at;
    this.related_order = related_order;
  }

  public int getTicketId() {
    return ticketId;
  }

  public void setTicketId(int ticketId) {
    this.ticketId = ticketId;
  }

  public String getCreated_at() {
    return created_at;
  }

  public void setCreated_at(String created_at) {
    this.created_at = created_at;
  }

  public int getRelated_order() {
    return related_order;
  }

  public void setRelated_order(int related_order) {
    this.related_order = related_order;
  }

}
