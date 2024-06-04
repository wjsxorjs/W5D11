package test.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.DeptDAO;
import mybatis.dao.EmpDAO;
import mybatis.vo.DeptVO;
import mybatis.vo.EmpVO;

public class SearchAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse reponse) {
		
		// 파라미터 값(serachType, searchValue) 받기
		
		String page = request.getParameter("page");
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		
		Map<String,	String> s_map = new HashMap<>();
		String viewPath = null;
		
		s_map.put("searchType", searchType);
		s_map.put("searchValue", searchValue);
		switch(page) {
			case "emp":
				EmpVO[] e_ar =  EmpDAO.searchList(s_map);
				request.setAttribute("s_emp", e_ar);
				viewPath = "searchEmp.jsp";
			case "dept":
				DeptVO[] d_ar =  DeptDAO.searchList(s_map);
				request.setAttribute("s_dept", d_ar);
				viewPath =  "searchDept.jsp";
		
		}
			
		return viewPath;
	}

}
