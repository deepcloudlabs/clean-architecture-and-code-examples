package com.example.hr.dto;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class RestErrorMessage {
	private int errorId;
	private String message;
	private String debugId;

	public RestErrorMessage(int errorId, String message, String debugId) {
		this.errorId = errorId;
		this.message = message;
		this.debugId = debugId;
	}

	public int getErrorId() {
		return errorId;
	}

	public String getMessage() {
		return message;
	}

	public String getDebugId() {
		return debugId;
	}

	@Override
	public String toString() {
		return "RestErrorMessage [errorId=" + errorId + ", message=" + message + ", debugId=" + debugId + "]";
	}

}
