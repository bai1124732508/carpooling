package com.carpooling.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carpooling.common.BaseQueryVo;
import com.carpooling.dao.AdminUserCustomMapper;
import com.carpooling.dao.generator.AdminUserMapper;
import com.carpooling.po.AdminUser;
import com.carpooling.service.AdminUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("adminUserService")
@Transactional
public class AdminUserServiceImpl implements AdminUserService{

	@Autowired 
	private AdminUserCustomMapper adminUserCustomMapper;
	@Autowired 
	private AdminUserMapper adminUserMapper;
	
	
	public PageInfo<AdminUser> getAdminUserList(BaseQueryVo vo) throws Exception {
		PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
		List<AdminUser> list = adminUserCustomMapper.getAdminUserList(vo);
		PageInfo<AdminUser> page= new PageInfo<>(list);
		return page;
	}


	@Override
	public void insertAdminUser(AdminUser adminUser) throws Exception {
		adminUserMapper.insertSelective(adminUser);
	}


	@Override
	public AdminUser checkAdminUserByMember(AdminUser member) throws Exception {
		AdminUser  adminUser=adminUserCustomMapper.checkAdminUserByMember(member);
		return adminUser;
	}


	@Override
	public AdminUser getCkAuthMemberCustomByUserName(String username) throws Exception {
		AdminUser  adminUser=adminUserCustomMapper.getCkAuthMemberCustomByUserName(username);
		return adminUser;
	}


	@Override
	public AdminUser selectByPrimaryKey(String id) throws Exception {
		// TODO Auto-generated method stub
		return adminUserMapper.selectByPrimaryKey(id);
	}


	@Override
	public void updateByPrimaryKeySelective(AdminUser adminUser) throws Exception {
		// TODO Auto-generated method stub
		adminUserMapper.updateByPrimaryKeySelective(adminUser);
	}
	

}
