<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.KadaiDataBean"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>データの修正</title>
	<style type="text/css">
		html, body {
			height: 100%;
		}
		body {
			background: linear-gradient(to top, rgba(217, 175, 217, 0.7) 0%, rgba(151, 217, 225, 0.7) 100%),url(inu.png);
			background-repeat: repeat;
			position: fixed;
			height: 100%;
			text-align: center;
    		top: 0px;
    		left:500px;
    		right: 500px;
		}
	</style>
</head>
<body>
	<%
	//---データの取得
	KadaiDataBean bean = (KadaiDataBean) request.getAttribute("data");
	if (bean == null) {
		response.sendRedirect("displayall");
		return;
	}
	
	%>
	<h1>データの修正</h1>
	<form method="get" action="updatego">
		<p>学籍番号：<%=bean.getStudent_number()%></p>  
		<p>学生氏名(漢字)：<input type="text" name="student_name" value="<%=bean.getStudent_name()%>"></p>
		<p>学生ふりがな：<input type="text" name="student_furigana" value="<%=bean.getStudent_furigana()%>"></p>
		<input type="hidden" name="student_number" value="<%=bean.getStudent_number()%>">

		<!-- 
		<p>学生氏名(漢字)：<input type="text" name="simei" value=""></p>
		<p>学生ふりがな：<input type="text" name="simei" value=""></p>
		<input type="hidden" name="id" value="">
		-->
		<button type="submit" name="submit" value="1">変更</button>
		<button type="submit" name="submit" value="2">キャンセル</button>
		<button type="reset">リセット</button> 
		
	</form>
</body>
</html>