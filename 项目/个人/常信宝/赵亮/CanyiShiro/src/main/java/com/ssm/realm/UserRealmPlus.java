package com.ssm.realm;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.ssm.entiy.SysUser;
import com.ssm.service.SysUserService;
import com.ssm.service.Imp.SysRoleServiceImp;
import com.ssm.service.Imp.SysUserServiceImp;

public class UserRealmPlus extends AuthorizingRealm{
	
	@Autowired
	SysUserService userService;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "userRealm";
	}
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
	
		System.out.println(4);
		String loginname=token.getPrincipal().toString();
		System.out.println("前台"+loginname);
		System.out.println(userService);
		SysUser user=userService.findUser(loginname);
		System.out.println("132435453465");
		System.out.println(user);
		SimpleAuthenticationInfo info=null;
		if(user==null){
			return null;
		}else{
			try {
				info = new SimpleAuthenticationInfo(user, user.getPassword(),ByteSource.Util.bytes("sxt"),getName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return info;
	}
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		//获取身份信息————————该身份信息在认证时已设置 与验证时设置的值一致
		SysUser user = (SysUser)principal.getPrimaryPrincipal();
		System.out.println("权限： "+user);
		if(user==null){
			return null;
		}
		//获取数据库中的权限信息
		//根据用户名到数据库查询该用户对应的权限信息-----模拟  	 
				List<String> permission=new ArrayList<String>();
				//permission.add("user:add");
				permission.add("user:delete");
				permission.add("user:update");
				permission.add("user:find");
				System.out.println(user.getUserType());
				//permission.add("user:*");
				SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
				for (String string : permission) {
					info.addStringPermission(string);
				}
				
		return info;
	}
	@Override
	protected void clearCache(PrincipalCollection principals) {
		Subject subject = SecurityUtils.getSubject();
		super.clearCache(subject.getPrincipals());
	}
}
