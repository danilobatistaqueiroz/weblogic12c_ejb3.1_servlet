package com.labs;

import javax.ejb.Stateless;

@Stateless
public class LoggerBean {

	public String write(String text) {
		String wrote = "writing on ejb server " + text + "<br/>";
		System.out.println(wrote);
		return wrote;
	}
}
