package com.carpooling.common;

import java.util.Map;

/**
 * 版　　本：1.0
 * 创建日期：2017年5月15日
 * 功能描述：________查询基础父类_______________
 */
public class BaseQueryVo {
	
	private Map<String, String> search;
	
	private Integer  pageNum;
	
	private Integer pageSize;

	

	/**
	 * @return the pageNum
	 */
	public Integer getPageNum() {
		 return pageNum == null?1:pageNum<=0?1:pageNum;
	}

	/**
	 * @param pageNum the pageNum to set
	 */
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		 return pageSize == null?10:pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the search
	 */
	public Map<String, String> getSearch() {
		return search;
	}

	/**
	 * @param search the search to set
	 */
	public void setSearch(Map<String, String> search) {
		this.search = search;
	}
}
