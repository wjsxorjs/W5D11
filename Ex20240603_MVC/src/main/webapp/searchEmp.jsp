<%@page import="mybatis.vo.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	// request의 s_emp라는 이름으로 저장된 정보를 가져온다.
	Object obj = request.getAttribute("s_emp");
	
	// obj가 비어있지 않을 때만 형변환을 해야 함
	EmpVO[] e_ar = null;
	if(obj != null){
		e_ar = (EmpVO[]) obj;
		
		for(EmpVO evo: e_ar){
%>
			<tr>
				<td><%=evo.getEmpno() %></td>
				<td><%=evo.getEname() %></td>
				<td><%=evo.getJob() %></td>
				<td><%=evo.getDeptno() %></td>
			</tr>
<%
		} // for문의 끝
	}



%>