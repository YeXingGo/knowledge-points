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
<script type="text/javascript">
			function submitForm(){
				$('#ff').form('submit',{
					onSubmit:function(){
						return $(this).form('enableValidation').form('validate');
					}
				});
			}
			function clearForm(){
				$('#ff').form('clear');
			}

		$(function(){
			//关闭
			$("#dd").dialog('close');
		})
		function addRole() {
			//开启弹框
			$("#dd").dialog();
			return false
		}


</script>





</head>

<body data-options="fit:'true'" style="width: 700px; height: 600px">

	<div class="easyui-layout" style="width: 1000px; height: 350px;">

		<!-- 注册页面 -->
		<div id="dd" class="easyui-dialog" title="My Dialog"
			style="width: 600px; height: 600px;"
			data-options="iconCls:'icon-save',resizable:true,modal:true,closable: true">

			<div class="easyui-panel" title="New Topic" style="width: 400px">
				<div style="padding: 10px 60px 20px 60px">
					<form id="ff" class="easyui-form" method="post"
						data-options="novalidate:true">
						<table cellpadding="5">
							<tr>
								<td>Name:</td>
								<td><input class="easyui-textbox" type="text" name="name"
									data-options="required:true"></input></td>
							</tr>
							<tr>
								<td>Name:</td>
								<td><input class="easyui-textbox" type="text" name="name"
									data-options="required:true"></input></td>
							</tr>
							<tr>
								<td>Email:</td>
								<td><input class="easyui-textbox" type="text" name="email"
									data-options="required:true,validType:'email'"></input></td>
							</tr>
							<tr>
								<td>Subject:</td>
								<td><input class="easyui-textbox" type="text"
									name="subject" data-options="required:true"></input></td>
							</tr>
							
						</table>
					</form>
					<div style="text-align: center; padding: 5px">
						<a href="javascript:void(0)" class="easyui-linkbutton"
							onclick="submitForm()">Submit</a> <a href="javascript:void(0)"
							class="easyui-linkbutton" onclick="clearForm()">Clear</a>
					</div>
				</div>
			</div>




		</div>



		<div data-options="region:'north'" style="height: 50px">

			<div style="padding: 5px 0;">
				<a href="#" class="easyui-linkbutton"
					data-options="iconCls:'icon-add'" onclick="return addRole()">添加人员</a>

			</div>

		</div>
		<%-- <div data-options="region:'east',split:true" title="East" style="width:300px;">
		
			<iframe src="<%=path %>/jsp/reight.jsp"></iframe>
		
		
		</div> --%>
		<div
			data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">

			<table id="dg" title="Client Side Pagination"
				style="width: 1200px; height: 400px"
				data-options="
						rownumbers:true,
						singleSelect:true,
						autoRowHeight:false,
						pagination:true,
						pageSize:10,
						">
			</table>
		</div>
	</div>



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
			    url:'<%=path%>/role/getSysRoleAll',
						columns : [ [
								{
									field : 'id',
									title : '编号',
									width : 100
								},
								{
									field : 'officeId',
									title : '机构编号',
									width : 100
								},
								{
									field : 'name',
									title : '角色名',
									width : 100
								},
								{
									field : 'enname',
									title : '英文名称',
									width : 100
								},
								{
									field : 'roleType',
									title : '角色类型',
									width : 100
								},
								{
									field : 'dataScope',
									title : '数据范围',
									width : 100
								},
								{
									field : 'isSys',
									title : '是否是系统数据',
									width : 100
								},
								{
									field : 'useable',
									title : '是否可用',
									width : 100
								},
								{
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
								},
								{
									field : 'xx',
									title : '操作',
									width : 100,
									formatter : function(value, row, index) {
										return "<a href='Index/delete/" + index
												+ "' onclick='return shanchu("
												+ row.id + ")'>删除</a>";

									}
								} ] ]
					});
		});

		function shanchu(id) {
			/* alert(id) */
			$.ajax({
				url : "Index/delete/" + id,
				success : function(data) {
					/* alert(data) */
					if (data == 1) {
						$('#dg').datagrid("reload", {});
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
