<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
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
<script type="text/javascript">
		
		$("#dg").datagrid({
			onClickRow: function(rowIndex, rowData){
				$(this).datagrid('beginEdit', index);
				alerrt(0)
			}
		});






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

<script type="text/javascript">
			function submitForm(){
				var datasss=$("select[name='userType']");
				$('#ff').form('submit',{
					url:"<%=path%>/user/Zhuce",
					/* onSubmit:function(){
						return $(this).form('enableValidation').form('validate');
					}, */
					/*  onSubmit: function(param){
						 param.userType= datasss;
					    }, */
					success:function(data){
						alert("index");
						alert(data);
					}
				});
			}
			function clearForm(){
				$('#ff').form('clear');
			}

		$(function(){
			//关闭
			 $("#dd").dialog('close');
			//用于管理登录部门的添加
			$("select[name='companyId']").change(function(){
				//alert(1)
				var ids=$(this).val();
				//alert(ids)
				$.ajax({
					url:"<%=path%>/office/getOfficeBumen",
					data:"id="+ids,
					success:function(data){
						//alert(data)
						$("select[name='officeId']").empty();
						var list=	$.parseJSON(data);
						$(list).each(function(){
							//alert(this.id);
							$("select[name='officeId']").append(
									
							"<option value="+this.id+">"+this.name+"</option>"
							)
						})
					}
				})
			})
		/* 	$.ajax(function(){
				url:""
			}) */
	/* 		$('#dg').datagrid({
				pageList: [1,2,3,4,5]
			}); */
		})
		function addRole() {
			//开启弹框
			$("#dd").dialog({
				left: 150,
				top:10
				
				
			});
			
			$.ajax({
				url:"<%=path%>/office/getOfficeAll",
				data:"id="+1,
				success:function(data){
					var hm=$.parseJSON(data);
					var type=hm.type ;
					if(type==1){
						//alert(1)
						$(hm.list).each(function(i,n){
							$("select[name='companyId']").append(
									
								"<option value="+this.id+">"+this.name+"</option>"
							)
						
						})
						$("select[name='userType']").empty();
						$("select[name='userType']").append(
							"<option value="+1+">总裁</option>"+
							"<option value="+3+">部长</option>"+
							"<option value="+8+">员工</option>"
						)
					}else if(type==2){
						//alert(2)
						$("select[name='officeId']").empty();
						$("select[name='companyId']").parent().parent().hide();
						$(hm.list).each(function(i,n){
							$("select[name='officeId']").append(
									
								"<option value="+this.id+">"+this.name+"</option>"
							
							)
						})
							$("select[name='userType']").empty();
						$("select[name='userType']").append(
							"<option value="+3+">部长</option>"+
							"<option value="+8+">员工</option>"
						)
						
					}else {
						alert(3)
						$("select[name='companyId']").parent().parent().hide();
						$("select[name='officeId']").parent().parent().hide();
						$("select[name='userType']").empty();
						$("select[name='userType']").append(
							"<option value="+8+">员工</option>"
						)
					}
				}
				
			});
			return false;
		}


</script>
</head>

<body data-options="fit:'true'" style="width:700px;height:800px">

		<div class="easyui-layout" style="width: 1200px; height: 600px;">

		<%-- <!-- 注册页面 -->
		<div id="dd" class="easyui-dialog" title="注册用户"
			style="width: 600px; height: 600px;"
			data-options="iconCls:'icon-save',resizable:true,modal:true,closable: true">

			<div class="easyui-panel" title="" style="width: 600px">
				<div style="padding: 10px 60px 20px 60px">
					<form id="ff" class="easyui-form" method="get"
						data-options="novalidate:true">
						<table cellpadding="5">
							<tr>
								<td>姓名:</td>
								<td><input class="easyui-textbox" type="text" name="name"
									data-options="required:true"></input></td>
							</tr>
							<tr>
								<td>用户名:</td>
								<td><input class="easyui-textbox" type="text" name="loginName"
									data-options="required:true"></input></td>
							</tr>
							<tr>
								<td>密码:</td>
								<td><input class="easyui-textbox" type="text"
									name="password" data-options="required:true"></input></td>
							</tr>
							<tr>
								<td>归属公司:</td>
								<td>
									
									<select name="companyId" class="selectsjsj">
											<option selected="selected" value="${loginUser.companyId}"></option>
									</select>
									
								</td>
							</tr>
							<tr>
								<td>归属部门:</td>
								<td>
									
									<select name="officeId">
											<option selected="selected" value="${loginUser.officeId}"></option>
											
									</select>
									
								</td>
							</tr>
						<!-- 	<tr>
								<td>工号:</td>
								<td><input class="easyui-textbox" type="text" name="no"
									data-options="required:true"></input></td>
							</tr> -->
							<tr>
								<td>电话:</td>
								<td><input class="easyui-textbox" type="text" name="phone"
									data-options="required:true"></input></td>
							</tr>
							<!-- <tr>
								<td>用户类型:</td>
								<td>
									
									<input type="radio" name="userType" value="1"/>管理员
									<input type="radio" name="userType" value="0"/>员工
									</td>
							</tr> -->
							<tr>
								<td>头像:</td>
								<td><input  type="file" name="photo"
									data-options="required:true"></input></td>
							</tr>
							<tr>
								<td>是否可以登录:</td>
								<td>
									<input type="radio" name="loginFlag" value="1"/>是
									<input type="radio" name="loginFlag" value="0"/>否
									</td>
							</tr>
							<tr>
								<td>添加时间:</td>
								<td>
									<input class="easyui-datebox" data-options="formatter:myformatter,parser:myparser"
									 name="createDate"></input>
									</td>
							</tr>
							<tr>
								<td>备注信息:</td>
								<td>
									<input class="easyui-textbox" type="text" name="remarks"
									data-options="required:true"></input>
									</td>
							</tr>
							<tr>
								<td>邮箱:</td>
								<td><input class="easyui-textbox" type="text" name="email"
									data-options="required:true,validType:'email'"></input></td>
							</tr>
							<tr>
								<td>类型:</td>
								<td>
									<select name="userType">
										<option value="1" selected="selected">员工</option>
									</select>
								</td>
							</tr>
							
							
						</table>
					</form>
					<div style="text-align: center; padding: 5px">
						<a href="javascript:void(0)" class="easyui-linkbutton"
							onclick="submitForm()">注册</a> <a href="javascript:void(0)"
							class="easyui-linkbutton" onclick="clearForm()">清空</a>
					</div>
				</div>
			</div>
		</div>

 --%>

		<div data-options="region:'north'" style="height: 50px">

			<%-- <div style="padding: 5px 0;">
				<shiro:hasPermission name="user:update">
			
				<a href="#">ssss</a>
			</shiro:hasPermission>
				<a href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-add'" onclick="return addRole()">添加人员</a>
				<a href="<%=path %>/office/Zhuce" class="easyui-linkbutton"
					data-options="iconCls:'icon-add'" >添加人员</a>

			</div> --%>

		</div>
		<%-- <div data-options="region:'east',split:true" title="East" style="width:300px;">
		
			<iframe src="<%=path %>/jsp/reight.jsp"></iframe>
		
		
		</div> --%>
		<div
			data-options="region:'center',title:'用户信息',iconCls:'icon-ok'" style="width: 1500px; height: 800px" >

			<table id="dg" title=""
				style="width: 1500px; height: 800px"
				data-options="
						rownumbers:true,
						singleSelect:true,
						autoRowHeight:false,
						pagination:true,
						pageSize:10,
						">
			</table>
			<form>
				<input id="loginRole" type="hidden" name="1345" value="${loginUserRole.role.dataScope}"/>
			</form>
		</div>
		
		
		
		
	</div>






	<!-- <table id="dg" title="Client Side Pagination" style="width:900px;height:400px" data-options="
				rownumbers:true,
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10,
				">
	
	</table> -->
	<script>
		function getData(){
			var rows = [];
			for(var i=1; i<=800; i++){
				var amount = Math.floor(Math.random()*1000);
				var price = Math.floor(Math.random()*1000);
				rows.push({
					inv: 'Inv No '+i,
					date: $.fn.datebox.defaults.formatter(new Date()),
					name: 'Name '+i,
					amount: amount,
					price: price,
					cost: amount*price,
					note: 'Note '+i
				});
			}
			return rows;
		}
		
		function pagerFilter(data){
			if (typeof data.length == 'number' && typeof data.splice == 'function'){	// is array
				data = {
					total: data.length,
					rows: data
				}
			}
			var dg = $(this);
			var opts = dg.datagrid('options');
			var pager = dg.datagrid('getPager');
			pager.pagination({
				onSelectPage:function(pageNum, pageSize){
					opts.pageNumber = pageNum;
					opts.pageSize = pageSize;
					pager.pagination('refresh',{
						pageNumber:pageNum,
						pageSize:pageSize
					});
					dg.datagrid('loadData',data);
				}
			});
			if (!data.originalRows){
				data.originalRows = (data.rows);
			}
			var start = (opts.pageNumber-1)*parseInt(opts.pageSize);
			var end = start + parseInt(opts.pageSize);
			data.rows = (data.originalRows.slice(start, end));
			return data;
		}
		
		$(function(){
			$('#dg').datagrid({loadFilter:pagerFilter}).datagrid('loadData', getData());
			$('#dg').datagrid({
			    url:'<%=path%>/user/getSysUserAll',
			    columns:[[
			      	/* 	{field:'id',title:'用户id',width:100}, */
			      		{field:'comptyName',title:'归属公司',width:100},
			      		{field:'officeName',title:'归属部门',width:100},
			      		{field:'loginName',title:'用户登录名称',width:100,formatter: function(value,row,index){
			      			return row.user.loginName;
			      		}},
			      		/* {field:'password',title:'密码',width:100,formatter: function(value,row,index){
			      			return row.user.password;
			      		}}, */
			      		{field:'no',title:'工号',width:100,formatter: function(value,row,index){
			      			return row.user.no;
			      		}},
			      		{field:'name',title:'姓名',width:100,formatter: function(value,row,index){
			      			return row.user.name;
			      		}},
			      		{field:'email',title:'邮箱',width:100,formatter: function(value,row,index){
			      			return row.user.email;
			      		}},
			      		{field:'phone',title:'电话',width:100,formatter: function(value,row,index){
			      			
			      			return row.user.phone;
			      		}},
			      		/* {field:'mobile',title:'手机',width:100,formatter: function(value,row,index){
			      			return row.user.mobile;
			      		}}, */
			      		/* {field:'userType',title:'用户类型',width:100,formatter: function(value,row,index){
			      			return row.user.userType;
			      		}}, */
			      		/* {field:'photo',title:'头像',width:100,formatter: function(value,row,index){
			      			return row.user.photo;
			      		}},
			      		{field:'loginIp',title:'最后登录ip',width:100,formatter: function(value,row,index){
			      			return row.user.loginIp;
			      		}},
			      		{field:'loginDate',title:'最后登录时间',width:100,formatter: function(value,row,index){
			      			return row.user.loginDate;
			      		}}, */
			      		
			      		{field:'loginFlag',title:'是否可登陆',width:100,formatter: function(value,row,index){
			      			if(row.user.loginFlag==1){
			      				return "可以";
			      			}else if(row.user.loginFlag==2){
			      				return "不可以"
			      			}
			      		}},
			      		/* {
							field : 'createBy',
							title : '创建者',
							width : 100
						},
						{
							field : 'createDate',
							title : '创建时间',
							width : 100
						},
						{
							field : 'updateBy',
							title : '更新者',
							width : 100
						},
						{
							field : 'updateDate',
							title : '更新时间',
							width : 100
						},
						{
							field : 'remarks',
							title : '备注信息',
							width : 100
						},
						{
							field : 'delFlag',
							title : '删除标记',
							width : 100
						}, */
			      		{field:'xx',title:'操作',width:100,formatter: function(value,row,index){
			      			//alert(row.role)
			      			if(row.role==undefined){
			      				if(row.type==0||row.type==undefined){
									return "<a href='Index/delete/"+index+"' onclick='return shanchu("+row.id+")'>删除</a>";
				      			}
			      			}else{
			      				var b=$("#loginRole").val();
			      				var zh=row.role.dataScope;
			      				alert("zh:"+zh+" b:"+b)
			      				
			      				if(b<=zh){
			      					if(row.type==0||row.type==undefined){
										return "<a href='Index/delete/"+index+"' onclick='return shanchu("+row.id+")'>删除</a>";
					      			}
			      				}else{
			      					return "不能操作";
			      					
				      				
			      				}
			      			}
			      		
			      			
			      			
						}}
			          ]]
			});
		});
		
		  function shanchu(id){
			   /* alert(id) */
			   $.ajax({
				   url:"Index/delete/"+id,
				   success:function(data){
						   /* alert(data) */
					   if(data==1){
						   $('#dg').datagrid("reload",{});  
					   }
				   }
			   })
			   /*   
			   $(“#grid”).datagrid(“load”,{ });
				}); */
				return false;
		   }
	</script>
	
</body>
</html>
