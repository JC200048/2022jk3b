<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.KadaiDataBean"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>一覧</title>
	<style type="text/css">
		html, body {
			height: 100%;
		}
		main {
			min-height: 100vh;
		}
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
		table {
			margin-left: auto;
			margin-right: auto;
			border-collapse: collapse;
			background-color: white;
			border: solid 2px #0D4C92;
		}
		table th, table td {
			border: dashed 1px #0D4C92;
		}
		th, td {
			padding: 30px;
		}
		.formarea {
		text-align: center;
		}
		.buttonarea {
			margin-top: 20px;
		}
	</style>
</head>
<body>
	<header>
		<h1>データの編集</h1>
	</header>
	<main>
		<form class="formarea" method="get" action="select">
			キーワード
			<input type="text" name="keyword">
			<button type="submit" name="submit" value="search">検索</button><br>
			在籍状態
			<input type="radio" name="zaiseki" value="0">0
			<input type="radio" name="zaiseki" value="1">1
			<input type="radio" name="zaiseki" value="2">2
			<input type="radio" name="zaiseki" value="3">3
			<button type="submit" name="submit" value="sousin">送信</button>
			<table>
				<tr>
				<th>選択</th>
				<th>学籍番号</th>
				<th>学生氏名(漢字)</th>
				<th>学生ふりがな</th>
				</tr>
				<%
				//-----受け取ったデータをテーブルに表示する
				int cnt = 0;
				List<KadaiDataBean> data = (ArrayList) request.getAttribute("data");
				if (data != null) {
				    for (KadaiDataBean bean : data) {
					cnt++;;
				%>
				<tr>
					<td><input type="radio" name="student_number" value="<%=cnt%>"id="radio<%=cnt%>"></td>
					<td><label for="radio<%=cnt %>"><%=bean.getStudent_number()%></label></td>
					<td><label for="radio<%=cnt %>"><%=bean.getStudent_name()%></label></td>
					<td><label for="radio<%=cnt %>"><%=bean.getStudent_furigana()%></label></td>
					
				</tr>
				<%		//-----繰り返しを閉じるところ
					}
				}		//------ if を閉じるところ
				%>
			</table>
			<%
			//---キーワードを取得
			String keyword = (String) request.getAttribute("keyword");
			if (keyword == null) {
				keyword = "";
			}
			%>
			<%
			//---zaisekiを取得
			String zaiseki = (String) request.getAttribute("zaiseki");
			if (zaiseki == null) {
				zaiseki = "";
			}
			%>

			<div class="buttonarea">
				<button type="submit" name="submit" value="insert">新規登録</button>
				<button type="submit" name="submit" value="update">編集</button>
			</div>
		</form>
	</main>
</body>
</html>