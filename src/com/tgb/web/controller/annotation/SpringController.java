package com.tgb.web.controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class SpringController {

	/*@Resource(name="springManager")
	private ISpring springManager;*/
	
	@RequestMapping("/spring/get")
	public String get(HttpServletRequest request){
		//spring的上下文
		WebApplicationContext ac1 = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		//springMVC的上下文
		WebApplicationContext ac2 = RequestContextUtils.getWebApplicationContext(request);
		
		//ISpring springManager = (ISpring) ac1.getBean("springManager");
		ISpring springManager = (ISpring)ac2.getBean("springManager");
		
		System.out.println(springManager.get());
		return "/success";
	}
}
