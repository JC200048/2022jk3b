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
		table {
			border-collapse: collapse;
		}
		table, th, td {
			border: solid 1px #000000;
		}
		th, td {
			padding: 30px;
		}
		.formarea {
		margin-left: 30px;
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
			<button type="submit" name="submit" value="search">検索</button>
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

			<div class="buttonarea">
				<button type="submit" name="submit" value="insert">新規登録</button>
				<button type="submit" name="submit" value="update">編集</button>
			</div>
		</form>
	</main>
</body>
</html>