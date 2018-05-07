package com.carpooling.service;

import org.apache.ibatis.annotations.Param;

import com.carpooling.common.BaseQueryVo;
import com.carpooling.po.AdminUser;
import com.github.pagehelper.PageInfo;

public interface AdminUserService {
	/**
	 * 获取管理员列表
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	PageInfo<AdminUser> getAdminUserList(BaseQueryVo vo)throws Exception;
	/**
	 * 新增用户
	 * @param adminUser
	 * @throws Exception
	 */
	void insertAdminUser(AdminUser adminUser)throws Exception;
	/**
	 * 获取有无改用户
	 * @param member
	 * @return
	 * @throws Exception
	 */
	AdminUser checkAdminUserByMember(@Param("member")AdminUser member) throws Exception;
	/**
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	AdminUser getCkAuthMemberCustomByUserName(String username)throws Exception;
	/**
	 * 查询用户信息  根据id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	AdminUser selectByPrimaryKey(String id)throws Exception;
	/**
	 * 
	 * @param adminUser
	 * @throws Exception
	 */
	void updateByPrimaryKeySelective(AdminUser adminUser)throws Exception;

}
