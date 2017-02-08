package com.lvtpsys_system.util;

public class Common {

	public static boolean isOrder(String[] times, String curtime) {
		boolean is = false;
		System.out.println("开始时间："+times[0]);
		System.out.println("结束时间："+times[1]);
		System.out.println("当前时间："+curtime);
		String[] str1 = times[0].split(":");
		String[] str2 = times[1].split(":");
		String[] str3 = curtime.split(":");
		if (Integer.parseInt(str1[0]) < Integer.parseInt(str3[0])
				&& Integer.parseInt(str2[0]) > Integer.parseInt(str3[0])) {
			is=true;
		}else if (Integer.parseInt(str1[0]) == Integer.parseInt(str3[0])) {
			if (Integer.parseInt(str1[1]) <= Integer.parseInt(str3[1])) {
				is = true;
			}
		}else if (Integer.parseInt(str2[0]) == Integer.parseInt(str3[0])) {
			if (Integer.parseInt(str2[1]) >= Integer.parseInt(str3[1])) {
				is = true;
			}
		}
		return is;
	}
}
