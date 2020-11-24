package com.cslg.system.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.cslg.common.domain.UserDO;
import com.cslg.common.service.UserService;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		String password = new String((char[]) token.getCredentials());
		UserDO userDO = userService.login(username);
		//用户名不存在
		if(userDO == null) {
			throw new UnknownAccountException();
		}
		// 账号锁定
		if (userDO.getStatus() == 0) {
			throw new LockedAccountException();
		}
		//密码错误
		if (!password.equals(userDO.getPassword())) {
			throw new IncorrectCredentialsException();
		}
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userDO, userDO.getPassword(), getName());
		return info;
	}

}
