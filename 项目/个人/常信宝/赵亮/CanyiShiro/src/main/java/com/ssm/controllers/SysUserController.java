package com.ssm.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.ssm.BeanUtils.UserOfficeUtil;
import com.ssm.entiy.SysRole;
import com.ssm.entiy.SysUser;
import com.ssm.entiy.SysUserRoleKey;
import com.ssm.service.SysOfficeService;
import com.ssm.service.SysRoleService;
import com.ssm.service.SysUserRoleService;
import com.ssm.service.SysUserService;
@Controller
@RequestMapping("/user")
public class SysUserController {
	@Resource
	private SysUserService userService;
	@Autowired
	private SysRoleService roleService;
	@Autowired
	private SysUserRoleService userRoleService;
	@Autowired
	private SysOfficeService officeService;
	

	/*测试方法
	 * 
	 * @RequestMapping("/index")
	public String getAllUser(){
		System.out.println("11");
		return "ss";
	}*/
	//展示用户列表，
	
	@RequestMapping("/getSysUserAll")
	public void getSysUserAll(HttpServletResponse response,HttpServletRequest request) throws IOException{
		//根据登录人员的公司id查到所有属于本公司的人员
		SysUser user=(SysUser)request.getSession().getAttribute("loginUser");
		
		//分为两种  一种是超级管理员登录 ，可以操作所有，也就是说 所有公司
		if(user.getCompanyId()==null){
			System.out.println(user.getLoginName()+":"+user.getCompanyId());
			user.setCompanyId(0);
		}
		//公司内部人员登录  公司所有人
		List<SysUser> list=userService.getCompanyIdFindUser(user.getCompanyId());
		ArrayList<UserOfficeUtil> UserOfficelist = new ArrayList<UserOfficeUtil>();
		UserOfficeUtil userRoleType = (UserOfficeUtil)request.getSession().getAttribute("loginUserRole");
		for (SysUser sysUser : list) {
			UserOfficeUtil userOfficeUtil = new UserOfficeUtil();
			userOfficeUtil.setUser(sysUser);
			//注入公司名称和部门名称
			officeService.getCompanyAndOfficeUser(userOfficeUtil);
			//注入在公司的角色
			//从注入角色
			userRoleService.getUserIdList(userOfficeUtil);
			if(userOfficeUtil.getRole()!=null){
				
				System.out.println("role"+userOfficeUtil.getRole());
				System.out.println("role"+userOfficeUtil.getRole().getName());
				Integer dataScope = Integer.parseInt(userOfficeUtil.getRole().getDataScope());
				Integer SessiondataScope = Integer.parseInt(userRoleType.getRole().getDataScope());
				if(SessiondataScope>dataScope){
					userOfficeUtil.setType(1);
				}else {
					
					userOfficeUtil.setType(0);
				}
			}
			UserOfficelist.add(userOfficeUtil);
		}
		System.out.println(UserOfficelist.get(0).getOfficeName());
		//超级管理员登录
		HashMap<String, Object> hm = new HashMap<String ,Object>();
		hm.put("total", UserOfficelist.size());
		hm.put("rows", UserOfficelist);
		String json = JSON.toJSONString(hm);
		//System.out.println(json);
		response.getWriter().println(json);
	}
	@RequestMapping("/Login")
	public void Login(HttpServletResponse response,SysUser user,HttpServletRequest request) throws IOException{
		//System.out.println(user.getLoginName());
		 user=userService.login(user);
		 int count=0;
		if(user!=null){
			//System.out.println(user.getLoginFlag());
			if(user.getLoginFlag().equals("1")){
				
				request.getSession().setAttribute("loginUser", user);
				count=1;
			}else{
				count=3;
			}
		}
		response.getWriter().println(count);
	}
	@RequestMapping("/LoginUser")
	public void LoginUser(HttpServletResponse response,SysUser user,HttpServletRequest request) throws IOException{
		
		System.out.println("loginUser"+user);
		UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(),user.getPassword());
		Subject subject = SecurityUtils.getSubject();
		int count=1;
		try {
			subject.login(token);
		} catch (Exception e) {
			//e.printStackTrace();
			count=0;
		}
		if(subject.isAuthenticated()){
			UserOfficeUtil userOffice = new UserOfficeUtil();
			SysUser user1 = (SysUser) SecurityUtils.getSubject().getPrincipal();
			//拿到登录对象的权限
			SysRole role=userRoleService.getRole(user1);
			userOffice.setRole(role);
			userOffice.setUser(user1);
			request.getSession().setAttribute("loginUserRole", userOffice);
			request.getSession().setAttribute("loginUser", user1);
			//System.out.println("成功");
		}else{
			//System.out.println(count);
			count=0;
		}
		response.getWriter().println(count);
	}
	@RequestMapping("/Index")
	public String Index(HttpServletResponse response,HttpServletRequest request) throws IOException{
		System.out.println("Index");
		request.getSession().removeAttribute("loginUser");
		return "redirect:/logout";
	}
	@RequestMapping(value="/Zhuce")
	public void Insert(HttpServletResponse response,HttpServletRequest request
			,SysUser user,@RequestParam("roleId") Integer roleID) throws IOException{
		System.out.println("Insert");
		//设置注册对象的完整性
		SysUser CreatUser = (SysUser)request.getSession().getAttribute("loginUser");
		//调用service进行操作
		SimpleHash simple = new SimpleHash("md5",user.getPassword(),"sxt",2);
		user.setPassword(simple.toString());
		int count=userService.ZhuCe(user,CreatUser);
		//System.out.println("count "+count);
		//count>0 说明  用户注册成功了
		if(count>0){
			//角色注册
			//roleService.zhuce(user,CreatUser);
			//查询对象
			int id=userService.getUserID(user.getName());
			user.setId(id);
			//用户角色表的添加
			System.out.println(roleID);
			System.out.println(user.getId());
			SysUserRoleKey userRole = new SysUserRoleKey();
			userRole.setRoleId(roleID);
			userRole.setUserId(user.getId());;
			count=userRoleService.insertUserRole(userRole);
			if(count>0){
				
				response.getWriter().println(1);
			}
		}else{
			
			response.getWriter().println(0);
		}
	}
	@RequestMapping(value="/Zhuce1")
	public void InsertUser(HttpServletResponse response,HttpServletRequest request,SysUser user) throws IOException{
		System.out.println("Insert");
		//设置注册对象的完整性
		SysUser CreatUser = (SysUser)request.getSession().getAttribute("loginUser");
		//调用service进行操作
		int count=userService.ZhuCe(user,CreatUser);
		System.out.println("count "+count);
		//count>0 说明  用户注册成功了
		if(count>0){
			//角色注册
			//roleService.zhuce(user,CreatUser);
		}else{
			
		}
		response.getWriter().println(1);
	}
	
	
}
