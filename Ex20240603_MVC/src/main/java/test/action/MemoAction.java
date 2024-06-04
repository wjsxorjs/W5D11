package test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.MemoDAO;
import mybatis.vo.MemoVO;

public class MemoAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse reponse) {
		// TODO Auto-generated method stub
		MemoVO[] m_ar = MemoDAO.getList();
		
		// 위에서 얻어낸 사원들의 목록을 request에 "emp"라는 이름으로 저장
		request.setAttribute("memo", m_ar);
		
		return "memo.jsp"; // 뷰페이지의 경로를 반환한다.
	}

}
