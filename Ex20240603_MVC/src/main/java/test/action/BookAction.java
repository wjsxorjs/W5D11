package test.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybatis.dao.BookDAO;
import mybatis.vo.BookVO;

public class BookAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse reponse) {
		// TODO Auto-generated method stub
		BookVO[] b_ar = BookDAO.getList();
		
		// 위에서 얻어낸 사원들의 목록을 request에 "emp"라는 이름으로 저장
		request.setAttribute("book", b_ar);
		
		return "book.jsp"; // 뷰페이지의 경로를 반환한다.
	}

}
