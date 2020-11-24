package com.cslg.common.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.cslg.common.domain.UserDO;
import com.cslg.common.service.UserService;
import com.cslg.system.utils.R;
import com.cslg.system.utils.ShiroUtils;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return 
	 * @return
	 */
	@ResponseBody
	@PostMapping("/commonLogin")
	public R login(String username, String password, HttpSession session) {
		//获取Subject
		Subject subject = SecurityUtils.getSubject();
		//封装用户数据到token
		String newPassword = ShiroUtils.shiroSalt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, newPassword);
		try {
			subject.login(token);
			session.setAttribute("commonUser", subject.getPrincipal());
			return R.ok("登录成功！");
		} catch (UnknownAccountException e) {
		    return R.error("用户名不存在！");
		} catch (LockedAccountException e) {
		    return R.error("账号已被锁定，请联系管理员！");
		} catch (IncorrectCredentialsException e) {
			return R.error("密码错误！");
		}
	}
	
	/**
	 * 注册
	 * @param username
	 * @param password
	 * @return
	 */
	@ResponseBody
	@PostMapping("/commonRegister")
	public R register(String username, String password) {
		UserDO userDO = new UserDO();
        userDO.setUsername(username);
        userDO.setPassword(ShiroUtils.shiroSalt(username,password));
        userDO.setHeadPortrait("http://localhost:8080/files/default/user-default-image.jpg");
        userDO.setStatus(1);
        //生成时间
		Date date = new Date();
        userDO.setCreateTime(date);
        userDO.setRoleId((long) 3);
		int count = userService.register(userDO);
		if(count > 0) {
			return R.ok("注册成功！");
		}else {
			return R.error("注册失败！");
		}
	}
	
	/**
	 * 查询注册的用户名是否重复
	 */
	@ResponseBody
	@PostMapping("/checkUsername")
	public R checkUsername(String username) {
		int total = userService.checkUsername(username);
		if(total==0) {
			return R.ok("用户名可用！");
		}else {
			return R.error("用户名重复！");
		}
	}
	
	/**
	 * 登出
	 * @return
	 */
	@ResponseBody
	@GetMapping("/commonToLogout")
	public R commonToLogout() {
		//Subject subject = SecurityUtils.getSubject();
		//subject.logout();
		return R.ok("退出成功！");
	}
	
	/**
	 * 查询用户信息
	 */
	@ResponseBody
	@PostMapping("/queryCommonUserInformation")
	public UserDO queryCommonUserInformation(Long id) {
		UserDO userDO = userService.queryCommonUserInformation(id);
		return userDO;
	} 
	
	/**
	 * 修改用户信息
	 */
	@ResponseBody
	@PostMapping("/updateCommonUserInformation")
	public R updateCommonUserInformation(Long id,String realName,String sex,Date birth, Long phone, String mail) {
		userService.updateCommonUserInformation(id,realName,sex,birth,phone,mail);
		return R.ok("修改成功！");
	} 
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		
		//转换日期
		DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
	}
	
}
