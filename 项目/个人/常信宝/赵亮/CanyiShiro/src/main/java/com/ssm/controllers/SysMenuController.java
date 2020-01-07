package com.ssm.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.ssm.BeanUtils.StringFomateDate;
import com.ssm.BeanUtils.ZhouYiDaoZhouRi;
import com.ssm.entiy.MoaCookbook;
import com.ssm.entiy.MoaWeek;
import com.ssm.entiy.SysMenu;
import com.ssm.entiy.SysUser;
import com.ssm.service.MoaCookbookService;
import com.ssm.service.MoaWeekService;
import com.ssm.service.SysMenuService;
@Controller
@RequestMapping("/menu")
public class SysMenuController {
	@Autowired
	private SysMenuService menuService;
	@Autowired
	private MoaCookbookService moaCookbookService;
	@Autowired
	private MoaWeekService maoWeekService;
	@RequestMapping("/GetMenu")
	public void GetMenu(HttpServletResponse response,HttpServletRequest request) throws IOException{
		//查询午饭和早饭
		List<SysMenu> menus=menuService.findBreakAndLunch(1);
/*		//查询所有菜谱的时间
		List<Integer> datas=moaCookbookService.getCookCdateList();
		request.getSession().setAttribute("dataList", datas);*/
		String json = JSON.toJSONString(menus);
		//System.out.println(json);
		response.getWriter().println(json);
	}
	@RequestMapping("/YanDate")
	public void YanDate(HttpServletResponse response,HttpServletRequest request) throws IOException{
		System.out.println("YanDate");
		String s=request.getParameter("dat");
		   HashMap<String, Object> hm = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd yyyy HH:mm:ss z", Locale.US);
		if(s!=null){
			//System.out.println(s);
		    s = s.replace("GMT", "").replaceAll("\\(.*\\)", "");
		    String date=null;
		    //将字符串转化为date类型，格式2016-10-12
		    SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss z", Locale.ENGLISH);
		    Date dateTrans = null;
		    try {
		        dateTrans = format.parse(s);
		         date = new SimpleDateFormat("yyyy-MM-dd").format(dateTrans).replace("-","/");
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		    System.out.println(date);
		    //查询该时间的对象
		   MoaCookbook  moaCookbook= moaCookbookService.findDateMoaCookbook(date);
		   
		   if(moaCookbook!=null){
			   hm.put("count", 1);
			   hm.put("moaCookbook", moaCookbook);
		   }else{
			   hm.put("count", 0);
		   }
		}
		String json = JSON.toJSONString(hm);
		//System.out.println(json);
		response.getWriter().println(json);
	}
	//TODO 添加菜谱
	@RequestMapping("/ZhuCeAndUpdate")
	public void ZhuCeAndUpdate(HttpServletResponse response,HttpServletRequest request,MoaCookbook moaCookbook) throws IOException, ParseException{
		System.out.println("ZhuCeAndUpdate");
		String s=request.getParameter("menuType");
		Integer id=null;
		//将date转换为字符串
		String date = StringFomateDate.SimpleFomate(moaCookbook.getCdate());
		MoaWeek moaWeek = maoWeekService.findWeekDate(date);
		SysUser user = (SysUser)request.getSession().getAttribute("loginUser");
		int count=0;
		moaCookbook.setDelFlag(0+"");
		if(s!=null){
			String lunch=moaCookbook.getLunch();
			String breakfast=moaCookbook.getBreakfast();
			id=Integer.parseInt(s);
			if(moaWeek!=null){
				//查询原有的 菜谱
				 moaCookbook = moaCookbookService.getIdCookbook(id);
				 moaCookbook.setWeekId(moaWeek.getId());
				 moaCookbook.setLunch(lunch);
				 moaCookbook.setBreakfast(breakfast);
				//摄入第几周
				if(user!=null){
					moaCookbook.setUpdateBy(user.getName());
				}
				moaCookbook.setUpdateDate(new Date());
				//执行更新方法
				 count=moaCookbookService.updateAndInsertCookbook(moaCookbook);
			}else{
				 moaCookbook = moaCookbookService.getIdCookbook(id);
				 moaCookbook.setLunch(lunch);
				 moaCookbook.setBreakfast(breakfast);
				//[id=null, weekId=null, cdate=Thu Mar 07 00:00:00 CST 2019, 
				//cweek=周四, breakfast=炒粉, lunch=面包, createBy=null, createDate=null, 
				//updateBy=null, updateDate=null, remarks=null, delFlag=0]
				Map<String, String> weekDate = ZhouYiDaoZhouRi.getWeekDate(moaCookbook.getCdate());
				String mondayDate = weekDate.get("mondayDate");
				String sundayDate = weekDate.get("sundayDate");
			//	System.out.println(mondayDate);
			//	System.out.println(sundayDate);
				count=moaCookbookService.insertMoaCookbookAndMoaWeek(user,moaCookbook,mondayDate,sundayDate);
			}
			//作为更新
			/*System.out.println(request.getParameter("cweek"));
			System.out.println(s);
			System.out.println(date);
			System.out.println(moaCookbook);*/
		}else{
			if(moaWeek!=null){
				//执行插入菜谱表
				moaCookbook.setWeekId(moaWeek.getId());
				if(user!=null){
					moaCookbook.setCreateBy(user.getLoginName());
				}
				moaCookbook.setCreateDate(new Date());
				//执行更新方法
				count=moaCookbookService.updateAndInsertCookbook(moaCookbook);
			}else{
				//出现 周表中有没数据 
				//[id=null, weekId=null, cdate=Thu Mar 07 00:00:00 CST 2019, cweek=周四, breakfast=米饭, 
				//lunch=米饭, createBy=null, createDate=null,
				//updateBy=null, updateDate=null, remarks=null, delFlag=0]
				Map<String, String> weekDate = ZhouYiDaoZhouRi.getWeekDate(moaCookbook.getCdate());
				String mondayDate = weekDate.get("mondayDate");
				String sundayDate = weekDate.get("sundayDate");
				/*System.out.println(mondayDate);
				System.out.println(sundayDate);*/
				count=moaCookbookService.insertMoaCookbookAndMoaWeek(user,moaCookbook,mondayDate,sundayDate);
				
				
			}
		}
		//System.out.println(count);
		//select * from moa_week where begindate<="2019-3-19" and enddate>="2019-3-19"
		response.getWriter().println(count);
	}
	//TODO 查询所有菜品
	@RequestMapping("/getCaiPin")
	public void getCaiPin(HttpServletResponse response,HttpServletRequest request) throws IOException{
		//查询午饭和早饭
		List<SysMenu> menus=menuService.findCaiPin(5);
		String json = JSON.toJSONString(menus);
		response.getWriter().println(json);
	}

	
}
