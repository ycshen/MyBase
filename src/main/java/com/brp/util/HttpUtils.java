/** * HttpUtil.java 
* Created on 2015年6月26日 下午2:45:22 
*/

package com.brp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

/** 
 * <p>Project: BRP</p> 
 * <p>Title: HttpUtils.java</p> 
 * <p>Description: TODO</p> 
 * <p>Copyright (c) 2016 xjw Consultancy Services</p>
 * <p>All Rights Reserved.</p>
 * @author <a href="mailto:shenyuchuan@itiaoling.com">申鱼川</a>
 */
public class HttpUtils{
	
	protected  static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);
	
	
	/**
	 * 得到http服务器返回字符串参数
	 * @param url
	 * @return
	 */
	public static String get(String url) {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(url, String.class);
		
		return result;
	}
	
	/**
	 * 发送post请求返回字符串
	 * @param url post-URL:
	 * @param postData post的数据
	 * @return 返回post请求响应的数据
	 */
	public static String postUrl(String url, String postData){
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());        
        HttpEntity<String> formEntity = new HttpEntity<String>(postData, headers);
        return restTemplate.postForObject(url, formEntity, String.class);
	}
}
