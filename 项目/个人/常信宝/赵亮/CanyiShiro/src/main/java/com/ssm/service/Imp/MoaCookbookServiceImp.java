package com.ssm.service.Imp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.BeanUtils.StringFomateDate;
import com.ssm.entiy.MoaCookbook;
import com.ssm.entiy.MoaWeek;
import com.ssm.entiy.SysMenu;
import com.ssm.entiy.SysUser;
import com.ssm.mapper.MoaCookbookMapper;
import com.ssm.mapper.MoaWeekMapper;
import com.ssm.mapper.SysMenuMapper;
import com.ssm.service.MoaCookbookService;
import com.ssm.service.SysMenuService;

@Transactional
@Service
public class MoaCookbookServiceImp implements MoaCookbookService {
	@Resource
	private MoaCookbookMapper moaCookbookmapper;
	@Resource
	private MoaWeekMapper moaWeekMapper;

	@Override
	public List<MoaCookbook> getCookCdateList() {
		return moaCookbookmapper.getCookCdateList();
	}

	@Override
	public MoaCookbook findDateMoaCookbook(String date) {
		return moaCookbookmapper.findDateMoaCookbook(date);
	}

	@Override
	public int updateAndInsertCookbook(MoaCookbook moaCookbook) {
		int count=0;
		// TODO 添加或修改 菜谱表
		if(moaCookbook.getId()!=null){
			//更新操作
			//System.out.println("更新操作");
			count=moaCookbookmapper.updateByPrimaryKey(moaCookbook);
			if(count>0){
				count=3;
				return count;
			}
		}else{
			//添加
			//System.out.println("添加操作");
			count=moaCookbookmapper.insertSelective(moaCookbook);
			System.out.println(moaCookbook);
			if(count>0){
				count=4;
				return count;
			}
		}
		return count;
	}

	@Override
	public MoaCookbook getIdCookbook(Integer id) {

		return moaCookbookmapper.selectByPrimaryKey(id);
	}

	@Override
	public int insertMoaCookbookAndMoaWeek(SysUser user, MoaCookbook moaCookbook, String mondayDate,
			String sundayDate) throws ParseException {
		int count=0;
		//添加周表
		MoaWeek moaWeek = new MoaWeek();
		moaWeek.setDelFlag(0+"");
		moaWeek.setBegindate(StringFomateDate.SimpleFomate(mondayDate));
		moaWeek.setEnddate(StringFomateDate.SimpleFomate(sundayDate));
		moaWeek.setCreateBy(user.getLoginName());
	
		moaWeek.setCreateDate(new Date());
		moaWeek.setCreatedate(new Date());
		int bb = moaWeekMapper.insertSelective(moaWeek);
		moaWeek=moaWeekMapper.getWeekMapper(mondayDate);

		if(bb>0){

			if(moaCookbook.getId()!=null){
				//更新操作
				//[id=null, weekId=null, cdate=Thu Mar 07 00:00:00 CST 2019, 
				//cweek=周四, breakfast=炒粉, lunch=面包, createBy=null, createDate=null, 
				//updateBy=null, updateDate=null, remarks=null, delFlag=0]
				if(moaWeek.getId()!=null){
						moaCookbook.setWeekId(bb);
						moaCookbook.setUpdateBy(user.getLoginName());
						moaCookbook.setUpdateDate(new Date());
						 count = moaCookbookmapper.updateByPrimaryKey(moaCookbook);
						
				}
				 if(count>0){
					 count=3;
				 }
			}else{
				//添加操作
				if(moaWeek.getId()!=null){
					moaCookbook.setWeekId(bb);
					moaCookbook.setCreateDate(new Date());
					moaCookbook.setCreateBy(user.getLoginName());
					count=moaCookbookmapper.insertSelective(moaCookbook);
					
				}
				if(count>0){
					count=4;
				}
			}
		}
		return count;
	}

	@Override
	public List<MoaCookbook> getCookCdateListDate(Integer i) {
		return moaCookbookmapper.getCookCdateListDate(i);
	}

	/*public static void main(String[] args) throws ParseException {
		Date mondate = StringFomateDate.SimpleFomate("2019-03-03");
		System.out.println(mondate.getTime());
		String simpleFomate = StringFomateDate.SimpleFomate(mondate);
		System.out.println(simpleFomate);

	}*/
}
