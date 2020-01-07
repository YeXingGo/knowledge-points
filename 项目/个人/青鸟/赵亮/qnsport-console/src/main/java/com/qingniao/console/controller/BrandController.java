package com.qingniao.console.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qingniao.common.page.PageInfo;
import com.qingniao.core.pojo.Brand;
import com.qingniao.core.pojo.BrandExample;
import com.qingniao.core.service.BrandService;

/**
 * 品牌controller
 * @author Lenovo
 *
 */
@Controller
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	@RequestMapping("/brand/list.do")
	//进入品牌页面
	//TODO 品牌展示页面
	public String brandList(String name,Integer status,Integer pageNo,Model model) throws Exception{
		BrandExample brandExample =new BrandExample();
		StringBuilder param = new StringBuilder();
		//如果是null 说明是第一次加载，直接给他第一页显示就可以了
		if(pageNo ==null){
			pageNo=1;
		}
		brandExample.setPageNo(pageNo);
		//品牌名称的判断  
		/**
		 * 如果自己写不会使用name.trim().length()
		 * 因为：自己以前感觉到这个是多余的，不写不是也能完成
		 * 到了今天去写发现这个必须写，这个
		 */
		System.out.println("111");
		String statusType="";
		if(name != null && name.trim().length() > 0){
			 name= new String(name.getBytes("ISO-8859-1"),"utf8");
			//TODO 转换前台数据的编码格式
			brandExample.setName(name);
			model.addAttribute("name", name);
			param.append("name="+name);
			statusType="&status=";
		}else{
			statusType="status=";
		}
		
		//判断条件,在售和停售的判断
		if(status != null){
			brandExample.setStatus(status);
			//System.out.println("状态"+status);
			//
		}else{
			brandExample.setStatus(1); //如果是null则查询在售品牌
		}
		//如果name==null就会出现错误
		param.append("&status="+status);
		//param.append(statusType+status);
		model.addAttribute("status", status);
		//创建分页工具栏
		String url="/brand/list.do";
		PageInfo pageInfo = brandService.selectByExample(brandExample);
		pageInfo.pageView(url, param.toString()); 
		
		model.addAttribute("pageInfo", pageInfo);
		//回显当前页
		model.addAttribute("pageOn",pageNo);
		return "brand/list";
	}
	
	@RequestMapping("/brand/add.do")
	//跳转到品牌添加
	public String add(){
		return "brand/add";
	}
	
	@RequestMapping("/brand/save.do")
	//编写品牌的添加方法
	public String addBrand(Brand brand){
		brandService.insertBrand(brand);
		return "redirect:/brand/list.do";
	}
}
