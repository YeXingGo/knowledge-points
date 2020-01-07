package com.qingniao.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 初始化页面
 * @author Lenovo
 *
 */
@Controller
public class IndexController {
	@RequestMapping("/index.do")
	public String index(){
		System.out.println("-----");
		return "index";
	}
	@RequestMapping("/top.do")
	public String top(){
		return "top";
	}
	@RequestMapping("/main.do")
	public String main(){
		return "main";
	}
	//加载首页的左边菜单
	@RequestMapping("/right.do")
	public String right(){
		return "right";
	}
	//加载首页的右边的菜单
	@RequestMapping("/left.do")
	public String left(){
		return "left";
	}
	//跳转商品页
	@RequestMapping("/productMain.do")
	public String productMain(){
		return "product/product_main";
	}
	//加载商品页的左边栏
	@RequestMapping("/productLeft.do")
	public String productLeft(){
		return "product/product_left";
	}
}
