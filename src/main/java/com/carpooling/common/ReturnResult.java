package com.carpooling.common;

public class ReturnResult {
	/**
	 * 返回值编码
	 */
	private String code;
	/**
	 * 返回值内容
	 */
	private String msg;
	/**
	 * 等待时间
	 */
	private Integer wait;
	/**
	 * 重定向地址
	 */
	private String url;
	
	
	private Object data;

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getWait() {
		return wait;
	}
	public void setWait(Integer wait) {
		this.wait = wait;
	}
	/**
	 * 成功
	 * @param msg 消息
	 * @return
	 */
	public static ReturnResult ok(String msg,String url) {
		return new ReturnResult(msg,"1",url);
	}
	/**
	 * 失败列表
	 * @param msg 消息
	 * @return
	 */
	public static ReturnResult error(String msg) {
		return new ReturnResult(msg,"0");
	}
	/**
	 * 失败之后跳转页面
	 * @param msg
	 * @param url
	 * @return
	 */
	public static ReturnResult error(String msg,String url) {
		return new ReturnResult(msg,"0",url);
	}
	
	public static ReturnResult error(String msg,String code,String url) {
		return new ReturnResult(msg,code,url);
	}
	
	/**
	 * 成功列表
	 * @param msg 消息
	 * @return
	 */
	public static ReturnResult list(String msg) {
		return new ReturnResult(msg,"1");
	}
	public ReturnResult(String msg,String code,String url) {
		this.code = code;
		this.msg = msg;
		this.wait=3;
		this.url=url;
	}
	
	public ReturnResult(String msg,String code){
		this.code = code;
		this.msg = msg;
		this.wait=3;
	}
	public ReturnResult(String code, String msg, Integer wait, String url) {
		super();
		this.code = code;
		this.msg = msg;
		this.wait = wait;
		this.url = url;
	}
	
	
	public static ReturnResult ok(String code,String msg,Object data) {
		return new ReturnResult(code, msg,data);
	}
	
	public ReturnResult(String code,String msg,Object data) {
		this.code = code;
		this.msg = msg;
		this.wait=3;
		this.data=data;
	}
	
	
	public ReturnResult( String msg, Integer wait, String url) {
		super();
		this.code = "1";
		this.msg = msg;
		this.wait = wait;
		this.url = url;
	}
	
	
	/**
	 * 成功 
	 * @param msg消息
	 * @return
	 */
	public static ReturnResult ok(String msg){
		return new ReturnResult(msg,"1","");
	} 
	/**
	 * 
	 * @param msg
	 * @param wait
	 * @param url
	 * @return
	 */
	public static ReturnResult ok(String msg, Integer wait, String url){
		return new ReturnResult(msg,wait,url);
	}
	
	
	
	
	
}
