package com.main.dto;

import java.util.Date;

public class ErrorMessage {
  private Date timestamp;
  private String message;

  public ErrorMessage(Date timestamp, String message) {
    this.timestamp = timestamp;
    this.message = message;
  }


  public Date getTimestamp() {
    return timestamp;
  }

  public String getMessage() {
    return message;
  }

  }