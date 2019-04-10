package com.common.utils.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	/**
	 * 时间格式化
	 * @param date
	 * @return
	 */
	public static String formatToString(Date date){
		if(date == null)
			return null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(date);
	}
}
