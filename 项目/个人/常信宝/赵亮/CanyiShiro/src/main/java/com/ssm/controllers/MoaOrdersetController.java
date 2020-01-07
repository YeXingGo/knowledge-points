package com.ssm.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.ssm.BeanUtils.MoaBookAndMoaOrdersetUtil;
import com.ssm.BeanUtils.MoaOrdersetUtil;
import com.ssm.BeanUtils.StringFomateDate;
import com.ssm.entiy.MoaCookbook;
import com.ssm.entiy.MoaOrderset;
import com.ssm.entiy.SysUser;
import com.ssm.service.MoaCookbookService;
import com.ssm.service.MoaOrdersetService;
@RequestMapping("/moaOrderset")
@Controller
public class MoaOrdersetController {
	@Autowired
	private MoaOrdersetService moaOrdersetService;
	@Autowired
	private MoaCookbookService moaCookbookService;
	@RequestMapping("/insertMoaOrder")
	public void insertMoaOrder(HttpServletResponse response,HttpServletRequest request,MoaOrdersetUtil moaOrdersetUtli) throws IOException{
		SysUser user = (SysUser)request.getSession().getAttribute("loginUser");
			Integer count=moaOrdersetService.insertMoaOrderUtil(moaOrdersetUtli,user);
		response.getWriter().println(count);
	}
	@RequestMapping("/selectMoaOrderSetAll")
	public void selectMoaOrderSetAll(HttpServletResponse response,HttpServletRequest request,MoaOrdersetUtil moaOrdersetUtli) throws IOException{
		//System.out.println("selectMoaOrderSetAll");
		//工具类 
		ArrayList<MoaBookAndMoaOrdersetUtil> utilList = new ArrayList<MoaBookAndMoaOrdersetUtil>();
		//按照时间倒序展示，最上面展示当日菜谱。
		MoaBookAndMoaOrdersetUtil moaBookAndMoaOrdersetUtil=null;
		Integer index=null;
		//作为今天的判断
		Date date = new Date();
		String simple = StringFomateDate.SimpleFomate(date);
		//先去查询所有的菜谱
		List<MoaCookbook> cookCdateList = moaCookbookService.getCookCdateListDate(1);
		for (int i=0;i<cookCdateList.size();i++) {
			if(cookCdateList.get(i).getId()!=null){
				Date date1=cookCdateList.get(i).getCdate();
				String simpleFomate = StringFomateDate.SimpleFomate(date1);
				//查询对应的
				if(simple.equals(simpleFomate)){
					index=i;
				}
				MoaBookAndMoaOrdersetUtil bookOrderList = new MoaBookAndMoaOrdersetUtil();
				MoaCookbook moaCookbook = cookCdateList.get(i);
				bookOrderList.setMoaCookBook(moaCookbook);
				List<MoaOrderset>moaOrderList=moaOrdersetService.getListOrderset(moaCookbook.getId());
				if(moaOrderList!=null){
					//添加到
					bookOrderList.setList(moaOrderList);
				}
				utilList.add(bookOrderList);
			}
		}
		//把当天的排在最上边
		ArrayList<MoaBookAndMoaOrdersetUtil> utilList1 = new ArrayList<MoaBookAndMoaOrdersetUtil>();
		if(index!=null){
			MoaBookAndMoaOrdersetUtil moaJin = utilList.get(index);
			utilList.remove(moaJin);
			//		9	8	7	6	5	4
			//		6	9	8	7	5	4
			for (int i = 0; i < utilList.size()-1; i++) {
				if(i==0){
					utilList1.add(moaJin);
				}else{
					utilList1.add(utilList.get(i-1));
				}
				
			}
		}else{
			utilList1=utilList;
		}
		for (MoaBookAndMoaOrdersetUtil moaBookAndMoaOrdersetUtil2 : utilList1) {
			//System.out.println(moaBookAndMoaOrdersetUtil2.getMoaCookBook());
		}
		
		HashMap<String, Object> hm = new HashMap<String,Object>();
		hm.put("total", utilList1.size());
		hm.put("rows", utilList1);
		 String json = JSON.toJSONString(hm);
		// System.out.println(json);
		response.getWriter().println(json);
	}
		public static void main(String[] args) {
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			arrayList.add(1);
			arrayList.add(2);
			System.out.println(arrayList.toString());
			arrayList.remove(0);
			System.out.println(arrayList.size());
			System.out.println(arrayList.toString());
			System.out.println(arrayList.get(0));
		}
}
