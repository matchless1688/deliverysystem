package com.delivery.utils;

import java.util.HashMap;
import java.util.Map;

public class LastOprUtils {

	private final static Map<String, String> oprMap = new HashMap<String, String>();
	
	private final static String OPR_KEY = "lastopr";
	
	public static void setLastOpr(String user) {
		oprMap.put(OPR_KEY, user);
	}
	
	public static String getLastOpr() {
		return oprMap.get(OPR_KEY);
	}
	
	public static void clear() {
		oprMap.clear();
	}
}
