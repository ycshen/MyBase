package com.brp.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Run {

	public static void main(String[] args) {
		String from =  "^/some/(\\w*)/(.*)$";
		String to = "/very/$1/$2";
		
		Pattern p = Pattern.compile(from);
		Matcher m = p.matcher("/some/hello/world");
		if(m.find()){
			System.out.println(m.group());
			String toResult = m.replaceAll(to);
			System.out.println(toResult);
		}
		else{
			System.out.println("not match");
		}

	}

}
