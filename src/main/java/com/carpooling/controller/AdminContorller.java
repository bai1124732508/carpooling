package com.carpooling.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carpooling.common.BaseQueryVo;
import com.carpooling.common.LoginCookieUtil;
import com.carpooling.common.MD5Util;
import com.carpooling.common.ReturnResult;
import com.carpooling.common.Sha1Util;
import com.carpooling.po.AdminUser;
import com.carpooling.service.AdminUserService;
import com.carpooling.utils.IpgetUtil;

@Controller
@EnableAutoConfiguration
public class AdminContorller {
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
	
	
	@RequestMapping(value = "admin",method = RequestMethod.GET)
	public String index(Model model,BaseQueryVo vo)throws Exception{
		
		return "admin/index";
	}
	
	/**
	 * 登陆接口
	 * @param member
	 * @param model
	 * @param session
	 * @param response
	 * @param request
	 * @param online
	 * @return
	 */
	@RequestMapping(value = "/admin/login",method = RequestMethod.POST)
	@ResponseBody
	public ReturnResult doLogin(@ModelAttribute AdminUser member,Model model,HttpSession session,HttpServletResponse response,HttpServletRequest request,String online) {
		//验证用户名以及密码
		
     	member.setPassword(MD5Util.getMD5Str(Sha1Util.getSha1(member.getPassword())+secretkey));
		try {
			AdminUser ckAuthMember= adminUserService.checkAdminUserByMember(member);
			if(ckAuthMember==null){//验证失败 ，跳回登陆页面
				model.addAttribute("errormsg", "用户名或密码错误");
				//return ReturnResult.ok("用户名或密码错误", "/user/login");
				return ReturnResult.error("用户名或密码错误");
			}
			
			ckAuthMember.setLastLoginIp(IpgetUtil.getIp(request));
			session.setAttribute("user", ckAuthMember);
			//System.out.println(session.getAttribute("menulistJson"));
			if(online!=null&&online.equals("true")){
				LoginCookieUtil.saveCookie(ckAuthMember, response);
			}
		
			//return ReturnResult.ok("登陆成功", "/");
			return ReturnResult.ok("登陆成功", 0,"/admin/user/index");
		} catch (Exception e) {
			e.printStackTrace();
			return ReturnResult.error("未知错误");
		}
	}

}
