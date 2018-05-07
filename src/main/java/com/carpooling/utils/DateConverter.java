package com.carpooling.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 版权所有：风华正茂（北京）科技有限公司
 * 作　　者：贺更新
 * 版　　本：1.0
 * 创建日期：2016年12月4日
 * 功能描述：___________SpringMvc日期转换类____________
 * 
 * 修改历史记录
 * 	作者				时间					版本					备注
 *  贺更新			2016年12月4日			1.0					创建
 */
public class DateConverter implements Converter<String, Date> {

	public Date convert(String source) {
		//实现 将日期串转成日期类型(格式是yyyy-MM-dd HH:mm:ss)
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			//转成直接返回
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//如果参数绑定失败返回null
		return null;
	}

}
