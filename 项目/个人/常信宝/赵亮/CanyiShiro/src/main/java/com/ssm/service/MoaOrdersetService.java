package com.ssm.service;

import java.util.List;

import com.ssm.BeanUtils.MoaOrdersetUtil;
import com.ssm.entiy.MoaOrderset;
import com.ssm.entiy.SysUser;


public interface MoaOrdersetService {

	Integer insertMoaOrderUtil(MoaOrdersetUtil moaOrdersetUtli,SysUser user);

	List<MoaOrderset> getListOrderset(Integer id);



	
}
