package com.carpooling.utils;

import java.util.Date;
import java.util.UUID;

public class IDBuilder {
	/**
	 * 创建uuid
	 * 
	 * @return
	 */
	public static UUID newUUID() {
		return UUID.randomUUID();
	}

	/**
	 * 返回uuidString
	 * 
	 * @return
	 */
	public static String getNewUUIDString() {
		return newUUID().toString();
	}

	/**
	 * 根据当前时间返回字符串
	 * 
	 * @return
	 */
	public static String getNowStr() {
		return DateUtil.date2String(new Date(), "yyyyMMddHHmmssSSS");
	}
	
}
