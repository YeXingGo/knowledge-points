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
 		
 		
 		
 		var list;
 		//初始化三个数据
 		$.ajax({
 			url:"<%=path%>/menu/getCaiPin",
 			success:function(data){
 				 list=$.parseJSON(data);
 				 list1=list;
 				 list2=list;
 				//alert(list)
 				$("select[name='moaOrderset2.dish']").empty();
 				$("select[name='moaOrderset1.dish']").empty();
 				$("select[name='moaOrderset.dish']").empty();
 				$(list).each(function(i,n){
 					
 					$("select[name='moaOrderset2.dish']").append(
 						"<option value='"+this.name+"'>"+this.name+"</option>"		
 					)
 					$("select[name='moaOrderset1.dish']").append(
 						"<option value='"+this.name+"'>"+this.name+"</option>"		
 					)
 	 				$("select[name='moaOrderset.dish']").append(
 						"<option value='"+this.name+"'>"+this.name+"</option>"		
 					)
 				})
 			}
 		})
		//用于三个 菜名不能重复
		$("select[name='moaOrderset.dish']").change(function(){
			var a=$(this).val();
			$("select[name='moaOrderset1.dish'] option").each(function(){
				if($(this).attr("value")==a){
					$(this).remove();
				}
			})	
			$("select[name='moaOrderset2.dish'] option").each(function(){
				if($(this).attr("value")==a){
					$(this).remove();
				}
			})
			
		})
		$("select[name='moaOrderset1.dish']").change(function(){
			var a=$(this).val();
			$("select[name='moaOrderset.dish'] option").each(function(){
				if($(this).attr("value")==a){
					$(this).remove();
				}
			})	
			$("select[name='moaOrderset2.dish'] option").each(function(){
				if($(this).attr("value")==a){
					$(this).remove();
				}
			})
			
		})
		$("select[name='moaOrderset2.dish']").change(function(){
			var a=$(this).val();
			$("select[name='moaOrderset.dish'] option").each(function(){
				if($(this).attr("value")==a){
					$(this).remove();
				}
			})	
			$("select[name='moaOrderset1.dish'] option").each(function(){
				if($(this).attr("value")==a){
					$(this).remove();
				}
			})
			
		})
		
		//用于日期绑定
		$("#dd").datebox({
			onSelect: function(date){
			
				var date=new Date(date).getDay();
				var ws="";
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
		var week=$("input[name='week']").val();
		//alert(cweek)
		$('#ff').form('submit',{
			url:"<%=path%>/moaOrderset/insertMoaOrder",
		/* 	 onSubmit: function(param){
					param.cdate = d;
					param.cweek = cweek;
			    }, */
			success:function(date){
				if(date==1){
					$('#ff').form('clear');
					alert("添加成功")
				}else{
					alert("要先去添加菜单奥")
					
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
			<div class="easyui-panel" title="" style="width: 800px" data-options="fit:true">
				<div style="padding: 10px 60px 20px 60px">
					<form id="ff" method="post">
						<table cellpadding="5">
							<tr>
								<td>选择日期:</td>
								<td>
									<input id="dd" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" name="cdate"></input>
								</td>
								<td>
									<input class="easyui-textbox" style="width:75px;height:30px" name="week" id="week">
								</td>
							</tr>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td>菜名：</td>
								<td>
									<select name="moaOrderset.dish" dd="dd">
										<option selected="selected">sss</option>
									</select>
								</td>
								<td>设置上限：</td>
								<td>
									  <input class="easyui-textbox" type="text" name="moaOrderset.maxcount" ></input>
								</td>
							</tr>
							<tr>
								<td>菜名：</td>
								<td>
									<select name="moaOrderset1.dish" dd="dd">
										<option selected="selected">sss</option>
									</select>
								</td>
								<td>设置上限：</td>
								<td>
									  <input class="easyui-textbox" type="text" name="moaOrderset1.maxcount" ></input>
								</td>
							</tr>
							<tr>
								<td>菜名：</td>
								<td>
									<select name="moaOrderset2.dish" dd="dd">
										<option selected="selected">sss</option>
									</select>
								</td>
								<td>设置上限：</td>
								<td>
									  <input class="easyui-textbox" type="text" name="moaOrderset2.maxcount" ></input>
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
