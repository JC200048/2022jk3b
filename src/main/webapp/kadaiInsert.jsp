<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>データの追加</title>
	<style type="text/css">
		body {
			height: 100%;
			text-align: center;
			background: linear-gradient(to top, rgba(217, 175, 217, 0.7) 0%, rgba(151, 217, 225, 0.7) 100%),url(inu.png);
			background-repeat: repeat;
			position: fixed;
    		top: 0px;
    		left:500px;
    		right: 500px;
		}
		a {
			text-decoration: none;
		}
	
		.buttonImage {
			display: inline-block;
			font-size: 0.8em;
			background-color: #eeeeee;
			border: solid 1px #333333;
			border-radius: 3px;
			color: #000000;
			width: fit-content;
			padding: 2px 5px;
			text-align: center;
			text-decoration: none;
			cursor: arrow;
		}
	
		.buttonImage:hover {
			background-color: #dddddd;
		}
	</style>
</head>
<body>
	<%
	List<String> list = (ArrayList<String>) request.getAttribute("message");
	if (list != null) {
		for (String message : list) {
		%>
		
		<p><%=message%></p>
		<%
		}   //---forを閉じるカッコ
	}       //---ifを閉じるカッコ
	%>
	
	<a href="displayall"><span class="buttonImage">一覧へ戻る</span></a>
</body>
</html>