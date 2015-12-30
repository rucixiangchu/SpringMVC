package com.tgb.web.controller.annotation;

public class SpringManager implements ISpring {

	@Override
	public String get() {
		System.out.println("------I am springManager----");

		return "I am getMethod";
	}

}
