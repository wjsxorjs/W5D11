package test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.DeptDAO;
import mybatis.vo.DeptVO;

public class DeptAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse reponse) {
		// TODO Auto-generated method stub
		DeptVO[] d_ar = DeptDAO.getList();
		
		// 위에서 얻어낸 사원들의 목록을 request에 "emp"라는 이름으로 저장
		request.setAttribute("dept", d_ar);
		
		return "dept.jsp"; // 뷰페이지의 경로를 반환한다.
	}

}
