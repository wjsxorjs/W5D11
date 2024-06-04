package bbs.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse reponse) {
		
		String bname = request.getParameter("bname");
		
		String viewPath = null;
		
		// 글쓰기 화면으로 이동하거나 데이터들을 더 받아서 DB에 저장하거나
		// 둘 중 하나를 하게된다.
		// 현재 액션 객체를 호출하는 곳이 두 군데가 있다.
		// 1) list.jsp에서 [글쓰기]버튼을 클릭했을 때 get방식으로 오게된다.
		// 2) write.jsp에서 [저장]버튼을 클릭했을 때 post방식으로 오게된다.
		
		String enc_type = request.getContentType();
		System.out.println("type: "+enc_type); // GET방식은 null이 나온다
		if(enc_type == null) {
			viewPath = "/jsp/"+bname+"/write.jsp";
		} else if(enc_type.startsWith("multipart")) {
			// 파일이 첨부된 상태에서 현재 객체가 불려진 경우
			// 폼의 enc_type이 multipart....로 지정되었다면
			// 절대로 request.getParameter()로 값을 받지못한다
			// 반드시 cos.jar라는 (외부)라이브러리에 있는 MultipartRequest를
			// 이용해야한다.
			
			// 첨부된 파일이 저장될 곳을 절대경로로 만들어야한다.
			ServletContext application = request.getServletContext();
			String realPath = application.getRealPath("/upload");
			
			
			
			
		}
		
		
		
		return viewPath;
	}

}
