<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<style type="text/css">

			
			td{
				width: 100px;
				text-align: center;
			}
</style>
<script type="text/javascript">

<%-- $(function(){
	//查询
	var d;
	var youWant;
	//向数据表格传值
	$('#dg').datagrid({
	    url:'<%=path%>/moaOrderset/selectMoaOrderSetAll',
	    columns:[[
			{field:'id',title:'日期',width:100,formatter: function(value,row,index){
				if(row.moaCookBook==undefined){
					
				}else{
					d=new Date(row.moaCookBook.cdate);
					 youWant=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' ;
					 return youWant;
				}
				/* if(typeof(row.moaCookBook.cdate)=="undefined"){
					return "2019-1-2";
				}else{
					
					alert(row.moaCookBook.cdate)
						 d=new Date(row.moaCookBook.cdate);
						 youWant=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' ' ;
						 return youWant; 
				} */
			}},
			{field:'begindate',title:'菜品',width:200,formatter: function(value,row,index){
				 return row.list;
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
				return "<a href='#'>删除</a><a href='#'>查看</a><a href='#'>添加</a>";
			}}
	    ]]
	});
}) --%>
<%-- function sousuo(){
	$.ajax({
		url:"<%=path%>/moaOrderset/selectMoaOrderSetAll",
		data:{
			id:text,
			date:ss
		},
		success:function(data){
			alert(data)
			var s=$.parseJSON(data);
			$('#dg').datagrid('loadData', s); 
		}
	})
	return false;
} --%>
$(function () {
	$.ajax({
		url:"<%=path%>/moaOrderset/selectMoaOrderSetAll",
		success:function(data){
			//alert(data)
			var hm=$.parseJSON(data);
			$("#dg").empty();
			$("#dg").append(
				"<tr>"
				    +"<td width='100px' align='center'>序号</td>"
				    +"<td width='100px' align='center'> 日期</td>"
				    +"<td width='100px' align='center'>早餐</td>"
				    +"<td width='100px' align='center'>午餐</td>"
				    +"<td width='100px' align='center'>菜品</td>"
				    +"<td width='100px' align='center'>剩余个数</td>"
				    +"<td width='100px' align='center'>以吃个数</td>"
				    /* +"<td>sss</td>"
				    +"<td>ss</td>" */
				+"</tr>"
			)
			//便利 MoaBookAndMoaOrdersetUtil
			var ss=1;
		 	$(hm.rows).each(function(i,n){
		 		$("#dg").append(
						"<tr name='s"+i+"'>"
						+"</tr>"
					)
					$(this.list).each(function (i,n) {
						ss+=1;
						//alert(ss)
					})
					//rowspan=''
				d=new Date(this.moaCookBook.cdate);
				youWant=d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate() + ' '
		 		if(ss>1){
			 		$("tr[name='s"+i+"']").append(
			 			"<td rowspan='"+ss+"'>"+(i+1)+"</td>"	
			 			+"<td rowspan='"+ss+"'>"+youWant+"</td>"	
			 		)
			 		$(this.list).each(function () {
				 		var a;
				 		var b;
				 		if(this.maxcount==undefined){
				 			a=0;
				 		}else{
				 			a=this.maxcount;
				 		}
				 		if(this.nowcount==undefined){
				 			b=0;
				 		}else{
				 			b=this.nowcount;
				 		}
				 		
				 		$("#dg").append(
				 			"<tr>"
							    +"<td>"+this.dish+"</td>"
							    +"<td>"+a+"</td>"
							    +"<td>"+b+"</td>"
							+"</tr>"	
				 		)
						
					})
					$("tr[name='s"+i+"']").append(
			 			"<td rowspan='"+ss+"'>"+this.moaCookBook.breakfast+"</td>"	
			 			+"<td rowspan='"+ss+"'>"+this.moaCookBook.lunch+"</td>"	
			 		)
		 		}else{
		 			//当list 中没有数据时
			 		$("tr[name='s"+i+"']").append(
			 			"<td>"+(i+1)+"</td>"	
			 			+"<td>"+youWant+"</td>"	
			 			+"<td >"+this.moaCookBook.breakfast+"</td>"	
			 			+"<td >"+this.moaCookBook.lunch+"</td>"	
			 			+"<td>没有</td>"
			 			+"<td>未知</td>"
			 			+"<td>未知</td>"
			 		)
		 		}
		 		/* $(this.list).each(function(){
		 			$("tr[name='s"+i+"']").append(
				 			"<td>"+this.dish+"</td>"		
				 		)
		 		}) */
		 		ss=1;
		 	})
		}
	})
})
function reurl(){

    url = location.href; //把当前页面的地址赋给变量 url
    var times = url.split("?"); //分切变量 url 分隔符号为 "?"
    if(times[1] != 1){ //如果?后的值不等于1表示没有刷新
       // url += "?1"; //把变量 url 的值加入 ?1
        self.location.replace(url); //刷新页面
    }
    
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
		
		/* $(function(){
			$('#dg').datagrid({loadFilter:pagerFilter}).datagrid('loadData', getData());
		}); */
</script>
</head>

<body data-options="fit:'true'" style="width: 700px; height: 800px">
	<!-- 开始布局 -->
	<div class="easyui-layout" style="width: 900px; height: 600px;">
		<div data-options="region:'south',split:true" style="height: 50px;"></div>
		<div
			data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
			<table id="dg" border="1px" bordercolor="red">
				<tr>
					<td></td>
				
				</tr>
			</table>
		</div>
	</div>
</body>
</html>
