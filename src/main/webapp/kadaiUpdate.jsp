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
		<p>ID：<%=bean.getStudent_number()%></p>
		<p>氏名：<input type="text" name="simei" value="<%=bean.getName()%>"></p>
		<input type="hidden" name="id" value="<%=bean.getId()%>">
		<button type="submit" name="submit" value="1">変更</button>
		<button type="submit" name="submit" value="2">キャンセル</button>
		<button type="reset">リセット</button>
	</form>
</body>
</html>