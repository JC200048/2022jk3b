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
			<table>
				<tr>
				<th>選択</th>
				<th>学籍番号</th>
				<th>在籍状態</th>
				<th>在籍状態確定日</th>
				<th>学生氏名(漢字)</th>
				<th>学生ふりがな</th>
				<th>生年月日</th>
				<th>本人郵便番号</th>
				<th>本人住所</th>
				<th>本人電話番号</th>
				<th>本人メールアドレス</th>
				<th>保護者氏名(漢字)</th>
				<th>保護者ふりがな</th>
				<th>保護者郵便番号</th>
				<th>保護者住所</th>
				<th>保護者電話番号</th>
				<th>保護者メールアドレス</th>
				</tr>
				<%  //-----受け取ったデータをテーブルに表示する
				List<KadaiDataBean> data = (ArrayList) request.getAttribute("data");
				int cnt = 0;
				for (KadaiDataBean bean : data) {
					cnt++;%>
				<tr>
					<td><input type="radio" name="id" value="<%=cnt%>"id="radio<%=cnt%>"></td>
					<td><label for="radio<%=cnt %>"><%=bean.getStudent_number()%></label></td>
					<td><label for="radio<%=cnt %>"><%=bean.getEnrollment_status()%></label></td>
					<td><label for="radio<%=cnt %>"><%=bean.getEnrollment_confirmation_date()%></label></td>
					<td><label for="radio<%=cnt %>"><%=bean.getStudent_name()%></label></td>
					<td><label for="radio<%=cnt %>"><%=bean.getStudent_furigana()%></label></td>
					<td><label for="radio<%=cnt %>"><%=bean.getBirthday()%></label></td>
					<td><label for="radio<%=cnt %>"><%=bean.getStudent_post_code()%></label></td>
					<td><label for="radio<%=cnt %>"><%=bean.getStudent_address()%></label></td>
					<td><label for="radio<%=cnt %>"><%=bean.getStudent_phone_number()%></label></td>
					<td><label for="radio<%=cnt %>"><%=bean.getStudent_mail_address()%></label></td>
					<td><label for="radio<%=cnt %>"><%=bean.getParent_name()%></label></td>
					<td><label for="radio<%=cnt %>"><%=bean.getParent_furigana()%></label></td>
					<td><label for="radio<%=cnt %>"><%=bean.getParent_post_code()%></label></td>
					<td><label for="radio<%=cnt %>"><%=bean.getParent_address()%></label></td>
					<td><label for="radio<%=cnt %>"><%=bean.getParent_phone_number()%></label></td>
					<td><label for="radio<%=cnt %>"><%=bean.getParent_mail_address()%></label></td>
				</tr>
				<%  //-----繰り返しを閉じるところ
				}
				%>
			</table>
			<div class="buttonarea">
				<button type="submit" name="submit" value="insert">新規登録</button>
			</div>
		</form>
	</main>
</body>
</html>