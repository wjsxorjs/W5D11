package test.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;

public class SearchAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse reponse) {
		
		// 파라미터 값(serachType, searchValue) 받기
		
		String searchType = request.getParameter("searchType");
		String searchValue = request.getParameter("searchValue");
		
		Map<String,	String> s_map = new HashMap<>();
		
		
		s_map.put("searchType", searchType);
		s_map.put("searchValue", searchValue);
		
		EmpVO[] e_ar =  EmpDAO.searchList(s_map);
		
		// jsp에서 표현할 수 있도록 request에 저장
		request.setAttribute("s_emp", e_ar);
		
		return "searchEmp.jsp";
	}

}
