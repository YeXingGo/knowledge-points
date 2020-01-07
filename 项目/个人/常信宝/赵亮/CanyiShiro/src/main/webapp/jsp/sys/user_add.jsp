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
<!-- 添加用户页面 -->
<script type="text/javascript">
	$(function(){
		$("select[name='officeId']").parent().parent().hide();
		$("select[name='roleId']").parent().parent().hide();
		//获取所有的公司
		$.ajax({
			url:"<%=path%>/office/getAllGongSi",
			success:function(data){
				
				var hm=$.parseJSON(data);
				//清空公司的内容
				$("select[name='companyId']").empty();
				$("select[name='companyId']").append("<option selected='selected' value='0' >请选择</option>");
				//把后台传的值，放入到表单中区
				$(hm.list).each(function () {
				//把所有公司添加到  属性是公司的下拉框中
					$("select[name='companyId']").append(
						"<option value="+this.id+" >"+this.name+"</option>"
					)
				})
			}
		});
		//获取你选定公司下的部门
		$("select[name='companyId']").change(function(){
			var ids=$(this).val();
			if(ids==0){
				$("select[name='roleId']").parent().parent().hide();
				
				$("select[name='officeId']").parent().parent().hide();
			}else{
				$("select[name='officeId']").parent().parent().show();
				$.ajax({
					url:"<%=path%>/office/getOfficeBumen",
					data:{
						id:ids
					},
					success:function(data){
						var list=$.parseJSON(data);
						//清空公司的内容
						$("select[name='officeId']").empty();
						$("select[name='officeId']").append("<option selected='selected' value='0'>请选择</option>");
						//把后台传的值，放入到表单中区
						$(list).each(function () {
						//把所有公司添加到  属性是公司的下拉框中
							$("select[name='officeId']").append(
								"<option value="+this.id+" >"+this.name+"</option>"
							)
						})
					}
				});
			}
			
		})
		//获取该部门下的所有角色
		$("select[name='officeId']").change(function(){
			var ids=$(this).val();
			if(ids==0){
				
				$("select[name='roleId']").parent().parent().hide();
			}else{
				$("select[name='roleId']").parent().parent().show();
				$.ajax({
					url:"<%=path%>/office/getOfficeRole",
					data:{
						id:ids
					},
					success:function(data){
						var hm=$.parseJSON(data);
						//清空角色类型中的内容
						$("select[name='roleId']").empty();
						$("select[name='roleId']").append("<option selected='selected' value='0'>请选择</option>");
						//把后台传的值，放入到表单中区
						$(hm.list).each(function () {
						//把所有公司添加到  属性是公司的下拉框中
							$("select[name='roleId']").append(
								"<option value="+this.id+" >"+this.roleType+"</option>"
							)
						})
					}
				});
			}
		})
		//表单验证
	/*  	$("#name").blur(function(){
	 		if($(this).val()==""){
				$("input[name='name']").next().html("<font color='red'>*姓名不能为空</font>");
				name="2";
	 		}else{
	 			name="1";
				$(this).next().empty();
	 		}
		});  
		$("input[name='loginName']").blur(function(){
	 		if($(this).val()==""){
	 			$("input[name='loginName']").next().html("<font color='red'>*用户名不能为空</font>");
	 		}else{
				$(this).next().empty();
	 		}
		});  */ 
		
		
		
		
	})
	//验证表单
	function FromYanZheng(){
		 var s=$("input[name='name']").val();
		if (s.length == 0) { 
			$("input[name='name']").next().html("<font color='red'>*姓名不能为空</font>");
				return false; 
		}else{
			$("input[name='name']").next().empty();
		} 
		
		var loginName=$("input[name='loginName']").val();
		if (loginName == "") { 
			$("input[name='loginName']").next().html("<font color='red'>*用户名不能为空</font>");
				return false; 
		}else{
			$("input[name='loginName']").next().empty();
		}  
		
		var password=$("input[name='password']").val();
		if (password == "") { 
			$("input[name='password']").next().html("<font color='red'>*密码不能为空</font>");
				return false; 
		}else{
			$("input[name='password']").next().empty();
		} 
		
		/* var companyId=$("input[name='companyId']").val();
		if (companyId == "") { 
			$("input[name='companyId']").next().html("<font color='red'>*归属公司</font>");
				return false; 
		}else{
			$("input[name='companyId']").next().empty();
		} 
		var officeId=$("input[name='officeId']").val();
		if (officeId == "") { 
			$("input[name='officeId']").next().html("<font color='red'>*归属部门</font>");
				return false; 
		}else{
			$("input[name='officeId']").next().empty();
		} 
		
		
		var roleId=$("input[name='roleId']").val(); */
		var phone=$("input[name='phone']").val();
		var reg = /^[0-9]+$/; 
		if(phone!=""&&!reg.test(phone)){ 
			$("input[name='phone']").next().html("<font color='red'>*手机号为数字</font>");
			return false; 
		} else{
			$("input[name='phone']").next().empty();
			
		}
		
		
		var loginFlag=$("input[name='loginFlag']").val();
		
		var remarks=$("input[name='remarks']").val();
		if (remarks == "") { 
			$("input[name='remarks']").next().html("<font color='red'>*备注信息不能为空</font>");
				return false; 
		}else{
			$("input[name='remarks']").next().empty();
		} 
		var email=$("input[name='email']").val();
		var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(!myreg.test(email)){
			$("input[name='email']").next().html("<font color='red'>*邮箱格式不对</font>");
			return false;
		}else{
			$("input[name='email']").next().empty()
			
		}
		
			return true;
	}
	
	//提交表单
	function submitForm(){
		if(FromYanZheng()){
			$('#ff').form('submit',{
				url:"<%=path%>/user/Zhuce",
				success:function(data){
					if(data==1){
						
						$('#ff').form('clear');
						alert("添加成功")
					}else{
						alert("添加失败")
					}
				}
			});
		}
		return false;
	}
	//清空表单数据
	function clearForm(){
		$('#ff').form('clear');
	}

	
	
	
	
	

</script>
</head>

<body data-options="fit:'true'" style="width: 600px; height: 600px">

	<!-- 布局 -->
	<div class="easyui-layout" style="width: 600px; height: 550px;">
		<div
			data-options="region:'center',title:'注册用户',iconCls:'icon-ok'">
			<!-- 注册 -->
			<div class="easyui-panel" title="" style="width: 600px" >
				<div style="padding: 10px 60px 20px 60px">
					<form id="ff" class="easyui-form" method="post"
						data-options="novalidate:true">
						<table cellpadding="5">
							<tr>
								<td>姓名:</td>
								<td><input id="name" class="" type="text" name="name"
									></input> <span></span></td>
							</tr>
							<tr>
								<td>用户名:</td>
								<td><input class="" type="text" name="loginName"
									></input><span></span></td>
							</tr>
							<tr>
								<td>密码:</td>
								<td><input class="" type="text"
									name="password" ></input><span></span></td>
							</tr>
							<tr>
								<td>归属公司:</td>
								<td>
									
									<select name="companyId" class="selectsjsj">
											<option selected="selected" value="${loginUser.companyId}">111</option>
									</select><span></span>
									
								</td>
								<td></td>
							</tr>
							<tr>
								<td>归属部门:</td>
								<td>
									
									<select name="officeId">
											<option selected="selected">请选择</option>
									</select><span></span>
									
								</td>
								<td></td>
							</tr>
							<tr>
								<td>角色类型:</td>
								<td>
									
									<select name="roleId">
											<option selected="selected" >请选择</option>
											
									</select><span></span>
									
								</td>
								<td></td>
							</tr>
					
							<tr>
								<td>电话:</td>
								<td><input class="" type="text" name="phone"
									></input><span></span></td>
							</tr>
							
							<tr>
								<td>头像:</td>
								<td><input  type="file" name="photo"
									></input><span></span></td>
							</tr>
							<tr>
								<td>是否可以登录:</td>
								<td>
									<input type="radio" name="loginFlag" value="1"/>是
									<input type="radio" name="loginFlag" value="0"/>否
									<span></span></td>
							</tr>
						<!-- 	<tr>
								<td>添加时间:</td>
								<td>
									<input class="easyui-datebox" 
									 name="createDate"></input>
									</td>
							</tr> -->
							<tr>
								<td>备注信息:</td>
								<td>
									<input class="" type="text" name="remarks"
									></input><span></span>
									</td>
							</tr>
							<tr>
								<td>邮箱:</td>
								<td><input class="" type="text" name="email"
									></input><span></span></td>
							</tr>
						<!-- 	<tr>
								<td>类型:</td>
								<td>
									<select name="userType">
										<option value="1" selected="selected">员工</option>
									</select>
								</td>
							</tr> -->
						</table>
					</form>
					<div style="text-align: center; padding: 5px">
						<a href="javascript:void(0)" class="easyui-linkbutton"
							onclick="return submitForm()">Submit</a> <a href="javascript:void(0)"
							class="easyui-linkbutton" onclick="clearForm()">Clear</a>
					</div>
				</div>
			</div>
			<!-- 注册结束 -->
		</div>
	</div>
	<!-- 布局结束 -->
	<!-- 注册 -->










</body>
</html>
