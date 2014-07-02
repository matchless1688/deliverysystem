package com.delivery.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");

	public static String buildDateStr() {
		return sf.format(new Date());
	}
	
}
