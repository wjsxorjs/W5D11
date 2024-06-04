<%@page import="mybatis.vo.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp.jsp</title>
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
				<h1>사원 목록</h1>
		</header>
		<article>
			<table id="table">
				<caption>사원 목록 테이블</caption>
				<thead>
					<tr>
						<td colspan="4">
							<select id="searchType">
								<option value="0">::선택::</option>
								<option value="1">사번</option>
								<option value="2">이름</option>
								<option value="3">직종</option>
								<option value="4">부서코드</option>
							</select>
							<input type="text" id="searchValue"/>
							<button type="button" id="btn">검색</button>	
						</td>
					</tr>
					<tr>
						<th>사번</th>
						<th>이름</th>
						<th>직종</th>
						<th>부서코드</th>
					</tr>
				</thead>
				<tbody>
				<%
					Object obj = request.getAttribute("emp");
					if(obj != null){
						EmpVO[] e_ar = (EmpVO[]) obj;
				
						for(EmpVO evo: e_ar){
				%>
						<tr>
							<td><%=evo.getEmpno() %> </td>
							<td><%=evo.getEname() %> </td>
							<td><%=evo.getJob() %>	 </td>
							<td><%=evo.getDeptno() %></td>
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
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script>
		$(function(){
			$("#btn").click(function(){

				let type = $("#searchType").val();
				let value = $("#searchValue").val().trim();
				/*
				if(s_value.length == 0 || s_value == ""){
					alert("검색어를 입력해주세요!");
					$("#searchValue").val("");
					$("#searchValue").focus();
					return;
				}
				*/
				if(type == 0){
					return;
				}
				
				$.ajax({
					url: "Controller",    // MVC는 무조건 Controller로 가야한다
	                type: "POST",              // 요청 방법(GET/POST)
	                data: "type=search"+
	                		"&searchType="+encodeURIComponent(type)+
	                		"&searchValue="+encodeURIComponent(value),
				}).done(function(res){
					$("#table tbody").html(res);
					
					
				});
				
			});
		});
	</script>
</body>
</html>