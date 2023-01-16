<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.KadaiDataBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<p>学生氏名(漢字)：<input type="text" name="simei" value="<%=bean.getStudent_name()%>"></p>
		<p>学生ふりがな：<input type="text" name="simei" value="<%=bean.getStudent_furigana()%>"></p>
		<input type="hidden" name="id" value="<%=bean.getStudent_number()%>">
		<button type="submit" name="submit" value="1">変更</button>
		<button type="submit" name="submit" value="2">キャンセル</button>
		<button type="reset">リセット</button>
	</form>
</body>
</html>