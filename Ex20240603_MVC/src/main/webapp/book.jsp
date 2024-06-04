<%@page import="mybatis.vo.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>book.jsp</title>
<style>
	#table{
		width: 600px;
		border-collapse: collapse;
	}
	
	#table th, #table td{
		border: 1px solid #ccc;
		padding: 4px;
	}
	
	#table caption{
		text-indent: -9999px;
	}
</style>
</head>
<body>
	<div id="wrap">
		<header>
				<h1>도서 목록</h1>
		</header>
		<article>
			<table id="table">
				<caption>도서 목록 테이블</caption>
				<thead>
					<tr>
						<th>제목</th>
						<th>저자</th>
						<th>춢판일</th>
						<th>가격</th>
					</tr>
				</thead>
				<tbody>
				<%
					Object obj = request.getAttribute("book");
					if(obj != null){
						BookVO[] b_ar = (BookVO[]) obj;
				
						for(BookVO bvo: b_ar){
				%>
						<tr>
							<td><%=bvo.getSubject() %> </td>
							<td><%=bvo.getAuthor() %> </td>
							<td><%=bvo.getReg_date() %>	 </td>
							<td><%=bvo.getPrice() %></td>
						</tr>
				<%
						}
					}
				%>
				</tbody>
			</table>
		</article>
	</div>
	<hr/>
</body>
</html>