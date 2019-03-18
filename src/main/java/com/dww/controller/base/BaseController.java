package com.dww.controller.base;


import javax.servlet.http.HttpServletRequest;

import com.dww.model.Page;
import com.dww.util.PageData;
import com.dww.util.UuidUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;



public class BaseController {
	


	@SuppressWarnings("unused")
	private static final long serialVersionUID = 6357869213649815390L;
	

	public PageData getPageData(){
		return new PageData(this.getRequest());
	}
	

	public ModelAndView getModelAndView(){
		return new ModelAndView();
	}
	

	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}


	public String get32UUID(){
		return UuidUtil.get32UUID();
	}
	

	public Page getPage(){
		return new Page();
	}
	

	
}
