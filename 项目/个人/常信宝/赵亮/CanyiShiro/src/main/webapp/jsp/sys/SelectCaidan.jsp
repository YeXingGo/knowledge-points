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
