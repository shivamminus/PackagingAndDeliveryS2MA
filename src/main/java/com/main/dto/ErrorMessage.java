package com.main.dto;

import java.util.Date;

/*Error model Example
{
	timestamp:"Tue May 25 17:37:21 UTC 2021",
	message:"Something went wrong"
}
*/
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