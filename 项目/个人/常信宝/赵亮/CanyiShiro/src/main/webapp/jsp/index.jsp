<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
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




<c:if test="${!empty sessionScope.loginUser}">
	<script type="text/javascript">
	 	$(function(){
			$("#dd").dialog('close');
		})
	 
	
	</script>
	<!-- 自动刷新页面 -->


</c:if>


<script type="text/javascript">
function zhuXiao(){
	
	$.ajax({
		url:"user/Index",
		data:{
			name:"zhangsnm"
		},
		success:function(data){
		//	alert(data)
			reurl();
			//$("#dd").dialog('open');
		}
		
	})
	return false;
}

function submitForm(){
	$('#ff').form('submit', {
		url: "<%=path%>/user/LoginUser",
		onSubmit: function(){
			var login=$("input[name='loginName']").val();
			var pass=$("input[name='password']").val();
			if(login==""||pass==""){
				alert("用户名和密码不能为空")
				return false;
			}
			//判断所有字段是否为正确格式
 var isValid = $(this).form('validate');
			if (!isValid){
				$.messager.progress('close');	// hide progress bar while the form is invalid
			}
			return isValid; 	// return false will stop the form submission
		},
		success: function(data){
			$.messager.progress('close');	// 成功提交时隐藏进度条
			if(data==1){
			$("#dd").dialog('close');
			reurl();
			}else if(data==0){
				alert("账号或密码错误");
			
				$('#ff').form('clear');
			}else if(data==3){
				alert("身份信息过期");
			
				$('#ff').form('clear');
				
			}
			
		}
	});
}
//重新加载页面
function reurl(){
/* 	$.ajax({
		url:"user/Index",
		data:{
			name:"zhangsnm"
		},
		success:function(data){
			alert(data)
		}
		
	}) */
	//alert(1)
    url = location.href; //把当前页面的地址赋给变量 url
    var times = url.split("?"); //分切变量 url 分隔符号为 "?"
    if(times[1] != 1){ //如果?后的值不等于1表示没有刷新
       // url += "?1"; //把变量 url 的值加入 ?1
        self.location.replace(url); //刷新页面
    }
    
    return false;
}
onload=reurl;
function clearForm(){
	//清除表单数据
	$('#ff').form('clear');
}
   function  win() {
	   $("#w").window('close');
	}
   function tab(uri,titles){
	   //alert(titles)
	   var flag=$("#tt").tabs("exists",titles);
		if(flag){
			$("#tt").tabs("select",titles);
			//让引入的jsp页面再次刷新
			var current_tab= $('#tt').tabs('getSelected');
			$('#tt').tabs('update',{
				tab: current_tab,
			    options: {
                    content: "<iframe src='"+uri+"' id='myiframe' style='border:0px;width=100%;scrolling=no' data-options='fit:true'></iframe>"
                }
			});
		}else{
			// 添加一个新的标签页面板（tab panel）
			$('#tt').tabs('add',{
			    title:titles,
			    content:jsp(uri),
			    closable:true,
			    width:700,
			    height:600
			});
		}
   }
   function jsp(uri){
	   return "<iframe src='"+uri+"' id='myiframe' style='border:0px;width=100%;scrolling=no' data-options='fit:true'></iframe>";
   }
   $(function(){
	   //测试a 标签的跳转
	   $(".btn").click(function(){
		   var uri =$(this).attr("href");
		   //var title=$(this).html();
		   //拿到链接按钮中的文本
		    var tt=$(this).linkbutton("options").text;
		 /*  
		   if(tt=="点餐管理"){
			   var date=new Date();
			  // alert(date.getHours())
			   if(date.getHours()>=10){
				   alert("已过时间，不能点餐设置");
					   return false ;
				   
			   }
		   } */
			 tab(uri,tt);
		   
		   return false;
	   })
	 //
		/*  $('#tt').tabs({
		    border:false,
		    onSelect:function(title,index){
		    		alert(title)
		    	if(title=="点餐查看"){
		    		alert(1)
		    		$('#tt').tabs('update',{
					    title:title,
					    content:jsp(uri),
					    closable:true,
					    width:700,
					    height:600
					});
		    	}
			}
		}); */ 
	 /*  $('#tt').tabs({
		  onClose: function(title){
			  window.parent.$('#tt').tabs('close', '点餐管理');
			return confirm('Are you sure you want to close ' + title);
		  }
		}); */
   })
	/* function ssss() {
		alert(1)
		var tab = $('#tt').tabs('getSelected');
		alert(tab.title)
		return false;
	} */

</script>
<style type="text/css">
a {
	text-decoration: none
}

#myiframe {
	width: 100%;
	height: 100%;
}

#ul, ul {
	list-style: none;
}

li {
	margin-top: 10px;
}
</style>
</head>

<body onload="win()">
	<div class="easyui-layout" style="width: 700px; height: 350px;"
		data-options="fit:true">


		<!-- 登录 -->
		<div id="dd" class="easyui-dialog" title="登录"
			style="width: 400px; height: 300px;"
			data-options="iconCls:'icon-save',resizable:false,modal:true,closable: false">
			<!-- losable 作为关闭小叉号 为false ? -->
			<div class="easyui-panel" title=""
				style="width: 400px; height: 300px; margin-top: 80px">
				<div style="padding: 10px 60px 20px 60px">
					<form id="ff" class="easyui-form" method="post"
						data-options="novalidate:true" action="#">
						<table cellpadding="5">
							<tr>
								<td>用户名:</td>
								<td><input class="easyui-textbox" type="text"
									name="loginName" data-options="required:true"></input></td>
							</tr>
							<tr>
								<td>密码:</td>
								<td><input class="easyui-textbox" type="text"
									name="password" data-options="required:true,validType:'email'"></input></td>
							</tr>

						</table>
					</form>
					<div style="text-align: center; padding: 5px">
						<a href="javascript:void(0)" class="easyui-linkbutton"
							onclick="return submitForm()">登录</a> <a href="javascript:void(0)"
							class="easyui-linkbutton" onclick="clearForm()">清空</a>
					</div>
				</div>
			</div>



		</div>




		<div data-options="region:'north'" style="height: 50px">
			<a href="#" class="easyui-linkbutton"
				data-options="iconCls:'icon-reload'" style="width: 80px"
				onclick="return reurl()">重新加载</a> <a href="#"
				class="easyui-linkbutton" data-options="iconCls:'icon-blank'"
				style="width: 80px" onclick="return zhuXiao()">注销</a>

			<c:if test="${!empty loginUser}">
			欢迎回来
			</c:if>
			${loginUser.loginName}
			<%-- ${loginUserRole.role.ename} --%>

		</div>
		<div data-options="region:'south',split:true" style="height: 50px;"></div>
		<!-- <div data-options="region:'east',split:true" title="East"
			style="width: 100px;"></div> -->
		<div data-options="region:'west',split:true" title=""
			style="width: 300px;" data-options="fit:true">


			<div class="easyui-accordion" style="width: 500px; height: 300px;"
				data-options="fit:true">
				<%-- <div title="机构用户" data-options="iconCls:'icon-ok'"
					style="padding: 10px;">

					<a href="<%=path%>/jsp/sys/office.jsp" class="btn">机构</a>
				</div> --%>
				<%-- <div title="系统管理" data-options="iconCls:'icon-ok'"
					style="padding: 10px;">
					<ul id="ul">
						<li>
								<a href="<%=path%>/jsp/sys/sys_role.jsp"
									class="easyui-linkbutton btn"
									data-options="iconCls:'icon-blank'" style="width: 80px">擦擦擦</a>
							
							</li>

						<li><a href="<%=path%>/jsp/sys/sys_role.jsp"
							class="easyui-linkbutton btn" data-options="iconCls:'icon-man'"
							style="width: 120px;">人员管理</a> <br></li>
						<li><a href="<%=path%>/jsp/sys/office.jsp" class="btn"
							style="width: 120px;">管理员管理</a> <br></li>
						<li><a href="<%=path%>/jsp/sys/office.jsp" class="btn"
							style="width: 120px;">日志审核</a> <br></li>


					</ul>
				</div> --%>
				<!-- <div title="日志查询" data-options="iconCls:'icon-ok'"
					style="padding: 10px;"></div> -->
				<div title="业务功能" data-options="iconCls:'icon-help'"
					style="padding: 10px;">
					<ul id="ul">

						<li><a href="<%=path%>/jsp/sys/moaWeek.jsp"
							class="easyui-linkbutton btn" data-options="iconCls:'icon-man'"
							style="width: 120px;">周表查看</a> <br></li>
						<li>
							<a href="<%=path%>/jsp/sys/moaOrderset.jsp"
							class="easyui-linkbutton btn" data-options="iconCls:'icon-man'"
							style="width: 120px;">点餐管理</a> <br>
						
						</li>
						<li>
							<a href="<%=path%>/jsp/sys/moaOrdersetList.jsp"
							class="easyui-linkbutton btn" data-options="iconCls:'icon-man'"
							style="width: 120px;">点餐查看</a> <br>
						
						</li>
						
						
						<li>
							<a href="<%=path%>/jsp/sys/menu.jsp"
							class="easyui-linkbutton btn" data-options="iconCls:'icon-man'"
							style="width: 120px;">菜谱添加</a> <br>
						</li>

					</ul>


				</div>
				<div title="用户管理" data-options="iconCls:'icon-man'"
					style="padding: 10px;">
					<ul>
						<li><a href="<%=path%>/jsp/sys/user.jsp"
							class="easyui-linkbutton btn" data-options="iconCls:'icon-man'"
							style="width: 120px;">用户管理</a> <br></li>
						<li><a href="<%=path%>/jsp/sys/user_add.jsp"
							class="easyui-linkbutton btn" data-options="iconCls:'icon-add'"
							style="width: 120px;">添加用户</a> <br></li>

					</ul>

				</div>
				<%-- <div title="每周菜谱管理" data-options="iconCls:'icon-man'"
					style="padding: 10px;">

					<ul>
						<li><a href="<%=path%>/jsp/sys/user.jsp"
							class="easyui-linkbutton btn" data-options="iconCls:'icon-man'"
							style="width: 120px;">菜单</a> <br></li>
						<li><a href="<%=path%>/jsp/sys/user_add.jsp"
							class="easyui-linkbutton btn" data-options="iconCls:'icon-add'"
							style="width: 120px;">添加用户</a> <br></li>

					</ul>


				</div>
				<div title="点餐管理" data-options="iconCls:'icon-man'"
					style="padding: 10px;"></div>
				<div title="系统管理" data-options="iconCls:'icon-man'"
					style="padding: 10px;"></div> --%>
			</div>



		</div>
		<div
			data-options="region:'center',title:'sda',iconCls:'icon-ok',fit:'true'">


			<div id="tt" class="easyui-tabs" data-options="fit:true">
			</div>





			<!--  -->

		</div>
	</div>
</body>
</html>
