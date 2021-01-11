package com.example.hr.dto;

public class HireEmployeeResponse {
	private final String status;

	public HireEmployeeResponse(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
}
