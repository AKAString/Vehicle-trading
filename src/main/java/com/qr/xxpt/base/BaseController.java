package com.qr.xxpt.base;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.qr.xxpt.callback.Callback;
import com.qr.xxpt.constants.Constants;
import com.qr.xxpt.exception.BusinessException;
import com.qr.xxpt.response.utils.ResponseUtils;

public abstract class BaseController {

	/**
	 * ����json��
	 */
	protected Gson gson = new Gson();
	protected HttpServletResponse response;
	protected HttpServletRequest request;

	@ModelAttribute
	public void setHttp(HttpServletResponse response, HttpServletRequest request) {
		this.request = request;
		this.response = response;
	}
	/**
	 * �쳣������ ${requestScope.error}
	 */
	@ExceptionHandler
	public String execption(Exception ex) {

		String result = "error";
		if (ex instanceof BusinessException) {
			result = "businessError";
		}
		request.setAttribute("error", ex.getMessage());
		return result;
	}

	public ModelAndView execute(Callback callback, String viewName) {
		Map<String, Object> maps = new HashMap<String, Object>();
		Map<String, Object> datas = new HashMap<String, Object>();
		int flag = Constants.SUCCESS;
		try {
			callback.process(datas);
			maps.put("data", datas);
		} catch (Exception e) {
			flag = Constants.ERROR;
			maps.put("error", e.getMessage());
		}
		finally {
			maps.put("flag", flag);
		}
		return new ModelAndView(viewName,maps);
	}
	public void json(Callback callback)
	{
		Map<String, Object> data = new HashMap<String, Object>();
		Map<String, Object> res = new HashMap<String, Object>();
		int code = Constants.SUCCESS;
		try {
			callback.process(data);
			res.put("data", data);
		} catch (Exception e) {
			code = Constants.ERROR;
			e.printStackTrace();
			res.put("error", e.getMessage());
		} finally {
			res.put("flag", code);
		}		
		new ResponseUtils(response).renderJSON(gson.toJson(res));
		
	}
}
