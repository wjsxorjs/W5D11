package test.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;

public class EmpAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse reponse) {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		EmpVO[] e_ar = null;
		
		
		e_ar = EmpDAO.getList();
		
		
		
		// 위에서 얻어낸 사원들의 목록을 request에 "emp"라는 이름으로 저장
		request.setAttribute("emp", e_ar);
		
		return "emp.jsp"; // 뷰페이지의 경로를 반환한다.
	}

}
