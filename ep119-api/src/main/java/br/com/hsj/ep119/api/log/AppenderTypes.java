package br.com.hsj.ep119.api.log;

public enum AppenderTypes {

	TRACER("br.com.hsj.log");
	
	private final String appender; 

	AppenderTypes(String appender) {
		this.appender = appender;
	}

	public String getAppender() {
		return appender;
	}
}
