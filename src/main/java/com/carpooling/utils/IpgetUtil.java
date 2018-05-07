package com.carpooling.utils;

import javax.servlet.http.HttpServletRequest;

public class IpgetUtil {
	
		//获得访问者IP方法
		public static String getIp(HttpServletRequest request){
			
			  String ip = request.getHeader("x-forwarded-for"); 
		       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		           ip = request.getHeader("Proxy-Client-IP"); 
		       } 
		       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		           ip = request.getHeader("WL-Proxy-Client-IP"); 
		       } 
		       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		           ip = request.getRemoteAddr(); 
		       } 
		      
			return ip;
		}
	 
	
}
