package com.qingniao.core.service;

import com.qingniao.common.page.PageInfo;
import com.qingniao.core.pojo.Brand;
import com.qingniao.core.pojo.BrandExample;

/**
 * 品牌的添加Service
 * @author Lenovo
 *
 */
public interface BrandService {
	public void insertBrand(Brand brand);
	
	public PageInfo selectByExample(BrandExample brandExample);
}
