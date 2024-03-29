<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/themes/demo.css">
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>
<script>
	function submitForm() {
		$('#ff').form('submit');
	}
	function clearForm() {
		$('#ff').form('clear');
	}
</script>
</head>
<body>

	<div class="easyui-layout" style="width: 700px; height: 600px;">
		<div data-options="region:'north'" style="height: 50px"></div>
		<div data-options="region:'south',split:true" style="height: 50px;"></div>
		<div data-options="region:'east',split:true" title="East"
			style="width: 100px;"></div>
		<div data-options="region:'west',split:true" title="West"
			style="width: 100px;"></div>
		<div
			data-options="region:'center',title:'Main Title',iconCls:'icon-ok'">
			<div class="easyui-panel" title="New Topic" style="width: 600px">
				<div style="padding: 10px 60px 20px 60px">
					<form id="ff" method="post">
						<table cellpadding="5">
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
							<tr>
								<td>Message:</td>
								<td><input class="easyui-textbox" name="message"
									data-options="multiline:true" style="height: 60px"></input></td>
							</tr>
							<tr>
								<td>Language:</td>
								<td><select class="easyui-combobox" name="language"><option
											value="ar">Arabic</option>
										<option value="bg">Bulgarian</option>
								</select></td>
							</tr>
							<tr>
								<td><input class="easyui-combobox" name="language"
									data-options="
						url:'<%=path%>/moaWeek/getAllMoaWeek',
						method:'get',
						valueField:'id',
						textField:'text',
						multiple:true,
						panelHeight:'auto'
						"></td>

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
	</div>
</body>
</html>