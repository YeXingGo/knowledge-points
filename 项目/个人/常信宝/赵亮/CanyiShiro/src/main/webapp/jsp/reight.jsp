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
</head>

<body data-options="fit:'true'" style="width:700px;height:600px">
	<table id="dg" title="Client Side Pagination" style="width:900px;height:400px" data-options="
				rownumbers:true,
				singleSelect:true,
				autoRowHeight:false,
				pagination:true,
				pageSize:10,
				">
		<thead>
			<!-- <tr>
				<th field="id" width="80">id</th>
				<th field="name" width="100">姓名</th>
				<th field="age" width="80">年龄</th>
				<th field="" width="80">年龄</th>
			</tr> -->
		</thead>
	</table>
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
			      		{field:'loginName',title:'用户登录名称',width:100},
			      		{field:'name',title:'姓名',width:100},
			      		{field:'password',title:'密码',width:100,align:'right'},
			      		{field:'password',title:'密码',width:100,align:'right'},
			      		{field:'password',title:'密码',width:100,align:'right'},
			      		{field:'password',title:'密码',width:100,align:'right'},
			      		{field:'password',title:'密码',width:100,align:'right'},
			      		{field:'xx',title:'操作',width:100,formatter: function(value,row,index){
								return "<a href='Index/delete/"+index+"' onclick='return shanchu("+row.id+")'>删除</a>";
								
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
