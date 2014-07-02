package com.delivery.utils;

public class CommonUtils {
	public static String genPwdBasedOnTel(String telenum) {
		if (telenum.length() != 11) {
			return "";
		}
		int i = 0;
		StringBuilder result = new StringBuilder();
		while (i < 4) {
			String temp = telenum.substring(i, i + 8);
			int value = Integer.parseInt(temp.substring(0, 1)) * 8
					+ Integer.parseInt(temp.substring(1, 2)) * 6
					+ Integer.parseInt(temp.substring(2, 3)) * 4
					+ Integer.parseInt(temp.substring(3, 4)) * 2
					+ Integer.parseInt(temp.substring(4, 5)) * 3
					+ Integer.parseInt(temp.substring(5, 6)) * 5
					+ Integer.parseInt(temp.substring(6, 7)) * 9
					+ Integer.parseInt(temp.substring(7, 8)) * 7;
			int remainder = value % 11;
			if (remainder == 0)
				result.append("5");
			else if (remainder == 1)
				result.append("0");
			else
				result.append(11 - remainder);
			i++;
		}
		return result.toString();
	}
}
