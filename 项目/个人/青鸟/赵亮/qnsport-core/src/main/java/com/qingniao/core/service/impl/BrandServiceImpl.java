 package com.qingniao.core.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qingniao.common.page.PageInfo;
import com.qingniao.core.dao.BrandMapper;
import com.qingniao.core.pojo.Brand;
import com.qingniao.core.pojo.BrandExample;
import com.qingniao.core.service.BrandService;
/**
 * 品牌的业务类
 * @author Lenovo
 *
 */
@Service
@Transactional	
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandMapper brandMapper;
	@Override
	public void insertBrand(Brand brand) {
		// TODO 品牌的插入
		brandMapper.insertBrand(brand);
	}
	
	@Override
	public PageInfo selectByExample(BrandExample brandExample) {
		/**
		 * 因为pageInfo中需要调用BrandMapper中查询总条数的方法，
		 * 所以把他放在了Service中
		 * 	如果自己肯定直接放在了Controller，因为方便
		 */
		/**
		 * brandMapper.selectCount方法中为什么要放一个对象？
		 * 	因为前台查询是可以通过条件查询或者没有条件查询，
		 * 等于说这个方法可以把这两种情况都涵盖在内
		 */
		//这里只做pageInfo 的创建 ，没有去做 展示在前台的数据
		PageInfo pageInfo = new PageInfo(brandExample.getPageNo(),brandExample.getPageSize(),brandMapper.selectCount(brandExample));
		pageInfo.setList(brandMapper.selectByExample(brandExample));
		return pageInfo;
	}

}
