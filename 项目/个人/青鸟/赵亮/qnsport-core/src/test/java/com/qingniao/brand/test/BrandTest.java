package com.qingniao.brand.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qingniao.common.page.PageInfo;
import com.qingniao.core.dao.BrandMapper;
import com.qingniao.core.pojo.Brand;
import com.qingniao.core.pojo.BrandExample;

/**
 * 品牌测试类
 * @author Lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/applicationContext-*.xml"})
public class BrandTest {
	@Autowired
	private BrandMapper brandMapper;
	//测试品牌添加\
	@Test
	public void insertBrand(){
		Brand brand = new Brand();
/*		brand.setId(1L);*/
		brand.setName("安踏");
		brand.setDescription("安踏是一个运动平台");
		brand.setLogo("/imgs/1554894694685705.jpg");
		brand.setUrl("www.anta.com");
		brand.setStatus(1);
		brandMapper.insertBrand(brand);
	}
	//TODO 测试条件查询 
	@Test
	public void selectByBrandExample(){
		BrandExample brandExample = new BrandExample();
		List<Brand> brandList = brandMapper.selectByExample(brandExample);
		System.out.println(brandList.size());
	}
	//TODO 测试分页
	@Test
	public void selectLimitBrandExample(){
		BrandExample brandExample = new BrandExample();
		brandExample.setPageNo(2);
		brandExample.setPageSize(5);
		List<Brand> selectByExample = brandMapper.selectByExample(brandExample);
		System.out.println(selectByExample.size());
	}
	//TODO 测试品牌的个数
	@Test
	public void demo4(){
		BrandExample brandExample = new BrandExample();
		brandExample.setStatus(2);
		Integer count = brandMapper.selectCount(brandExample);
		System.out.println(count);
	}
	//TODO 测试分页工具
	@Test
	public void demo5(){
		BrandExample brandExample = new BrandExample();
		brandExample.setPageNo(1);
		brandExample.setPageSize(2);
		
		//创建分页工具
		PageInfo pageInfo = new PageInfo(brandExample.getPageNo(),brandExample.getPageSize(),brandMapper.selectCount(brandExample));
		pageInfo.setList(brandMapper.selectByExample(brandExample));
		
	}
	//分页工具栏
	@Test
	public void demo6(){
		BrandExample brandExample = new BrandExample();
		brandExample.setPageNo(1);
		brandExample.setPageSize(2);
		
		//创建分页工具
		PageInfo pageInfo = new PageInfo(brandExample.getPageNo(),brandExample.getPageSize(),brandMapper.selectCount(brandExample));
		pageInfo.setList(brandMapper.selectByExample(brandExample));
		/*ArrayList<String> pageView = new ArrayList<String>();
		pageView.add("<")
		pageInfo.setPageView();*/
		
		
		String url="/brand/list.do";
		StringBuilder params =new StringBuilder();
		params.append("name=张三").append("&status=1");
		pageInfo.pageView(url, params.toString());
		List<String> pageView = pageInfo.getPageView();
		System.out.println(pageView); //打印分页工具栏
	}
}
