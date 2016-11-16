package com.brp.model;

import java.io.InputStream;
import java.net.URI;
import java.util.Map;

public class HttpRequestModel {

	private URI uri;
	private String method;
	private Map<String, String> headers;
	private InputStream body;

	public HttpRequestModel(URI uri) {
		this.uri = uri;
	}

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public InputStream getBody() {
		return body;
	}

	public void setBody(InputStream body) {
		this.body = body;
	}
}
