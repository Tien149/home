package com.axonactive.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name ="Regex")
@ViewScoped
public class RegexConfig {
	
	private String regexr = "([^(\\`|\\~|\\!|\\@|\\#|\\$|\\%|\\^|\\\\&|\\*|\\(|\\)|\\+|\\=|\\[|\\{|\\]|\\}|\\||\\\\|\\'|\\<|\\,|\\.|\\>|\\?|\\/|\\\"\"|\\;|\\:|\\d|\\-|\\_)]+)";

	public String getRegexr() {
		return regexr;
	}

	public void setRegexr(String regexr) {
		this.regexr = regexr;
	}
}
