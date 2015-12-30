package com.tgb.web.controller.annotation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tgb.web.controller.entity.User;

@Controller
@RequestMapping("/user/data")
public class DataController {

	@RequestMapping("/addUser")
	public String addUser(User[] users, HttpServletRequest request) {
		for (User user : users) {
			System.err.println(user.getUserName() + "----" + user.getAge());
		}
		Map<String, String[]> parameterMap = request.getParameterMap();
		for (Entry<String, String[]> entry : parameterMap.entrySet()) {
			String key = entry.getKey();
			String[] values = entry.getValue();
			if (values.length == 0) {
				System.err.println(key + "----");
			} else if (values.length == 1) {
				System.err.println(key + "----" + values[0]);
			} else {
				System.err.println(key + "----" + values.toString());
			}
		}

		return "/userManager";
	}

	@RequestMapping("/addUserJson")
	public void addUserJson(User user, HttpServletRequest request, HttpServletResponse response) {
		//{"username":"userName","age","age"}
		String result = "{\"userName\":\" " + user.getUserName() + " \",\"age\":\" " + user.getAge() + " \"}";
		PrintWriter out = null;
		response.setContentType("application/json");

		try {
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/delUser")
	public String delUser() {
		return "";
	}

	@RequestMapping("/toUser")
	public String toUser() {
		return "/json";
	}

	@RequestMapping("/toImg")
	public String toIMg() {
		return "/staticFile";
	}

}
