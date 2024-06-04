<%@page import="mybatis.vo.DeptVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	// request의 s_emp라는 이름으로 저장된 정보를 가져온다.
	Object obj = request.getAttribute("s_dept");
	
	// obj가 비어있지 않을 때만 형변환을 해야 함
	DeptVO[] d_ar = null;
	if(obj != null){
		d_ar = (DeptVO[]) obj;
		
		for(DeptVO dvo: d_ar){
%>
			<tr>
				<td><%=dvo.getDeptno() %></td>
				<td><%=dvo.getDname() %></td>
				<td><%=dvo.getLoc_code() %></td>
			</tr>
<%
		} // for문의 끝
	}



%>