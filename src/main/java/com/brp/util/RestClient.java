package com.brp.util;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * Http 调用公用类
 */
public class RestClient {
	
	
	MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
	// private String server;
	private RestTemplate restTemplate;
	private HttpHeaders headers;
	private HttpStatus status;
	private String body = "";

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body == null || body.trim().length() < 1 ? "" : body;
	}

	/**
	 * 自定义请求头
	 *
	 * @param type
	 * @param subtype
	 * @param charSet
	 */
	public RestClient(String type, String subtype, Charset charSet) {
		restTemplate = new RestTemplate();
		this.headers = new HttpHeaders();
		MediaType mediaType = new MediaType(type, subtype, charSet);
		headers.setContentType(mediaType);
	}

	/**
	 * 默认方式
	 */
	public RestClient() {
		restTemplate = new RestTemplate();
	}

	/**
	 * get
	 *
	 * @param uri
	 * @return
	 */
	public ResponseEntity<String> get(String uri) {
		HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
		return restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
	}

	public ResponseEntity<String> getByUrl(String url) {
		HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
		return restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
	}

	/**
	 * @param url
	 *            请求地址
	 * @param json
	 *            请求内容
	 * @return
	 */
	public ResponseEntity<String> postByUrl(String url, String json) {
		HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
		return restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
	}

	/**
	 * post
	 *
	 * @param uri
	 * @param json
	 * @return
	 */
	public ResponseEntity<String> post(String uri, String json) {
		HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
		return restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);
	}

	/**
	 * put
	 *
	 * @param uri
	 * @param json
	 */
	public ResponseEntity<String> put(String uri, String json) {
		HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);
		return restTemplate.exchange(uri, HttpMethod.PUT, requestEntity, String.class);
	}

	/**
	 * delete
	 *
	 * @param uri
	 */
	public ResponseEntity<String> delete(String uri) {
		HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
		return restTemplate.exchange(uri, HttpMethod.DELETE, requestEntity, String.class);
	}

	/**
	 * head
	 *
	 * @param uri
	 */
	public ResponseEntity<String> head(String uri) {
		HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
		return restTemplate.exchange(uri, HttpMethod.HEAD, requestEntity, String.class);
	}

	/**
	 * OPTIONS
	 *
	 * @param uri
	 */
	public ResponseEntity<String> options(String uri) {
		HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
		return restTemplate.exchange(uri, HttpMethod.OPTIONS, requestEntity, String.class);
	}

	/**
	 * TRACE
	 *
	 * @param uri
	 */
	public ResponseEntity<String> trace(String uri) {
		HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
		return restTemplate.exchange(uri, HttpMethod.TRACE, requestEntity, String.class);
	}

	/**
	 * 公共方法调用
	 * 
	 * @Author hexj
	 * @Date 2016/4/1 16:41
	 */
	public ResponseEntity<String> callType(HttpMethod method, String uri, String parm) {
		ResponseEntity<String> result = null;
		switch (method) {
		case GET:
			result = get(uri);
			break;
		case POST:
			result = post(uri, parm);
			break;
		case PUT:
			result = put(uri, parm);
			break;
		case HEAD:
			result = head(uri);
			break;
		case DELETE:
			result = delete(uri);
			break;
		case OPTIONS:
			result = options(uri);
			break;
		case TRACE:
			result = trace(uri);
			break;
		default:
			break;
		}
		return result;
	}

	public HttpHeaders getHeaders() {
		return headers;
	}

	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}
