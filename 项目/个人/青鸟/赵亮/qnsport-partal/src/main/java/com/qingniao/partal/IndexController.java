package com.qingniao.partal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 前台页面跳转
 * @author quan
 *
 */
@Controller
public class IndexController {
	
	@RequestMapping("/index.html")
	public String index() {
		return "product/product";
	}
}
