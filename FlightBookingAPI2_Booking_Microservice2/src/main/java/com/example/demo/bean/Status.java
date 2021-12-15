package com.example.demo.bean;

public class Status {
	private String Status;

	public Status() {
		super();
	}

	public Status(String status) {
		super();
		Status = status;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "Status [Status=" + Status + "]";
	}

}
