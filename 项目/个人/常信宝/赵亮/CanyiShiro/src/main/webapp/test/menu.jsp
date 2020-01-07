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

<link rel="stylesheet" type="text/css" href="<%=path%>/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/themes/demo.css">
<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery.easyui.min.js"></script>


<!-- <link rel="stylesheet" type="text/css" href="../../themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../../themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../demo.css">
	<script type="text/javascript" src="../../jquery.min.js"></script>
	<script type="text/javascript" src="../../jquery.easyui.min.js"></script> -->

</head>

<body>
<h2>Basic SideMenu</h2>
	<p>Collapse the side menu to display the main icon.</p>
<div style="margin:20px 0;">
		<a href="javascript:;" class="easyui-linkbutton" onclick="toggle()">Toggle</a>
	</div>
	<div id="sm" class="easyui-sidemenu" data-options="data:data"></div>
	<script type="text/javascript">
		var data = [{
	        text: 'Item1',
	        iconCls: 'icon-sum',
	        state: 'open',
	        children: [{
	            text: 'Option1'
	        },{
	            text: 'Option2'
	        },{
	            text: 'Option3',
	            children: [{
	                text: 'Option31'
	            },{
	                text: 'Option32'
	            }]
	        }]
	    },{
	        text: 'Item2',
	        iconCls: 'icon-more',
	        children: [{
	            text: 'Option4'
	        },{
	            text: 'Option5'
	        },{
	            text: 'Option6'
	        }]
	    }];
 
		function toggle(){
			var opts = $('#sm').sidemenu('options');
			$('#sm').sidemenu(opts.collapsed ? 'expand' : 'collapse');
			opts = $('#sm').sidemenu('options');
			$('#sm').sidemenu('resize', {
				width: opts.collapsed ? 60 : 200
			})
		}
	</script>

	
</body>
</html>
