package com.qingniao.core.dao;

import java.util.List;

import com.qingniao.core.pojo.Brand;
import com.qingniao.core.pojo.BrandExample;

public interface BrandMapper {
	public void insertBrand(Brand brand);
	public List<Brand> selectByExample(BrandExample brandExample);
	public Integer selectCount(BrandExample brandExample);
}	
