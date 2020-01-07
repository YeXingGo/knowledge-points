package com.ssm.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.ssm.entiy.SysOffice;
import com.ssm.entiy.SysRole;
import com.ssm.entiy.SysUser;
import com.ssm.entiy.SysUserRoleKey;
import com.ssm.service.SysOfficeService;
import com.ssm.service.SysRoleOfficeService;
import com.ssm.service.SysRoleService;
import com.ssm.service.SysUserRoleService;
@Controller
@RequestMapping("/office")
public class SysOfficeController {
	@Autowired
	private SysOfficeService officeService;
	@Autowired
	private SysUserRoleService userRoleService;
	@Autowired
	private SysRoleService roleService;
	@Autowired
	private  SysRoleOfficeService roleOfficeService;

	@RequestMapping("/getOfficeAll")
	public void getOfficeAll(SysOffice office,HttpServletResponse response
			
			,HttpServletRequest request) throws IOException{
		HashMap<String,Object> hm=new HashMap<String,Object>();
		/*
		 * 1.注册开始
		 * 2.查看登录的用户是什么角色(主要看office_id 和data_scope) 
		 * 		1.查询sys_user_role
		 * 		2.查询sys_role
		 * 
		 * 
		 * */
		//拿到登录的用户
		SysUser user =(SysUser) request.getSession().getAttribute("loginUser");
		//System.out.println(user.getLoginName());
		//用登录的用户进行查询 用户角色表
		List<SysUserRoleKey> userRoleList= userRoleService.getUserRoleKey(user);
		//定义角色的 家   用于
		ArrayList<SysRole> roleList = new ArrayList<SysRole>();
		for (SysUserRoleKey sysUserRoleKey : userRoleList) {
			SysRole role=roleService.getRole(sysUserRoleKey.getRoleId());
			roleList.add(role);
		}
		//找到最大的数据操作范围的角色 sysRoles
		SysRole sysRoles=null;
		int count=10;
		for (SysRole sysRole : roleList) {
			int j=Integer.parseInt(sysRole.getDataScope());
			if(j<=count){
				count=j;
				sysRoles=sysRole;
			}
		}
		int socpe= Integer.parseInt(sysRoles.getDataScope());
		List<SysOffice> list=null;
		int type=0;
		switch (socpe) {
		//可以操作所有数据
		case 0:
			list = officeService.getGongSiOffice();
			type=1;
			break;
			//所在公司及以下数据
		case 1:
			list = officeService.getGongSiOffice();
			type=1;
			
			break;
			//所在公司数据
		case 2:
			list = officeService.getGongSiOffice();
			type=1;
			
			break;
			//所在部门及以下数据
		case 3:
			list=officeService.getBumen(sysRoles);
			type=2;
			break;
			//所在部门数据
		case 4:
			list=officeService.getBumen(sysRoles);
			type=2;
			
			break;
			//仅是本人
		case 8:
			
			
			break;
			//按明细设置
		case 9:
			
			break;
		
		default:
			break;
		}
		hm.put("list", list);
		hm.put("type", type);
		String json=JSON.toJSONString(hm);
		System.out.println(json);
		response.getWriter().println(json);
	}
	@RequestMapping("/getOfficeBumen")
	public void getOfficeBumen(@Param("id")Integer id,HttpServletResponse response) 
			throws IOException{
		SysRole sysRole = new SysRole();
		sysRole.setOfficeId(id);
		List<SysOffice> list = officeService.getBumen(sysRole);
		String json=JSON.toJSONString(list);
		response.getWriter().println(json);
	}
/*	@RequestMapping("/Zhuce")
	public void Zhuce(SysUser user,HttpServletResponse response) 
			throws IOException{
			System.out.println(user);
			
		response.getWriter().println(JSON.toJSONString(1));
	}*/
	//获取所有的公司 用于员工注册
		@RequestMapping(value="/getAllGongSi")
		public void getAllGongSi(HttpServletResponse response) throws IOException{
			//查询所有公司
			List<SysOffice> GongSiList = officeService.getGongSiOffice();
			HashMap<String, Object> hm = new HashMap<String,Object>();
			hm.put("list", GongSiList);
			String json=JSON.toJSONString(hm);
			response.getWriter().println(json);
		}
		//获取该部门的所有的角色
		@RequestMapping(value="/getOfficeRole")
		public void getOfficeRole(HttpServletResponse response,Integer id) throws IOException{
			System.out.println("getAllGongSi");
			//先去查找给部门对应的角色id有哪些  <foreach collection="list" item="rid" open="(" close=")"></foreach>
			//查询所有公司  去角色机构表中查询
			List<Integer> roleIdS=roleOfficeService.getRoleList(id);
			//System.out.println("该部门下所有的角色id");
			//便利该部门所有员工的id
			/*for (Integer integer : roleIdS) {
				System.out.println(integer);
			}*/
			
			//通过返回多个角色id进行查询  角色表
			List<SysRole> roleList=roleService.getRoleAll_OfficeID(roleIdS);
			//查看该部门下角色的名称
			/*for (SysRole sysRole : roleList) {
				System.out.println(sysRole.getName());
			}*/
			
			
			HashMap<String, Object> hm = new HashMap<String,Object>();
			hm.put("list", roleList);
			String json=JSON.toJSONString(hm);
			response.getWriter().println(json);
		}
	
}
