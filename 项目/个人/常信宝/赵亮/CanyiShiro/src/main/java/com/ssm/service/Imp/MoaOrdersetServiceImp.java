package com.ssm.service.Imp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.BeanUtils.MoaOrdersetUtil;
import com.ssm.BeanUtils.StringFomateDate;
import com.ssm.entiy.MoaCookbook;
import com.ssm.entiy.MoaOrderset;
import com.ssm.entiy.SysUser;
import com.ssm.mapper.MoaCookbookMapper;
import com.ssm.mapper.MoaOrdersetMapper;
import com.ssm.service.MoaOrdersetService;

@Transactional
@Service
public class MoaOrdersetServiceImp implements MoaOrdersetService {
	@Resource
	private MoaOrdersetMapper moaOrdersetMapper;
	@Resource
	private MoaCookbookMapper moaCookbookMapper;
	@Override
	public Integer insertMoaOrderUtil(MoaOrdersetUtil moaOrdersetUtli,SysUser user) {
		Integer count=0;
		Date cdate = moaOrdersetUtli.getCdate();
		String fomate = StringFomateDate.SimpleFomate(cdate);
		//查询所属菜谱
		MoaCookbook moaCookbook=moaCookbookMapper.findDateMoaCookbook(fomate);
		
		if(moaCookbook!=null){
			MoaOrderset moaOrderset = moaOrdersetUtli.getMoaOrderset();
			moaOrderset.setCreateDate(new Date());
			moaOrderset.setCookbookId(moaCookbook.getId());
			MoaOrderset moaOrderset1 = moaOrdersetUtli.getMoaOrderset1();
			moaOrderset1.setCreateDate(new Date());
			moaOrderset1.setCookbookId(moaCookbook.getId());
			MoaOrderset moaOrderset2 = moaOrdersetUtli.getMoaOrderset2();
			moaOrderset2.setCreateDate(new Date());
			moaOrderset2.setCookbookId(moaCookbook.getId());
			moaOrderset.setDelFlag(0+"");
			moaOrderset1.setDelFlag(0+"");
			moaOrderset2.setDelFlag(0+"");
			if(user!=null){
				moaOrderset.setCreateBy(user.getLoginName());
				moaOrderset1.setCreateBy(user.getLoginName());
				moaOrderset2.setCreateBy(user.getLoginName());
			}
			int insert = moaOrdersetMapper.insert(moaOrderset);
			if(insert>0){
				insert = moaOrdersetMapper.insert(moaOrderset1);
				if(insert>0){
					insert = moaOrdersetMapper.insert(moaOrderset2);
					count=1;
				}
			}
		}
		return count;
	}
	@Override
	public List<MoaOrderset> getListOrderset(Integer id) {
		return moaOrdersetMapper.getListOrderset(id);
	}




}
