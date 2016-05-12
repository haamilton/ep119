package br.com.hsj.ep119.api.domain;

public class ErrorInfo {
	
	public ErrorInfo(int errorCode, String message, String detail) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.detail = detail;
	}

	private int errorCode;
	
	private String message;
	
	private String detail;
	
	public int getErrorCode() {
		return errorCode;
	}
	
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
