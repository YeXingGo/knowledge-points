<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>菜单管理</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css"
	href="<%=path%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/themes/demo.css">
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script type="text/javascript">
 	$(function(){
 		
		//查询早饭和午饭
		$.ajax({
			url:"<%=path%>/menu/GetMenu",
			success:function(data){
				//alert(data);
				var list=$.parseJSON(data);
				/* <select name="breakfast">
				<option></option>
			</select> */
			$("select[name='lunch']").empty();
			$("select[name='breakfast']").empty();
				$(list).each(function(){
					$("select[name='lunch']").append(
						"<option value='"+this.name+"' >"+this.name+"</option>"	
					)
					$("select[name='breakfast']").append(
						"<option value='"+this.name+"' >"+this.name+"</option>"	
					)
				})
			}
		})
		
		//用于日期绑定
		$("#dd").datebox({
			onSelect: function(date){
				//alert($(this).val());
				 d=$(this).val();
				var d=new Date(d);
				//alert(d.getDate())
				var date1=new Date();
				//alert(date.getMonth()+":"+d.getMonth()+"-"+d.getDate());
				
				 if(date1.getFullYear()<d.getFullYear()){
				 }
				if(date1.getMonth()<d.getMonth()){
				 }else if(date1.getMonth()==d.getMonth()){
					
					 if(date1.getDate()>d.getDate()){
							alert("不能更新，已过期")
							return false;
					 }else{
					 }
				 }else if(date1.getMonth()>d.getMonth()){
					 alert("不能更新，已过期")
						return false;
				 }
				
				//alert(date)
				//用于验证日期是否使用过
		 		$.ajax({
		 			url:"<%=path%>/menu/YanDate",
		 			data:{
		 				"dat":date
		 			},
		 			success:function(data){
		 				//alert(data)
		 				var hm=$.parseJSON(data);
		 				//alert(hm.count)
		 				if(hm.count==1){
		 					alert("已经设置过了，要进行更新吗")
		 					
		 				//	alert(hm.moaCookbook.lunch)
		 					$("select[name='lunch']").children().each(function(){
		 						if($(this).attr("value")==hm.moaCookbook.lunch){
		 							//alert($(this).attr("sname"))
		 							$(this).attr("selected",true);
		 						}
		 					
		 					})
		 					$("select[name='breakfast']").children().each(function(){
		 						if($(this).attr("value")==hm.moaCookbook.breakfast){
		 							//alert($(this).attr("sname"))
		 							$(this).attr("selected",true);
		 						}
		 					
		 					})
		 					//作为判断 操作为更新和 添加
		 					$("input[hh='ss']").attr("name","menuType");
		 					$("input[hh='ss']").val(hm.moaCookbook.id)
		 				}else{
		 					$("input[hh='ss']").attr("name","menu");
		 				}
		 			}
		 		})
				//alert(date.getFullYear()+":"+(date.getMonth()+1)+":"+date.getDate());
				var date=new Date(date).getDay();
				//alert(new Date(date).getDay())
				var ws="";
				//alert(date)
				if(date==1){
					ws="周一";
				}else if(date==2){
					ws="周二";
				}else if(date==3){
					ws="周三";
				}else if(date==4){
					ws="周四";
				}else if(date==5){
					ws="周五";
				}else if(date==6){
					ws="周六";
				}else if(date==0){
					ws="周日";
				}
				$("#week").textbox({
                        value: ws
                });
             
			}
		});
	}) 

	//表单提交
	function submitForm() {
		var d=$("input[name='cssdate']").val();
		var cweek=$("input[name='cweek']").val();
		//alert(cweek)
		$('#ff').form('submit',{
			url:"<%=path%>/menu/ZhuCeAndUpdate",
		/* 	 onSubmit: function(param){
					param.cdate = d;
					param.cweek = cweek;
			    }, */
			success:function(date){
				if(date==3){
					alert("更新成功")
					$('#ff').form('clear');
				}else if(date==4){
					alert("添加成功")
				}else if(date==0){
					alert("添加失败，请先去添加周表")
				}
			}
		});
		return false;
	}
	function clearForm() {
		$('#ff').form('clear');
	}
	//<!--new Date('2015-09-27').getDay()-->
	
	
	
	//<!--日期框js-->
	function myformatter(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	}
	function myparser(s){
		if (!s) return new Date();
		var ss = (s.split('-'));
		var y = parseInt(ss[0],10);
		var m = parseInt(ss[1],10);
		var d = parseInt(ss[2],10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
			return new Date(y,m-1,d);
		} else {
			return new Date();
		}
	}
</script>
</head>

<body data-options="fit:'true'" style="width: 700px; height: 800px">
	<!-- 开始布局 -->
	<div class="easyui-layout" style="width: 900px; height: 600px;">
		<div data-options="region:'south',split:true" style="height: 50px;"></div>
		<div
			data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
			<div class="easyui-panel" title="" style="width: 400px" data-options="fit:true">
				<div style="padding: 10px 60px 20px 60px">
					<form id="ff" method="post">
						<table cellpadding="5">
							<tr>
								<td>选择日期:</td>
								<td>
									<input id="dd" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" name="cdate"></input>
								</td>
								<td>
									&nbsp;&nbsp;&nbsp;&nbsp;<!-- <a href="#" onclick="return ss()">sss</a> -->
								</td>
								<td>
									<input class="easyui-textbox" style="width:75px;height:30px" name="cweek" id="week">
								</td>
								<td>
									早餐：<!-- select * from moa_week where  begindate  between  '2011-1-1' and  '2019-4-1' -->
								</td>
								<td>
									<select name="breakfast">
										<option></option>
									</select>
								</td>
								
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td>
									午餐：
								</td>
								<td>
									<select name="lunch">
										<option></option>
									</select>
								<input type="hidden" name="" hh="ss" value="2"/>
								</td>
							</tr>
							
						</table>
					</form>
					<div style="text-align: center; padding: 5px">
						<a href="javascript:void(0)" class="easyui-linkbutton"
							onclick="return submitForm()">Submit</a> <a href="javascript:void(0)"
							class="easyui-linkbutton" onclick="clearForm()">Clear</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
