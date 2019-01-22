package com.qr.xxpt.response.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.qr.xxpt.constants.Constants;

public class ResponseUtils {

	/**
	 * 1
	 */
	static String DEFAULT_ENCODING = "UTF-8";
	static String DEFAULT_CACHE = "no-cache";
	static String ENCODING = "encoding";
	private HttpServletResponse response;

	public ResponseUtils(HttpServletResponse res) {
		this.response = res;
	}
    //3  
	public void render(String type, String content, String... headers) {
		String responseType = responseResult(type, headers);
		try {
			response.setContentType(responseType);
			response.getWriter().write(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e.getMessage());
		}
	}
	//2
	public String responseResult(String type, String... headers) {
		String encoding = DEFAULT_ENCODING;
		for (String header : headers) {
			String headerValues[] = header.split(":");
			if (headerValues[0].equals(ENCODING)) {
				encoding = headerValues[1];
			}
			
		}
		String responseType = type + ";charset=" + encoding;
		return responseType;
	}

	public void renderJSON(String content) {
		render(Constants.JSON_TYPE, content);
	}
	public void renderXML(String content) {
		render(Constants.XML_TYPE, content);
	}
	public void renderHTML(String content) {
		render(Constants.HTML_TYPE, content);
	}
}
