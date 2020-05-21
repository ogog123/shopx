package com.jk.utils;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 
 * Copyright © 2017 金科教育. All rights reserved.
 * 类: BaseAction 
 * 描述: TODO 
 * 作者: Teacher song
 * 时间: 2017-4-5 下午3:24:42
 */
public class BaseAction extends ActionSupport
		implements ServletRequestAware, ServletResponseAware, ServletContextAware {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 声明request
	 */
	private HttpServletRequest request;
	private HttpServletResponse response;
	private ServletContext servletContext;

	public HttpServletRequest getRequest() {
		return request;
	}
	
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}
	// ---------------------------------

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		servletContext = arg0;

	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
	}
	
	public void  outStr(String str){
		try {
			getResponse().setCharacterEncoding("utf-8");
			getResponse().getWriter().write(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void outJson(Object info){
		//将对象转为json字符串
//		JsonConfig jsonConfig = new JsonConfig();
//		String jsonStr = JSONSerializer.toJSON(info, jsonConfig).toString();
		String jsonStr= JSON.toJSONStringWithDateFormat(info, "yyyy-MM-dd HH:mm:ss");
		getResponse().setContentType("text/xml; charset=utf-8");
		getResponse().setCharacterEncoding("utf-8");
		String jsonString = JSON.toJSONString(info);
		try {
			getResponse().getWriter().write(jsonStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
