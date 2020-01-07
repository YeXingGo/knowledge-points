package com.ssm.BeanUtils;


import com.ssm.entiy.SysRole;
import com.ssm.entiy.SysUser;

public class UserOfficeUtil {
	private SysUser user;
	private String comptyName;
	private String officeName;
	private SysRole role;
	private Integer type; 
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public SysRole getRole() {
		return role;
	}
	public void setRole(SysRole role) {
		this.role = role;
	}
	public SysUser getUser() {
		return user;
	}
	public void setUser(SysUser user) {
		this.user = user;
	}
	public String getComptyName() {
		return comptyName;
	}
	public void setComptyName(String comptyName) {
		this.comptyName = comptyName;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
}
