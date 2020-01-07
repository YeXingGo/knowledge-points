package com.ssm.service.Imp;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.entiy.SysUser;
import com.ssm.mapper.SysUserMapper;
import com.ssm.service.SysUserService;
@Transactional
@Service
public class SysUserServiceImp implements SysUserService {
	@Resource
	private SysUserMapper userd;
	@Override
	public List<SysUser> getAllSysUser() {
		
		return userd.getSysUserAll();
	}
	@Override
	public SysUser login(SysUser user) {
		user=userd.login(user);
		return user;
	}
	@Override
	public int ZhuCe(SysUser user,SysUser CreatUser) {
		//进行用户对象loginName的判断
		Integer count=userd.getLoginNameCount(user.getLoginName());
		//当count大于零说明 用户名已经被注册过了，所以需要重新输入
		if(count>0){
			
			return 0;
			//进行其他数据的补充
		}else{
			//作为工号的插入
			String no="t";
			while(true){
				
				int nextInt = new Random().nextInt(1000000);
				no+=nextInt;
				int count1=userd.getNoUser(no);
				if(count1==0){
					break;
				}else{
					no="t";
				}
			}
			user.setNo(no);
			user.setCreateBy(CreatUser.getLoginName());
			user.setCreateDate(new Date());
			user.setDelFlag(0+"");
			int insertUserCount=userd.insert(user);
			//System.out.println(user);
			return insertUserCount;
		}
	}
	@Override
	public int getUserID(String name) {
		return userd.getUserID(name);
	}
	@Override
	public SysUser findUser(String loginname) {
		System.out.println("1");
		SysUser user = userd.findUser(loginname);
		System.out.println("userService"+user);
		
		// TODO Auto-generated method stub
		return user;
	}
	@Override
	public List<SysUser> getCompanyIdFindUser(Integer companyId) {
		if(companyId==0){
			return userd.getSysUserAll();
		}else{
			return userd.getCompanyIdFindUser(companyId);
		}
	}

}
