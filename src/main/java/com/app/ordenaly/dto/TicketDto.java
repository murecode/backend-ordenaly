package com.app.ordenaly.dto;

public class TicketDto {
  private String ticket_id;
  private String created_at;
  private int related_order;

  public TicketDto() {}

//  public TicketDto(int ticketId, String created_at, int related_order) {
//    this.ticketId = ticketId;
//    this.created_at = created_at;
//    this.related_order = related_order;
//  }


  public String getTicket_id() {
    return ticket_id;
  }

  public void setTicket_id(String ticket_id) {
    this.ticket_id = ticket_id;
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
