package com.carpooling.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carpooling.common.BaseQueryVo;
import com.carpooling.common.IDBuilder;
import com.carpooling.common.ReturnResult;
import com.carpooling.common.Sha1Util;
import com.carpooling.po.AdminUser;
import com.carpooling.service.AdminUserService;
import com.carpooling.utils.MD5Util;
import com.github.pagehelper.PageInfo;
/**
 * 
 * 后台用户管理控制层
 *
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("admin/user")
public class AdminUserContorller {
	@Autowired
	private AdminUserService adminUserService;
	
	@Value("${custom.secretkey}")
	private String secretkey;
	public String getSecretkey() {
		return secretkey;
	}
	public void setSecretkey(String secretkey) {
		this.secretkey = secretkey;
	}
	
	/**
	 * 获取管理员列表
	 * @param model
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "index",method = RequestMethod.GET)
	public String index(Model model,BaseQueryVo vo)throws Exception{
		Map<String, String> search = vo.getSearch();
		if(search==null){
			 search = new HashMap<String, String>();
		}
		search.put("is_remove","0");//	是否删除，0为未删除，1为删除
		vo.setSearch(search);
		PageInfo<AdminUser> page =adminUserService.getAdminUserList(vo);
		model.addAttribute("page", page);
		return "adminUser/index";
	}
	
	
	
	@RequestMapping(value = "userAdd",method = RequestMethod.GET)
	public String userAdd(Model model,BaseQueryVo vo)throws Exception{
	
		return "adminUser/userAdd";
	}
	
	
	/**
	 * 用户新增
	 * @param adminUser
	 * @return
	 */
	@RequestMapping(value="userAdd",method=RequestMethod.POST)
	@ResponseBody
	public ReturnResult userAdd(AdminUser adminUser) {
		try {
			adminUser.setUid(IDBuilder.getTableId());
			adminUser.setLastLoginIp("0");
			adminUser.setCtime(new Date());
			adminUser.setUtime(new Date());
			adminUser.setLastLoginTime(new Date());
			adminUser.setIsRemove(0);
			adminUser.setLoginCount(Short.parseShort("0"));
			adminUser.setPassword(MD5Util.getMD5Str(Sha1Util.getSha1(adminUser.getPassword())+secretkey));
			adminUserService.insertAdminUser(adminUser);
			return new ReturnResult("1", "操作成功", 3, "/admin/user/index");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ReturnResult.error("操作失败");
	}
	
	@RequestMapping(value = "edit",method = RequestMethod.GET)
	public String edit(Model model,String id)throws Exception{
		AdminUser adminUser  = adminUserService.selectByPrimaryKey(id);
		model.addAttribute("adminUser", adminUser);
		return "adminUser/edit";
	}
	
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@ResponseBody
	public ReturnResult edit(AdminUser adminUser) {
		try {
			adminUser.setUtime(new Date());
			if(adminUser.getPassword() !=null && !"".equals(adminUser.getPassword())){
				adminUser.setPassword(MD5Util.getMD5Str(Sha1Util.getSha1(adminUser.getPassword())+secretkey));
			}
			adminUserService.updateByPrimaryKeySelective(adminUser);
			return new ReturnResult("1", "操作成功", 3, "/admin/user/index");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ReturnResult.error("操作失败");
	}
	
	@RequestMapping(value="remove",method=RequestMethod.POST)
	@ResponseBody
	public ReturnResult remove(String id) {
		try {
			AdminUser adminUser = new AdminUser();
			adminUser.setUid(id);
			adminUser.setIsRemove(1);
			adminUserService.updateByPrimaryKeySelective(adminUser);
			return new ReturnResult("1", "操作成功", 3, "/admin/user/index");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ReturnResult.error("操作失败");
	}

}
