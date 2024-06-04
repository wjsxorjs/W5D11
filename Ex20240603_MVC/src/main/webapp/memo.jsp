<%@page import="mybatis.vo.MemoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memo.jsp</title>
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
				<h1>메모 목록</h1>
		</header>
		<article>
			<table id="table">
				<caption>메모 목록 테이블</caption>
				<thead>
					<tr>
						<th>내용</th>
						<th>작성자</th>
						<th>IP</th>
						<th>작성일자</th>
					</tr>
				</thead>
				<tbody>
				<%
					Object obj = request.getAttribute("memo");
					if(obj != null){
						MemoVO[] m_ar = (MemoVO[]) obj;
				
						for(MemoVO mvo: m_ar){
				%>
						<tr>
							<td><%=mvo.getContent() %> </td>
							<td><%=mvo.getWriter() %> </td>
							<td><%=mvo.getIp() %>	 </td>
							<td><%=mvo.getWrite_date() %></td>
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