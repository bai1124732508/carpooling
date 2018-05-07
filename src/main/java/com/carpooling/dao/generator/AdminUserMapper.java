package com.carpooling.dao.generator;

import com.carpooling.po.AdminUser;

public interface AdminUserMapper {
    int deleteByPrimaryKey(String uid);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
}