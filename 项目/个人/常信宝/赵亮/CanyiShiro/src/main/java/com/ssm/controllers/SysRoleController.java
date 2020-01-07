package com.ssm.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.ssm.entiy.SysRole;
import com.ssm.entiy.SysUser;
import com.ssm.service.SysRoleService;
import com.ssm.service.SysUserService;
@Controller
@RequestMapping("/role")
public class SysRoleController {
	@Autowired
	private SysRoleService roleService ;


	/*测试方法
	 * 
	 * @RequestMapping("/index")
	public String getAllUser(){
		System.out.println("11");
		return "ss";
	}*/
	
	@RequestMapping("/getSysRoleAll")
	public void getSysUserAll(HttpServletResponse response) throws IOException{
		HashMap<String, Object> hm = new HashMap<String ,Object>();
		List<SysRole> list = roleService.getAllSysUser();
		hm.put("total", list.size());
		hm.put("rows", list);
		String json = JSON.toJSONString(hm);
		response.getWriter().println(json);
	}
	
	
	
}
