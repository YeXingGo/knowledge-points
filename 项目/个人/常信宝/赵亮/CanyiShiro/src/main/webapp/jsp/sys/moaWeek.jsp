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
	//查询
	
	//向数据表格传值
	var youWant;
	var d;
	$('#dg').datagrid({
	    url:'<%=path%>/moaWeek/getAllMoaWeek',
	    columns:[[
			{field:'id',title:'周数',width:100},
			{field:'begindate',title:'开始日期',width:200,formatter: function(value,row,index){
				 d=new Date(row.begindate);
				 youWant=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' ;
				 return youWant;
			}},
			{field:'enddate',title:'结束日期',width:200,formatter: function(value,row,index){
				d=new Date(row.enddate);
				 youWant=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' ;
				return youWant;
			}},
			{field:'createdate',title:'发布日期',width:100,formatter: function(value,row,index){
				
				d=new Date(row.createdate);
				 youWant=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ';
				
				return youWant;;
			}},
			{field:'price',title:'管理操作',width:200,formatter: function(value,row,index){
				d=new Date(row.enddate);
				youWant=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ';
				//var youWant1=date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() + ' ';
				//alert(youWant+" "+youWant1)
				var date=new Date();
				//alert(date.getMonth()+":"+d.getMonth()+"-"+d.getDate());
				
				 if(date.getFullYear()<d.getFullYear()){
					 return "<a href='#'>删除</a><a href='#'>查看</a><a href='#'>添加</a>";
				 }
				if(date.getMonth()<d.getMonth()){
							return "<a href='#'>删除</a><a href='#'>查看</a><a href='#'>添加</a>";
				 }else if(date.getMonth()==d.getMonth()){
					
					 if(date.getDate()>d.getDate()){
						return "没有操作";
					 }else{
						return "<a href='#'>删除</a><a href='#'>查看</a><a href='#'>添加</a>";
					 }
				 }else if(date.getMonth()>d.getMonth()){
					 
						return "没有操作";
				 }
				
			}}
	    ]]
	});
})
function sousuo(){
	var text=$("#date").val();
	//alert(text)
	var ss=$("#dd").val();
	//alert(ss)
	$.ajax({
		url:"<%=path%>/moaWeek/LikeMoaWeek",
		data:{
			id:text,
			date:ss
		},
		success:function(data){
			//alert(data)
			var s=$.parseJSON(data);
			$('#dg').datagrid('loadData', s); 
		}
	})
	return false;
}


//分页
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
		});

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

<body data-options="fit:'true'" style="width: 1000px; height: 800px">
	<!-- 开始布局 -->
	<div class="easyui-layout" style="width: 1000px; height: 600px;">
		<div data-options="region:'north'" style="height: 50px">
			<form>
			<table>
					<tr>
						<td>周数：</td>
						<td>
							<input class="easyui-textbox" style="width:100px;height:32px" id="date" name="id">
						</td>
						<td>&nbsp;&nbsp;&nbsp;</td>
						<td>日期：</td>
						<td>
							<input id="dd" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" name="date"></input>
						</td>
						<td>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</td>
						<td>
							<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px" onclick="return sousuo()">搜索</a>
						</td>
					</tr>
			</table>
			</form>
		</div>
		<div
			data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
			
			<table id="dg">
				
			</table>
			
		</div>
	</div>
</body>
</html>
