package com.ssm.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.ssm.BeanUtils.SouMoaWeek;
import com.ssm.entiy.MoaWeek;
import com.ssm.service.MoaWeekService;
@RequestMapping("/moaWeek")
@Controller
public class MoaWeekController {
	@Autowired
	private MoaWeekService moaWeekService;
	@RequestMapping("/getAllMoaWeek")
	public void getAllMoaWeek(HttpServletResponse response) throws IOException{
		List<MoaWeek> lists=moaWeekService.getAllMoaWeek();
		HashMap<Object, Object> hm = new HashMap<>();
		hm.put("total", lists.size());
		hm.put("rows", lists);
		String json = JSON.toJSONString(hm);
		response.getWriter().println(json);
	}
	@RequestMapping("/LikeMoaWeek")
	public void LikeMoaWeek(HttpServletResponse response,SouMoaWeek souMoaWeek) throws IOException{
		//System.out.println("LikeMoaWeek");
		//System.out.println(souMoaWeek.getDate());
		if(souMoaWeek.getDate().equals("")){
			souMoaWeek.setDate(null);
		}
		//System.out.println(souMoaWeek.getId());
		List<MoaWeek> lists=moaWeekService.LikeMoaWeek(souMoaWeek);
		System.out.println(souMoaWeek);
		HashMap<Object, Object> hm = new HashMap<>();
		hm.put("total", lists.size());
		hm.put("rows", lists);
		String json = JSON.toJSONString(hm);
		//System.out.println(hm);
		response.getWriter().println(json);
	}
	
}
