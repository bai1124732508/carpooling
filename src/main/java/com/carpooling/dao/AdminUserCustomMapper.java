package com.carpooling.dao;

import java.util.List;

import com.carpooling.common.BaseQueryVo;
import com.carpooling.po.AdminUser;

public interface AdminUserCustomMapper {
	/**
	 * 获取管理员列表
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	List<AdminUser> getAdminUserList(BaseQueryVo vo)throws Exception;
	/**
	 * 
	 * @param member
	 * @return
	 * @throws Exception
	 */
	AdminUser checkAdminUserByMember(AdminUser member)throws Exception;
	/**
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	AdminUser getCkAuthMemberCustomByUserName(String username)throws Exception;
}