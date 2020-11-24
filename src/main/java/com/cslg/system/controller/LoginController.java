package com.cslg.system.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cslg.system.utils.R;
import com.cslg.system.utils.ShiroUtils;

@Controller
public class LoginController {
	
	/**
	 * 跳转到后台登录页面
	 * @return
	 */
	@RequestMapping("/backend")
	public String toLogin() {
		return "backend/login";
	}
	
	/**
	 * 后台登录
	 * @return
	 */
	@ResponseBody
	@PostMapping("/systemLogin")
	public R sysLogin(String username, String password, HttpSession session) {
		//获取Subject
		Subject subject = SecurityUtils.getSubject();
		//封装用户数据到token
		String newPassword = ShiroUtils.shiroSalt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, newPassword);
		try {
			subject.login(token);
			session.setAttribute("systemUser", subject.getPrincipal());
			return R.ok("登录成功！");
		} catch (UnknownAccountException e) {
		    return R.error("用户名不存在！");
		} catch (IncorrectCredentialsException e) {
			return R.error("密码错误！");
		}
	}
	
	/**
	 * 跳转到后台首页
	 */
	@RequestMapping("/toSysIndex")
	public String toSysIndex() {
		return "backend/index";
	}
	
}
